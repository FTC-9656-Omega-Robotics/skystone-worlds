package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Robot {
    public OpMode opMode;

    public DeviceManager deviceManager;

    public Arm arm;
    public Intake intake;
    public Drivetrain drivetrain;
    public BackAutoGripper backAutoGripper;
    public FrontAutoGripper frontAutoGripper;
    public FoundationGripper foundationGripper;

    public Robot(OpMode opMode){
        this.opMode = opMode;
        deviceManager = new DeviceManager(opMode.hardwareMap);
    }

    public void init(){
        deviceManager.init();
        arm = new Arm(deviceManager);
        intake = new Intake(deviceManager);
        drivetrain = new Drivetrain(deviceManager);
        backAutoGripper = new BackAutoGripper(deviceManager);
        frontAutoGripper = new FrontAutoGripper(deviceManager);
        foundationGripper = new FoundationGripper(deviceManager);
    }
}
