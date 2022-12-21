#ifndef Handler_h
#define Handler_h
#include <Arduino.h>
#include "State.h"

class Handler {
  private:
    State allStates[5];
  public:
    State currentState;
    Handler();
    void init();
    bool changeState(String stateName);
};
#endif
