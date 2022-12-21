import serial

class Bluetooth():
    def __init__(self, port):
        #port example: /dev/rfcomm0
        self.port = serial.Serial(port, baudrate=9600)

    def sendCommand(self, message):
        self.port.write(bytes(message.replace("\n", "").encode()))