#ifndef Handler_h
#define Handler_h
#include <Arduino.h>
#include "State.h"

class Handler{
public:
    State currentState;
    State states[5];

    Handler();

    bool changeState(String stateName);
    State getState(String stateName);

};

#endif
