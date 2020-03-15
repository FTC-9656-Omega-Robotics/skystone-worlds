package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.Servo;

public class BlockGripper {
    public Servo blockGripper;
    public Servo blockRotator;

    public static final double BLOCK_GRIPPER_OPEN = 0.6;
    public static final double BLOCK_GRIPPER_CLOSED = 0.2;

    public static final double BLOCK_ROTATOR_STRAIGHT = 0.62;

    public enum Position{
        OPEN,
        CLOSED
    }

    public double gripperPos = BLOCK_GRIPPER_OPEN;
    public double rotatorPos = BLOCK_ROTATOR_STRAIGHT;

    public Position position = Position.OPEN;

    public BlockGripper(DeviceManager deviceManager){
        blockGripper = deviceManager.blockGripper;
        blockRotator = deviceManager.blockRotator;
        blockGripper.setPosition(gripperPos);
        blockRotator.setPosition(rotatorPos);
    }

    public void moveBlockGripper(Position p){
        switch (p) {
            case OPEN:
                gripperPos = BLOCK_GRIPPER_OPEN;
                position = Position.OPEN;
                break;
            case CLOSED:
                gripperPos = BLOCK_GRIPPER_CLOSED;
                position = Position.CLOSED;
                break;
        }
    }
    public void process(){
        blockGripper.setPosition(gripperPos);
    }
}

