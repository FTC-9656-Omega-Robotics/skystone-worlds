package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Arm {
    public DcMotorEx arm;

    public static final int ARM_INIT = -250;
    public static final int ARM_DOWN = -100;
    public static final int ARM_UP = -1400;
    public static final int ARM_DEPOSIT = -1700;
    public static final int ARM_TRAVELING = -210;
    public static final int ARM_INTAKING = -350;

    public enum Position {
        UP,
        DOWN,
        TRAVELING,
        DEPOSIT,
        INTAKING
    }

    public int armPos = ARM_TRAVELING;
    public double power = 0.5;
    public Position location;

    public Arm (DeviceManager deviceManager){
        arm = deviceManager.arm;
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setTargetPosition(ARM_INIT);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(.5);
    }

    public void process(){ //call every frame
        arm.setTargetPosition(armPos);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(power);
    }

    public void moveArm(Position position){
        switch(position){
            case UP:
                armPos = ARM_UP;
                
                //Note, this is specifically for teleop. The button d makes the arm go up, However, if the arm is already
                //in the up position, then we want the button d to make it go into deposit mode.
                
                if(location == Position.UP) {
                    armPos = ARM_DEPOSIT;
                    location = Position.DEPOSIT;
                }
                location = Position.DEPOSIT;
                break;
            case DOWN:
                armPos = ARM_DOWN;
                location = Position.DOWN;
                break;
            case TRAVELING:
                armPos = ARM_TRAVELING;
                location = Position.TRAVELING;
                break;
            case DEPOSIT:
                armPos = ARM_DEPOSIT;
                location = Position.DEPOSIT;
                break;
            case INTAKING:
                armPos = ARM_INTAKING;
                location = Position.INTAKING;
                break;
        }
    }

    public void fineAdjust(int i){
        if(i > 0 && armPos < 0){
            armPos += 5;
        }
        if(i < 0 && armPos > -1700){
            armPos -= 5;
        }
    }

    public boolean isBusy(){
        return arm.isBusy();
    }
}
