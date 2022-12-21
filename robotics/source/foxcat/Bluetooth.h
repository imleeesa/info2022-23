#ifndef Bluetooth_h
#define Bluetooth_h

#include <Arduino.h>
#include <SoftwareSerial.h>

class Bluetooth {
  private:
    char pinTx;
    char pinRx;
    SoftwareSerial bluetooth;
  public:
    Bluetooth(char pinTx, char pinRx);
    void init();
    boolean available();
    String read();
    void write(String msg);
};
#endif
