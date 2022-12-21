from ..data.arduino import Arduino
from ..data.logger import Logger, LogLevel
from ..camera.camera import Camera     #commentato solo per test
from .drivers.motor_driver import MotorsDriver
from .drivers.servo_driver import ServoDriver
from ..bt.bluetooth import Bluetooth

import time


class Robot:
    def __init__(self, pins, btPort):
        try:
            self.camera = Camera() #--- commentato per test servo, SCOMMENTARE
            # self.camera = None  # solo per test
            # creating motors driver object instance
            self.motorsDriver = MotorsDriver(3, 5, 7, 10, 8, 12)
            # creating servo driver object instance
            self.servoDriver = ServoDriver()
            self.btServer = Bluetooth(btPort)
            Logger.log(LogLevel.INFO, 'Robot instance created')
        except Exception as e:
            Logger.log(LogLevel.ERROR, str(e))

    def stop(self):
        self.motorsDriver.stop()

    def begin(self):
        Logger.log(LogLevel.INFO, 'Loading camera for event BEGIN')
        x = self.camera.read_word_bis('SCHOOL')
        Logger.log(LogLevel.INFO, 'Returned true')
        return True

    def waitStartSign(self):
        Logger.log(LogLevel.INFO, 'Loading camera for event BEGIN')
        x = self.camera.read_word_bis('START')  #START
        Logger.log(LogLevel.INFO, 'Returned true')
        return True

    # motors
    def reach_cf(self):
        Logger.log(LogLevel.INFO, 'Reaching cat and fox')
        self.forward()
        time.sleep(5)
        self.stop()

    def turn_right(self):
        self.motorsDriver.turn_right()

    def turn_left(self):
        self.motorsDriver.turn_left()

    def goBack(self):
        self.motorsDriver.go_back()

    def forward(self):
        Logger.log(LogLevel.INFO, 'Going forward')
        self.motorsDriver.go_forward()

    # servos
    def greet(self):
        self.servoDriver.greet()

    def relax(self):
        self.servoDriver.relax()

    def forwardServo(self):
        self.servoDriver.forward()

    # bt
    def changeState(self, state):
        self.btServer.sendCommand(state)
