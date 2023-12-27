/*
 * Set up a connection to a WiFi access point and get content from an HTTP server.
 * Based on the WiFiClientBasic example at https://github.com/espressif/arduino-esp32/.
 */

#include <WiFi.h>
#include <WiFiMulti.h>

const char *SSID = "<Your WiFi Access Point>";
const char *PASSWORD = "<WiFi Password>";
const char *HOST = "<Your Server>";
const uint16_t PORT = 8080;
const char *ENDPOINT = "GET /api/test/\n\n";

const int HTTP_TIMEOUT = 1000;
const int WIFI_TIMEOUT = 500;
const int SLEEP = 5000;

WiFiMulti wifi;
WiFiClient client;

/*
 * Initial setup.
 */
void setup() 
{
  setupConsole();
  connectToWiFi();
}

/*
 * Main runtime loop.
 */
void loop() 
{
  if (connectToHost()) {
    sendRequestToServer();
  }
  closeConnection();
  delay(SLEEP);
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

/*
 * Connect to the server.
 */
int connectToHost()
{
  Serial.println("Connecting to host...");
  int result = client.connect(HOST, PORT);
  if (!result) {
    Serial.println("The attempt to connect to the server failed.");
    Serial.println("Waiting 5 seconds before retrying...");
  }
  return result;
}

/*
 * Send an HTTP request to the server.
 */
void sendRequestToServer()
{
  sendHTTPRequest();
  waitForResponse();
  readResponse();
}

/*
 * Send an HTTP request.
 */
void sendHTTPRequest() 
{
  client.print(ENDPOINT);
}

/*
 * Wait for a response from the server.
 */
void waitForResponse()
{
  int attempts = 0;
  while (!client.available() && attempts < HTTP_TIMEOUT) {
    attempts++;
    delay(1);
  }
}

/*
 * Read the response from the server.
 */
void readResponse()
{
  if (client.available()) {
    String line = client.readStringUntil('\r');
    Serial.println(line);
  }
  else {
    Serial.println("Request timed out.");
  }
}

/*
 * Close the connection.
 */
void closeConnection()
{
  Serial.println("Closing connection.");
  client.stop();
  Serial.println("Waiting 5 seconds before restarting...");
}
