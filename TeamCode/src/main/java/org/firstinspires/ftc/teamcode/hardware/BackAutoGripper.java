package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.Servo;

public class BackAutoGripper {
    public Servo sideBackGripper;
    public Servo sideBackElbow;

    public static final double SIDE_BACK_GRIPPER_OPEN = .41;
    public static final double SIDE_BACK_GRIPPER_CLOSED = 0;
    public static final double SIDE_BACK_GRIPPER_STOWED = .63; //safe travel under the bridge
    public static final double SIDE_BACK_GRIPPER_READY = .45;

    public static final double SIDE_BACK_ELBOW_UP = .31;
    public static final double SIDE_BACK_ELBOW_DOWN = .02;
    public static final double SIDE_BACK_ELBOW_READY = 0.15;

    public enum Position {
        STOWED,
        DOWN_READY,
        DOWN_CLOSED,
        DOWN_OPEN,
        UP,
        READY

    }

    public double sideBackGripperPos = SIDE_BACK_GRIPPER_STOWED;
    public double sideBackElbowPos = SIDE_BACK_ELBOW_UP;

    public Position position = Position.STOWED;


    public BackAutoGripper (DeviceManager deviceManager) {
        sideBackGripper = deviceManager.sideBackGripper;
        sideBackElbow = deviceManager.sideBackElbow;
    }

    public void moveTo(Position p){
        switch(p){
            case STOWED:
                sideBackGripperPos = SIDE_BACK_GRIPPER_STOWED;
                sideBackElbowPos = SIDE_BACK_ELBOW_UP;
                position = Position.STOWED;
                break;
            case DOWN_READY:
                sideBackGripperPos = SIDE_BACK_GRIPPER_READY;
                sideBackElbowPos = SIDE_BACK_ELBOW_DOWN;
                position = Position.DOWN_READY;
                break;
            case DOWN_CLOSED:
                sideBackGripperPos = SIDE_BACK_GRIPPER_CLOSED;
                sideBackElbowPos = SIDE_BACK_ELBOW_DOWN;
                break;
            case DOWN_OPEN:
                sideBackGripperPos = SIDE_BACK_GRIPPER_OPEN;
                sideBackElbowPos = SIDE_BACK_ELBOW_DOWN;
                position = Position.DOWN_OPEN;
            case UP:
                sideBackGripperPos = SIDE_BACK_GRIPPER_CLOSED;
                sideBackElbowPos = SIDE_BACK_ELBOW_UP;
                position = Position.UP;
                break;
            case READY:
                sideBackGripperPos = SIDE_BACK_GRIPPER_READY;
                sideBackElbowPos = SIDE_BACK_ELBOW_READY;
                position = Position.READY;
        }
    }

    public void process(){
        sideBackGripper.setPosition(sideBackGripperPos);
        sideBackElbow.setPosition(sideBackElbowPos);
    }

}
