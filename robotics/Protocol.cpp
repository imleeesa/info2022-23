#include "Protocol.h"
#include "State.cpp"
#include <Arduino.h>
/*
MachineCodes:
-00 BROADCAST
-01 Pinocchio
-02 GatoVolpy

ActionCodes: 
-00 Null, idk ill add later
-01 State
-02 Motori AC UNIMPL
-03 Servo UNIMPL

Servo subprotocol(raw data): 
    * 
    * 
*/

Protocol::Protocol(String mC, StateHandler s)
{
    this->machineCode = mC;
    this->handler=s;
}

bool Protocol::decodeProto(String raw)
{
    String mC = raw.substring(3, 6), aC = raw.substring(0, 3), data = raw.substring(0, 3);
    if (mC.equals(this->machineCode) || mC.equals("0")){
        if (aC.equals("00"))
        {
            return 0;
        }
        if (aC.equals("01")){   //State

            return 1;
        }
    }
    return 0;
}

bool Protocol::encode(String mC, String aC, String raw)
{
    this->awaitSerial();
    Serial2.print(aC + mC + raw);
}

void Protocol::awaitSerial(){
    while(!Serial2.available());
}
