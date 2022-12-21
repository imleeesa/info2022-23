#ifndef Motor_h
#define Motor_h

class Motor {
  private:
    char pin;
  public:
    Motor(char pin);
    void init();
    void setSpeed(int speed);
    void forward();
    void back();
    void stop();
};

class MotorController {
  private:
    Motor dx;
    Motor sx;
  public:
    MotorController();
    void goForward(int sec);
    void goBack(int sec);
    void turnRight(int sec);
    void turnLeft(int sec);
    void stop();
};
#endif
