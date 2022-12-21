from src.robot.robot import Robot
from src.data.arduino import Arduino
from src.robot.drivers.motor_driver import Motor
import RPi.GPIO as GPIO
import time
import json

""" def test():
    with open('./config.json', 'r+') as f:
        config = json.load(f)

    m = ClassificationModel(
        batch_size=32,
        img_height=180,
        img_width=180
    )

    dataset = './src/vision/images'

    m.fit(dataset)
    m.layrize_data()
    m.train()
    m.save('build/model.h5')

    prediction = m.predict('./src/vision/images/rain/rain1.jpg')
    print(prediction) """

def main():
    # static config loading
    with open('config.json', 'r+') as f:
        config = json.load(f)
    
    print(config['serial']['port'])
    # arduino = Arduino(config['serial']['port'])
    robot = Robot()

    # BEGIN
    robot.begin()
    print('Finished')

if __name__ == '__main__':
    with open('./config.json', 'r+') as f:
        config = json.load(f)

    GPIO.setwarnings(False)
    GPIO.setmode(GPIO.BOARD)
    GPIO.setup(config['motors'], GPIO.OUT)
    
    robot = Robot(config['motors'])
    robot.stop()
    """
    ret = robot.begin()
    robot.reach_cf() """
    #robot.greet()
    #robot.forward()