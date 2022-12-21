import RPi.GPIO as GPIO
from ...data.logger import Logger, LogLevel
import time

class Motor:
    '''
    class Motor
    ...
    Attributes:
    -----------
    enable : int
        this is the pin used for motor speed, PWM
    ou1 : int
        this is the first motor pin
    ou2 : int
        this is the secondo motor pin
    '''
    def __init__(self, enable, out1, out2, speed):
        self.enable = enable
        GPIO.output(self.enable, True)
        GPIO.PWM(enable, speed)
        self.out1 = out1
        self.out2 = out2
    
    def setSpeed(self, speed):
        pass

    def forward(self):
        GPIO.output(self.enable, True)
        GPIO.output(self.out1, True)
        GPIO.output(self.out2, False)
        return True

    def stop(self):
        GPIO.output(self.enable, False)
        GPIO.output(self.out1, False)
        GPIO.output(self.out2, False)
        return True

    def back(self):
        GPIO.output(self.out1, False)
        GPIO.output(self.out2, True)
        return True


class MotorsDriver:
    def __init__(self, m1_pin1, m1_pin2, m1_en, m2_pin1, m2_pin2, m2_en):
        try:
            self.left_motor = Motor(enable=m1_en, out1=m1_pin1, out2=m1_pin2, speed=40)
            self.right_motor = Motor(enable=m2_en, out1=m2_pin1, out2=m2_pin2, speed=60)
            Logger.log(LogLevel.INFO, 'Motors instance created')
        except Exception as e:
            Logger.log(LogLevel.ERROR, str(e))

    def go_forward(self):
        self.right_motor.forward()
        self.left_motor.forward()

    def go_back(self):
        self.right_motor.back()
        self.left_motor.back()
    
    def stop(self):
        self.left_motor.stop()
        self.right_motor.stop()

    def turn_right(self):
        self.right_motor.stop()
        self.left_motor.forward()
        time.sleep(1)
        #stopping motors
        self.stop()

    def turn_left(self):
        self.right_motor.forward()
        self.left_motor.stop()
        time.sleep(1)
        #stopping motors
        self.stop()
        