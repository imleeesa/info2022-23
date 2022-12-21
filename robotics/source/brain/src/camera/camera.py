#from cv2 import cv2
import numpy as np
import pytesseract
from threading import Thread
from imutils.video import VideoStream, FPS
#from ..data.logger import Logger, LogLevel
import time

try:
    from PIL import Image
except ImportError:
    import Image

class Camera:
    def __init__(self):
        self.running = False
        self.frame = None
        self.vs = VideoStream(src=-1)
        #self.vs = cv2.VideoCapture(1)
        self.word = ''
    
    def read_word_bis(self, word):
        self.running = True
        self.vs.start()
        time.sleep(1.0)
        self.word = word
        self.frame = self.vs.read()

        while self.running:
            try:
                self.frame = self.vs.read()
                text = pytesseract.image_to_string(self.frame)
                print(text)
                if (self.word in text):
                    self.running = False
            except Exception as e:
                print(e)

        self.vs.stop()
        return True

if __name__ == '__main__':
    c =Camera()
    c.read_word_bis('START')
    print("reconized")
