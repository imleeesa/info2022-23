import serial
from .logger import Logger, LogLevel

class Arduino:
    def __init__(self, port):
        try:
            self.port = port
            self.conn = serial.Serial(self.port, 9600, timeout=1)
            self.conn.flush()
            Logger.log(LogLevel.INFO, 'Arduino instance created')
        except Exception as e:
            Logger.log(LogLevel.ERROR, e)

    def read(self):
        msg = ''
        # wait for message
        while self.conn.in_waiting <= 0:
            pass
        # read the full message
        while self.conn.in_waiting > 0:
            line = self.conn.readline().decode('utf-8').rstrip()
            msg += line
        return msg
    
    def write(self, message: str):
        self.conn.write((message + '\n').encode('utf-8'))