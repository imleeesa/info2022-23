from enum import Enum

class States(Enum):
    IDLE = 'IDLE'
    BEGIN = 'BEGIN'
    RECOGNITION = 'RECOGNITION'
    PLAYTIME = 'PLAYTIME'
    END = 'END'

class StateHandler:
    def __init__(self, initial, robot):
        self.currentState = initial
        self.robot = robot
    
    def idle(self):
        # recogniziotion word 'SCUOLA'
        self.robot.begin()

    def begin(self):
        pass

    def recognition(self):
        pass

    def playtime(self):
        pass

    def end(self):
        pass