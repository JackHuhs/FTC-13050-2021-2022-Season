package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Blue_SpinToWin", group="Linear Opmode")
//@Disabled
public class Blue_SpinToWin extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    //variables
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor leftDownDrive;
    DcMotor rightDownDrive;

    double piDouble = 3.14159265359; //literally pi
    double wheelDiameter = (1/3); //in feet
    double wheelCircumference = wheelDiameter*piDouble; //in feet

    @Override
    public void runOpMode() {
        telemetry.addData("Status","Initialized");
        telemetry.update();

        //hardware map config
        leftDrive.hardwareMap.get(DcMotor.class,"left_drive");
        rightDrive.hardwareMap.get(DcMotor.class,"right_drive");
        leftDownDrive.hardwareMap.get(DcMotor.class,"left_down_drive");
        rightDownDrive.hardwareMap.get(DcMotor.class,"right_down_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDownDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDownDrive.setDirection(DcMotor.Direction.REVERSE);

        //start
        waitForStart();
        runtime.reset();

        //actual autonomous path
    }
}
