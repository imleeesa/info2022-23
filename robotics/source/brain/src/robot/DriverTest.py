from robot import Robot
import time

class RobotTestClass():
    def __init__(self):
        while True:
            pnc = Robot(None)
            pnc.turn_left()
            time.sleep(5)
            pnc.stop()
            pnc.turn_right()
            time.sleep(5)
            pnc.stop()

test = RobotTestClass()