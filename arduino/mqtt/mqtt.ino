#include <ArduinoMqttClient.h>
#include <WiFi.h>
#include <WiFiMulti.h>
#include "secrets.h"

const int WIFI_TIMEOUT = 500;
const int SLEEP = 5000;

const char BROKER[] = "<Your MQTT broker FQDN>";
const int PORT = 1883;
const char TOPIC[] = "test";
const char DEVICE[] = "ESP32S #1";

WiFiMulti wifi;
WiFiClient wifiClient;
MqttClient mqttClient(wifiClient);

// ---- SETUP ----

/**
 * Device setup.
 */
void setup() {
  setupConsole();
  connectToWiFi();
  connectToBroker();
}

/*
 * Set up the console.
 */
void setupConsole() {
  Serial.begin(115200);
  while (!Serial) {
    ; // Wait for the serial port to connect.
  }
}

/*
 * Connect to a WiFi access point.
 */
void connectToWiFi() {
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
void waitForWiFi() {
  while(wifi.run() != WL_CONNECTED) {
    Serial.print(".");
    delay(WIFI_TIMEOUT);
  }
}

/*
 * Connect to the MQTT broker.
 */
void connectToBroker() {
  if (!mqttClient.connect(BROKER, PORT)) {
    Serial.print("MQTT connection failed. Error code = ");
    Serial.println(mqttClient.connectError());
    while (1);
  }
  Serial.print("Connected to ");
  Serial.print(BROKER);
  Serial.print(":");
  Serial.println(PORT);
}

// ---- LOOP ----

/**
 * The main runtime loop.
 */
void loop() {
  mqttClient.poll(); // This keeps the connection alive.
  Serial.print("Sending message...");
  sendMessage();
  Serial.println(" Done!");
  delay(SLEEP);
}

/**
 * Send an MQTT message to a topic.
 */
void sendMessage() {
  mqttClient.beginMessage(TOPIC);
  mqttClient.print("Hello from ");
  mqttClient.print(DEVICE);
  mqttClient.endMessage();
}

