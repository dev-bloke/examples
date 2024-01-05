/*
 * Detects wifi devices in the vicinity.
 */

#include <WiFi.h>
#include <WiFiMulti.h>

#include <string.h>

#include "esp_log.h"
#include "esp_wifi.h"
#include "esp_event.h"
#include "esp_wifi.h"

typedef struct {
  uint8_t mac[6];
} __attribute__((packed)) MacAddress;

typedef struct {
  uint16_t fctl;
  uint16_t duration;
  MacAddress da;
  MacAddress sa;
  MacAddress bssid;
  uint16_t seqctl;
  unsigned char payload[];
} __attribute__((packed)) WiFiManagementHeader;

#define SLEEP 5000
#define MAX_CHANNEL 13
#define MAX_DEVICES 64

const wifi_promiscuous_filter_t filter ={
    .filter_mask=WIFI_PROMIS_FILTER_MASK_MGMT
};

int channel = 0;
int devices = 0;

String id[MAX_DEVICES];
int signalStrength[MAX_DEVICES];

/*
 * Microcontroller setup.
 */
void setup() 
{
   resetDevices();
   setupConsole();
   setupPromiscuousWiFi();
}

/*
 * Set up the serial console.
 */ 
void setupConsole() 
{
  Serial.begin(115200);
  delay(10);
}

void setupPromiscuousWiFi() 
{
  Serial.print("Setting up promiscuous mode...");
  wifi_init_config_t config = WIFI_INIT_CONFIG_DEFAULT();
  esp_wifi_init(&config);
  esp_wifi_set_storage(WIFI_STORAGE_RAM);
  esp_wifi_set_mode(WIFI_MODE_NULL);
  esp_wifi_start();
  esp_wifi_set_promiscuous(true);
  esp_wifi_set_promiscuous_filter(&filter);
  esp_wifi_set_promiscuous_rx_cb(&sniffer);
  nextChannel();
  Serial.println(". done.");
}

/*
 * Main microcontroller loop.
 */
void loop() 
{
  nextChannel();
  delay(SLEEP);
}

void resetDevices() {
  devices = 0;
  for (int i = 0; i < MAX_DEVICES; i++) {
    id[i] = "";
    signalStrength[i] = 0;
  }
}

void nextChannel() 
{
  if (channel == MAX_CHANNEL) {
    channel = 1;
    recordAllDevices();
    resetDevices();
  } else {
    channel++;
  }
  esp_wifi_set_channel(channel, WIFI_SECOND_CHAN_NONE);
  Serial.printf("Channel set to %i\n", channel);
}

/*
 * Record all the devices found in this pass.
 */
void recordAllDevices() {
  Serial.println("=================================");
  if (devices > 0) {
    Serial.printf("%i device(s) found:\n", devices);
    for (int i = 0; i < devices; i++) {
      String output = formatForOutput(id[i], signalStrength[i]);
      Serial.println(output);
    }
  } else {
    Serial.println("No devices found.");
  }
  Serial.println("=================================");
}

/**
 * Packet sniffing.
 */
void sniffer(void* buffer, wifi_promiscuous_pkt_type_t type) 
{ 
  wifi_promiscuous_pkt_t *packet = (wifi_promiscuous_pkt_t*) buffer;
  int length = packet->rx_ctrl.sig_len;
  WiFiManagementHeader *header = (WiFiManagementHeader*)packet->payload;
  if (checkData(header, length)) {
    String mac = getMacAddressess(header);
    int rssi = packet->rx_ctrl.rssi;
    if (updateDeviceList(mac, rssi)) {
      String output = formatForOutput(mac, rssi);
      Serial.println(output);
    }
  }
}

/*
 * Check that we have some meaningful data.
 */
bool checkData(WiFiManagementHeader* header, int length)
{
  int size = length - sizeof(WiFiManagementHeader);
  return (size >= 0) && ((header->fctl & 0x00FC) == 0x0040);
}

/*
 * Get the MAC address.
 */
String getMacAddressess(WiFiManagementHeader* header) 
{
  String mac;
  uint8_t* sa = header->sa.mac;
  for (int i=0; i<6; i++)
  {
    mac += String(sa[i], HEX);
    if (i < 5) {
      mac += String(":");
    }
  }
  mac.toUpperCase();
  return mac;
}

/*
 * Update the device list.
 */
bool updateDeviceList(String mac, int rssi)
{
  bool added = false;
  for (int i = 0; i < MAX_DEVICES; i++) {
    if (id[i] == "") {
      id[i] = mac;
      signalStrength[i] = rssi;
      added = true;
      devices++;
      break;
    } else if (id[i] == mac) {
      signalStrength[i] = rssi;
      break;
    }
  }
  return added;
}

/*
 * Create a string representation of the MAC and RSSI.
 */
String formatForOutput(String mac, int rssi)
{
  String output = "MAC: ";
  output += mac;
  output += ", RSSI: ";
  output += rssi;
  return output;
}
