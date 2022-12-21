import serial
import time
port = serial.Serial("/dev/rfcomm0", baudrate=9600)
 
# reading and writing data from and to arduino serially.                                      
# rfcomm0 -> this could be different
while True:
	port.write(bytes(input("invia un comando: ").replace("\n","").encode()))
