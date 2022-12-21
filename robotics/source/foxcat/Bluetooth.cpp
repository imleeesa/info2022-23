#include <Arduino.h>
#include "Bluetooth.h"

Bluetooth::Bluetooth(char pinTx, char pinRx): bluetooth(pinTx, pinRx) {
  this->pinTx = pinTx;
  this->pinRx = pinRx;
  init();
}

void Bluetooth::init() {
  this->bluetooth.begin(9600);
}

boolean Bluetooth::available() {
  return this->bluetooth.available() > 0;
}

String Bluetooth::read() {
  String msg;
  while (this->bluetooth.available()) {
    delay(10);
    if (this->bluetooth.available() > 0) {
      char c = bluetooth.read();
      msg.concat(c);
    }
  }
  return msg;
}

void Bluetooth::write(String msg) {
  this->bluetooth.print(msg);
}
