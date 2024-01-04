/*
 * Set up a connection to a WiFi access point and get content from an HTTP server.
 * Based on the BasicHTTPClient example at https://github.com/espressif/arduino-esp32/.
 */

#include <WiFiMulti.h>
#include <HTTPClient.h>

const char *SSID = "<your-ssid>";
const char *PASSWORD = "<your-password>";
const char *ENDPOINT = "http://demo.martiningram.uk/api/test/";

const int WIFI_TIMEOUT = 500;
const int SLEEP = 5000;

WiFiMulti wifi;

/**
 * Microcontroller setup.
 */
void setup() {
  setupConsole();
  connectToWiFi();
}

/*
 * Set up the console.
 */
void setupConsole() 
{
  Serial.begin(115200);
  delay(10);
}

/*
 * Connect to a WiFi access point.
 */
void connectToWiFi() 
{
  Serial.print("Connecting to WiFi");
  wifi.addAP(SSID, PASSWORD);
  Serial.print("..");
  waitForWiFi();
  Serial.println(".");
  Serial.print("Connected, IP address: ");
  Serial.println(WiFi.localIP());
}

/*
 * Wait for the WiFi to connect.
 */
void waitForWiFi()
{
  while(wifi.run() != WL_CONNECTED) {
    Serial.print(".");
    delay(WIFI_TIMEOUT);
  }
}

/**
 * The microcontroller loop.
 */
void loop() 
{
  httpGet();
  delay(SLEEP);
}

/**
 * Example HTTP Get call.
 */
void httpGet() 
{
  HTTPClient http;
  http.begin(ENDPOINT);
  int httpCode = http.GET();
  if (httpCode > 0) {
    Serial.print("Response code = ");
    Serial.println(httpCode);
    if (httpCode == HTTP_CODE_OK) {
      String payload = http.getString();
      Serial.println(payload);
    } else {
      Serial.print("GET failed. Error: ");
      Serial.println(http.errorToString(httpCode));
    }
  } 
  http.end();
}
