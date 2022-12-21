# Hydraflame ON-STAGE 20/21

## Developers

- Diego Caspi
- Edoardo Berton

## General concept

In an on-stage competition teams have to create a scene where robots are the main core in the stage.
We'll represent a scene from the movie "Pinocchio". The leader actor is Pinocchio (a robot) who's going to school, but during the way he is stopped by the cat and the fox. They convice him to go with them in the "Land of toys", he accept and follows them.
In the end of the scene he understands the importance of the school and after a long reasoning he come back to school and here he starts his trasformation in a real boy.

## State based architecture

| State       | Condition                             | Action                                      |
|-------------|---------------------------------------|---------------------------------------------|
| idle        | -                                     | Pinocchio(rasp) recognize "START" word      |
| begin       | "START" word successfully recognized  | Pinocchio(ard) go forward                   |
| recognition | Pinocchio distance < 50 cm            | Pinocchio(rasp) AI recognize FoxCat         |
| playTime    | Succefully recognized / failed        | FerrisWheel ON, Pinocchio e FoxCat verso BP |
| end         | "SCUOLA" word successfully recognized | Pinocchio va a scuola                       |


## Robots

- Pinocchio
- Cat and fox
- Ferris wheel (background)

## Pinocchio

We'll use an Arduino for getting data from sensor, which are sent by serial USB port connection to the Raspberry which elaborates these data and send back to Arduino operations that motors, servo-motors have to execute.

#### Progress

| Components           | Ready?             |
| -------------------- | ------------------ |
| Raspberry Pi         | :x:                |
| Arduino Mega         | :white_check_mark: |
| 2 x distance sensors | :white_check_mark: |
| HC-05 BT module      | :white_check_mark: |

#### TO DO

- think of a communication protocol
- write Arduino-side code to get information from different sensors
- complete and handle the brain in python-raspberry software

## Cat and Fox

This is a simple robot piloted by only a simple Arduino which is connected with bluetooth HC-05.
It receives command from Pinocchio robot, but we have to implement a better communication protocol.

#### Progress

| Components           | Ready?             |
| -------------------- | ------------------ |
| Arduino              | :white_check_mark: |
| 2 x distance sensors | :x:                |

#### TO DO
- everything

## Ferris wheel
This is the simpliest robot which fuction is just for background.
It's already completed.
