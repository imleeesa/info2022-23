#include <Arduino.h>
#include "Constants.h"
#include "Motor.h"

//  MOTOR A | MOTOR B | OUTPUT
//    LOW   |   LOW   |   fermo
//    LOW   |   HIGH  |   indietro
//    HIGH  |   LOW   |   avanti
//    HIGH  |   HIGH  |   fermo

Motor::Motor(char pin) {
  this->pin = pin;
  init();
}

void Motor::init() {
  switch (this->pin) {
    case dxMotor:
      // init dx motor pins
      pinMode(dxPin1, OUTPUT);
      pinMode(dxPin2, OUTPUT);
      pinMode(dxSpeed, OUTPUT);
      this->setSpeed(dxMotorSpeed);
      break;
    case sxMotor:
      // init sx motor pins
      pinMode(sxPin1, OUTPUT);
      pinMode(sxPin2, OUTPUT);
      pinMode(sxSpeed, OUTPUT);
      this->setSpeed(sxMotorSpeed);
      break;
    default:
      break;
  }
}

void Motor::setSpeed(int speed) {
  switch (this->pin) {
    case dxMotor:
      // analogWrite on dxSpeed pin
      analogWrite(dxSpeed, speed);
      break;
    case sxMotor:
      // analogWrite on sxSpeed pin
      analogWrite(sxSpeed, speed);
      break;
    default:
      break;
  }
}

void Motor::forward() {
  switch (this->pin) {
    case dxMotor:
      digitalWrite(dxPin1, HIGH);
      digitalWrite(dxPin2, LOW);
      break;
    case sxMotor:
      digitalWrite(sxPin1, HIGH);
      digitalWrite(sxPin2, LOW);
      break;
    default:
      break;
  }
}

void Motor::back() {
  switch (this->pin) {
    case dxMotor:
      digitalWrite(dxPin1, LOW);
      digitalWrite(dxPin2, HIGH);
      break;
    case sxMotor:
      digitalWrite(sxPin1, LOW);
      digitalWrite(sxPin2, HIGH);
      break;
    default:
      break;
  }
}

void Motor::stop() {
  switch (this->pin) {
    case dxMotor:
      digitalWrite(dxPin1, LOW);
      digitalWrite(dxPin2, LOW);
      break;
    case sxMotor:
      digitalWrite(sxPin1, LOW);
      digitalWrite(sxPin2, LOW);
      break;
    default:
      break;
  }
}

MotorController::MotorController(): dx(dxMotor), sx(sxMotor) {}

void MotorController::goForward(int ms) {
  this->sx.setSpeed(sxMotorSpeed + 35);
  this->dx.forward();
  this->sx.forward();
  delay(ms / 5);
  this->sx.setSpeed(sxMotorSpeed);
  delay(4 * ms / 5);
  this->stop();
}

void MotorController::goBack(int ms) {
  this->sx.setSpeed(sxMotorSpeed + 35);
  this->dx.back();
  this->sx.back();
  delay(ms / 5);
  this->sx.setSpeed(sxMotorSpeed);
  delay(4 * ms / 5);
  this->stop();
}

void MotorController::turnRight(int ms) {
  this->dx.forward();
  this->sx.stop();
  delay(ms);
  this->stop();
}

void MotorController::turnLeft(int ms) {
  this->dx.stop();
  this->sx.forward();
  delay(ms);
  this->stop();
}

void MotorController::stop() {
  this->dx.stop();
  this->sx.stop();
}
