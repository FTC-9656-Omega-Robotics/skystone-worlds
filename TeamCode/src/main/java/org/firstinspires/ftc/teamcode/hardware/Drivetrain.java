package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public double front_left = 0;
    public double front_right = 0;
    public double rear_left = 0;
    public double rear_right = 0;

    public double maxSpeed = 1;

    public Drivetrain(DeviceManager deviceManager){
        frontLeft = deviceManager.frontLeft;
        frontRight = deviceManager.frontRight;
        backLeft = deviceManager.backLeft;
        backRight = deviceManager.backRight;

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontLeft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        frontRight.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void process(){//run every frame
        frontLeft.setPower(front_left);
        frontRight.setPower(front_right);
        backLeft.setPower(rear_left);
        backRight.setPower(rear_right);
    }

    public void setPower(double forward, double right, double clockwise){
        front_left = forward + clockwise + right;
        front_right = forward - clockwise - right;
        rear_left = forward + clockwise - right;
        rear_right = forward - clockwise + right;

        double max = Math.abs(front_left);
        if (Math.abs(front_right) > max) max = Math.abs(front_right);
        if (Math.abs(rear_left) > max) max = Math.abs(rear_left);
        if (Math.abs(rear_right) > max) max = Math.abs(rear_right);

        if (max > maxSpeed) {
            front_left /= (max/maxSpeed);
            front_right /= (max/maxSpeed);
            rear_left /= (max/maxSpeed);
            rear_right /= (max/maxSpeed);
        }

        front_left = front_left*front_left*front_left;
        front_right = front_right*front_right*front_right;
        rear_left = rear_left*rear_left*rear_left;
        rear_right = rear_right*rear_right*rear_right;
    }
}
