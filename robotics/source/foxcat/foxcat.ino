#include "Bluetooth.h"
#include "Handler.h"
#include "Motor.h"
#include "State.h"

Bluetooth bt = Bluetooth(10, 11);
Handler sh = Handler();
MotorController mc = MotorController();

void setup() {
  Serial.begin(9600);
}

void loop() {
  String received = bt.read();
  if (received != "" && received != sh.currentState.name) {
    sh.changeState(received);
    if (sh.currentState.name == "idle") {
      idle();
    } else if (sh.currentState.name == "begin") {
      // begin();
      up();
    } else if (sh.currentState.name == "recognition") {
      // recognition();
      down();
    } else if (sh.currentState.name == "playtime") {
      // playtime();
      left();
    } else if (sh.currentState.name == "end") {
      // end();
      right();
    }
  }
}

void idle() {
  
}

void begin() {

}

void recognition() {

}

void playtime() {
  // Movimenti casuali per simulare dei giochi
}

void end() {
  exit(0);
}

void up() {
  mc.goForward(3500);
}


void down() {
  mc.goBack(3500);
}

void left() {
  mc.turnRight(2100);
}


void right() {
  mc.turnLeft(2300);
}
