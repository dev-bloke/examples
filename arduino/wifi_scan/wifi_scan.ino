/*
 *  Scan available WiFi networks.
 *  This is based on one of the supplied Arduino examples.
 */
#include "WiFi.h"

void setup()
{
    Serial.begin(115200);
    setupWifi();
    Serial.println("Setup done");
}

/*
 *  Set WiFi to station mode and disconnect from an access point if it was previously connected.
 */
void setupWifi() 
{
    WiFi.mode(WIFI_STA);
    WiFi.disconnect();
    delay(100);
}

void loop()
{
    Serial.println("Scan start...");
    int n = WiFi.scanNetworks();
    Serial.println("...scan done");
    if (n == 0) {
        Serial.println("No networks found.");
    } else {
        Serial.print(n);
        Serial.println(" networks found.");
        Serial.println("Nr | SSID                             | RSSI | CH | Encryption");
        for (int i = 0; i < n; ++i) {
            printWiFiDetails(i);
        }
    }
    Serial.println("");
    WiFi.scanDelete();
    delay(5000);
}

/*
 * Print SSID and RSSI for each network found
 */
void printWiFiDetails(int i) 
{
    Serial.printf("%2d",i + 1);
    Serial.print(" | ");
    Serial.printf("%-32.32s", WiFi.SSID(i).c_str());
    Serial.print(" | ");
    Serial.printf("%4d", WiFi.RSSI(i));
    Serial.print(" | ");
    Serial.printf("%2d", WiFi.channel(i));
    Serial.print(" | ");
    Serial.print(determineWiFiType(i));
    Serial.println();
    delay(10);
}

/*
 * Determine the WiFi network type.
 */
char* determineWiFiType(int i) 
{
    char* wiFiType;
    switch (WiFi.encryptionType(i))
    {
    case WIFI_AUTH_OPEN:
        wiFiType = "open";
        break;
    case WIFI_AUTH_WEP:
        wiFiType = "WEP";
        break;
    case WIFI_AUTH_WPA_PSK:
        wiFiType = "WPA";
        break;
    case WIFI_AUTH_WPA2_PSK:
        wiFiType = "WPA2";
        break;
    case WIFI_AUTH_WPA_WPA2_PSK:
        wiFiType = "WPA+WPA2";
        break;
    case WIFI_AUTH_WPA2_ENTERPRISE:
        wiFiType = "WPA2-EAP";
        break;
    case WIFI_AUTH_WPA3_PSK:
        wiFiType = "WPA3";
        break;
    case WIFI_AUTH_WPA2_WPA3_PSK:
        wiFiType = "WPA2+WPA3";
        break;
    case WIFI_AUTH_WAPI_PSK:
        wiFiType = "WAPI";
        break;
    default:
        wiFiType = "unknown";
    }
    return wiFiType;
}
