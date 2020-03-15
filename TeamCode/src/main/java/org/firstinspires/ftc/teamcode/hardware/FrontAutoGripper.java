package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.Servo;

public class FrontAutoGripper {
    public Servo sideFrontGripper;
    public Servo sideFrontElbow;

    public static final double SIDE_FRONT_GRIPPER_OPEN = 0.5;
    public static final double SIDE_FRONT_GRIPPER_CLOSED = 0.1;
    public static final double SIDE_FRONT_GRIPPER_STOWED = 0; // stowed for safe travel under bridge
    public static final double SIDE_FRONT_GRIPPER_READY = 0.6; // slightly closed for auto efficiency

    public static final double SIDE_FRONT_ELBOW_UP = 0.35;
    public static final double SIDE_FRONT_ELBOW_DOWN = 0.7; // parallel to floor
    public static final double SIDE_FRONT_ELBOW_READY = 0.6; // slightly down for auto efficiency

    public enum Position {
        STOWED,
        DOWN_READY,
        DOWN_CLOSED,
        DOWN_OPEN,
        UP,
        READY

    }

    public double sideFrontGripperPos = SIDE_FRONT_GRIPPER_STOWED;
    public double sideFrontElbowPos = SIDE_FRONT_ELBOW_UP;

    public Position position = Position.STOWED;

    public FrontAutoGripper(DeviceManager deviceManager) {
        sideFrontGripper = deviceManager.sideFrontGripper;
        sideFrontElbow = deviceManager.sideFrontElbow;
    }

    public void moveTo(BackAutoGripper.Position p) {
        switch (p) {
            case STOWED:
                sideFrontGripperPos = SIDE_FRONT_GRIPPER_STOWED;
                sideFrontElbowPos = SIDE_FRONT_ELBOW_UP;
                position = FrontAutoGripper.Position.STOWED;
                break;
            case DOWN_READY:
                sideFrontGripperPos = SIDE_FRONT_GRIPPER_READY;
                sideFrontElbowPos = SIDE_FRONT_ELBOW_DOWN;
                position = FrontAutoGripper.Position.DOWN_READY;
                break;
            case DOWN_CLOSED:
                sideFrontGripperPos = SIDE_FRONT_GRIPPER_CLOSED;
                sideFrontElbowPos = SIDE_FRONT_ELBOW_DOWN;
                break;
            case DOWN_OPEN:
                sideFrontGripperPos = SIDE_FRONT_GRIPPER_OPEN;
                sideFrontElbowPos = SIDE_FRONT_ELBOW_DOWN;
                position = FrontAutoGripper.Position.DOWN_OPEN;
            case UP:
                sideFrontGripperPos = SIDE_FRONT_GRIPPER_CLOSED;
                sideFrontElbowPos = SIDE_FRONT_ELBOW_UP;
                position = FrontAutoGripper.Position.UP;
                break;
            case READY:
                sideFrontGripperPos = SIDE_FRONT_GRIPPER_READY;
                sideFrontElbowPos = SIDE_FRONT_ELBOW_READY;
                position = FrontAutoGripper.Position.READY;
        }
    }

    public void process() {
        sideFrontGripper.setPosition(sideFrontGripperPos);
        sideFrontElbow.setPosition(sideFrontElbowPos);
    }
}
