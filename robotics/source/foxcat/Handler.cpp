#include <Arduino.h>
#include "Handler.h"
#include "State.h"

Handler::Handler() {
  init();
  this->changeState("idle");
};

void Handler::init() {
  this->allStates[0].init("idle");
  this->allStates[1].init("begin");
  this->allStates[2].init("recognition");
  this->allStates[3].init("playtime");
  this->allStates[4].init("end");
}

bool Handler::changeState(String stateName) {
  for (int i = 0; i < 5; i++) {
    if (allStates[i].name.equals(stateName)) {
      this->currentState = allStates[i];
      return 1;
    }
  }
  return 0;
};
