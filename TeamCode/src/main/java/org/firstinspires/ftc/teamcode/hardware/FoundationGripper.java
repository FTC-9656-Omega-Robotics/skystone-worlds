package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.Servo;

public class FoundationGripper {
    public Servo foundationGripper;

    public static final double FOUNDATION_GRIPPER_UP = 0.55;
    public static final double FOUNDATION_GRIPPER_DOWN = 1;
    public static final double FOUNDATION_GRIPPER_READY = 0.85;

    public enum Position {
        UP,
        DOWN,
        READY

    }

    public double foundationGripperPos = FOUNDATION_GRIPPER_UP;

    public Position position = Position.UP;

    public FoundationGripper (DeviceManager deviceManager) {
        foundationGripper = deviceManager.foundationGripper;
        foundationGripper.setPosition(foundationGripperPos);
    }

    public void moveFoundationGripper (Position p) {
        switch (p) {
            case UP:
                foundationGripperPos = FOUNDATION_GRIPPER_UP;
                position = Position.UP;
                break;
            case DOWN:
                foundationGripperPos = FOUNDATION_GRIPPER_DOWN;
                position = Position.DOWN;
                break;
            case READY:
                foundationGripperPos = FOUNDATION_GRIPPER_READY;
                position = Position.READY;
                break;
        }
    }

    public void process(){
        foundationGripper.setPosition(foundationGripperPos);
    }
}
