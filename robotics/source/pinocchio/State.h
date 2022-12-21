#ifndef State_h
#define State_h
#include <Arduino.h>

class State{
public:
    String name;
    int number;

    //State();
    init(String s, int n);
};
#endif
