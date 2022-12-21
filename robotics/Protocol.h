#ifndef Protocol_h
#define Protocol_h
#include <Arduino.h>
/*
MachineCodes:
-00 BROADCAST
-01 Pinocchio
-02 GatoVolpy
-03 Ruota

ActionCodes: 
-00 Null, idk ill add later
-01 State
-02 Motori AC
-03 Servo
-04 
*/
class Protocol
{
public:
    String machineCode;
    StateHandler handler;
    const String BROADCAST = "00", PINOCCHIO = "01", GATTOVOLPE = "02", RUOTA = "03";
    const String STATE = "01", AC="02", SERVO="03";

    Protocol(String mC, Serial s, StateHandler s);

    bool decodeProto(String raw);

    bool encode(String mC, String aC, String raw);

    

private:
    void awaitSerial();
    
};
#endif
