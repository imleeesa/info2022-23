#include "Handler.h";
//#include "State.h";
#include <Arduino.h>

Handler::Handler(){
    states[0].init("idle", 0);/*, State("begin", 1), State("recognition", 2), State("playTime", 3), State("end", 4)*/

    //this->currentState=this->states[0];
};

bool Handler::changeState(String stateName)
{
    for (int i = 0; i < 5; i++)
    {
        if (states[i].name.equals(stateName))
            this->currentState = states[i];
            return 1;
    }
    return 0;
};

State Handler::getState(String stateName)
{
    for (int i = 0; i < 5; i++)
    {
        if (states[i].name.equals(stateName))
            return states[i];
    }
    return State();
};
