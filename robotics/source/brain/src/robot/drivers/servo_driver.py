from ...data.logger import Logger, LogLevel
from enum import Enum
from .maestro import Controller
import time

class Servo(Enum):
    RIGHT_SHOULDER = 0
    LEFT_SHOULDER = 1
    RIGHT_ARM = 2
    LEFT_ARM = 3
    VERT_NECK = 4
    HOR_NECK = 5
    RIGHT_ELBOW = 6
    LEFT_ELBOW = 7

class ServoDriver:
    def __init__(self):
        self.driver = Controller()
        # settings all servos acceleration
        for i in range(8):
            self.driver.setAccel(i, 4)
        Logger.log(LogLevel.INFO, 'Servo driver instance created')
        
    def move(self):
        pass

    def greet(self):
        self.driver.setTarget(Servo.RIGHT_SHOULDER.value, 1000)
        self.driver.setTarget(Servo.LEFT_SHOULDER.value, 1000)
        time.sleep(2)
        self.driver.setTarget(Servo.RIGHT_SHOULDER.value, 10000)
        self.driver.setTarget(Servo.LEFT_SHOULDER.value, 10000)

    def relax(self):
        self.driver.setTarget(Servo.RIGHT_SHOULDER.value, 0)
        self.driver.setTarget(Servo.LEFT_SHOULDER.value, 0)
        self.driver.setTarget(Servo.RIGHT_ARM.value, 0)
        self.driver.setTarget(Servo.LEFT_ARM.value, 0)

    def forward(self):
        self.driver.setTarget(Servo.RIGHT_ARM.value, 10000)
        self.driver.setTarget(Servo.LEFT_ARM.value, 10000)
        
        

