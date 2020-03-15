package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {
    public DcMotor leftIntake;
    public DcMotor rightIntake;

    public static final int LEFTINTAKE_IN = 1;
    public static final int RIGHTINTAKE_IN = -1;
    public static final double LEFTIINTAKE_OUT = -.3;
    public static final double RIGHTINTAKE_OUT = .3;

    public Direction direction;
    public double leftPower = 0;
    public double rightPower = 0;

    public enum Direction {
        IN,
        OUT,
        STOP
    }

    public Intake(DeviceManager deviceManager){
        leftIntake = deviceManager.leftIntake;
        rightIntake = deviceManager.rightIntake;
    }

    public void runIntake(Direction d){
        switch(d){
            case IN:
                leftPower = LEFTINTAKE_IN;
                rightPower = RIGHTINTAKE_IN;
                direction = Direction.IN;
                break;
            case OUT:
                leftPower = LEFTIINTAKE_OUT;
                rightPower = RIGHTINTAKE_OUT;
                direction = Direction.OUT;
                break;
            case STOP:
                leftPower = 0;
                rightPower = 0;
                direction = Direction.STOP;
                break;
        }
    }

    public void process(){
        leftIntake.setPower(leftPower);
        rightIntake.setPower(rightPower);
    }

}

