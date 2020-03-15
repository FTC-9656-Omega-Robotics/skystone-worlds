package org.firstinspires.ftc.teamcode.hardware;

import android.app.Activity;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DeviceManager {
    public HardwareMap hardwareMap;

    // DC motors
    public DcMotorEx arm;
    public DcMotor leftIntake;
    public DcMotor rightIntake;
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    // servos
    public Servo blockRotator; // rotates block gripper on arm
    public Servo blockGripper; // opens/closes gripper on arm

    public Servo foundationGripper;

    public Servo sideBackGripper; // open/closes side back gripper
    public Servo sideBackElbow; // moves side back gripper up/down

    public Servo sideFrontGripper; // open/closes side front gripper
    public Servo sideFrontElbow; // moves side front gripper up/down

    public Servo capstoneRotator; // rotates the capstone
    public Servo capstoneReleaser; // releases the capstone

    // sensors
    public ColorSensor sensorColor;
    public DistanceSensor sensorDistance;

    public int relativeLayoutId;
    public View relativeLayout;

    public DeviceManager (HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
    }

    public void init(){
        // Configure DcMotors with REV Expansion Hub
        arm = hardwareMap.get(DcMotorEx.class, "arm");
        leftIntake = hardwareMap.get(DcMotor.class, "left_intake");
        rightIntake = hardwareMap.get(DcMotor.class, "right_intake");
        frontLeft = hardwareMap.get(DcMotorEx.class, "front_left");
        backLeft = hardwareMap.get(DcMotorEx.class, "back_left");
        backRight = hardwareMap.get(DcMotorEx.class, "back_right");
        frontRight = hardwareMap.get(DcMotorEx.class, "front_right");

        // Configure servos with REV Expansion Hub
        blockRotator = hardwareMap.get(Servo.class, "block_rotator");
        blockGripper = hardwareMap.get(Servo.class, "block_gripper");

        foundationGripper = hardwareMap.get(Servo.class, "foundation_gripper");

        sideBackGripper = hardwareMap.get(Servo.class, "side_back_gripper");
        sideBackElbow = hardwareMap.get(Servo.class, "side_back_elbow");

        sideFrontGripper = hardwareMap.get(Servo.class, "side_front_gripper");
        sideFrontElbow = hardwareMap.get(Servo.class, "side_front_elbow");

        capstoneRotator = hardwareMap.get(Servo.class, "capstone_rotator");
        capstoneReleaser = hardwareMap.get(Servo.class, "capstone_releaser");

        // Configure sensors with REV Expansion Hub
        sensorDistance = hardwareMap.get(DistanceSensor.class, "color_distance_sensor");
        sensorColor = hardwareMap.get(ColorSensor.class, "color_distance_sensor");

        relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
    }
}
