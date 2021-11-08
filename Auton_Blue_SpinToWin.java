package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Blue_SpinToWin", group="Linear Opmode")
//@Disabled
public class Blue_SpinToWin extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    //variables
    DcMotorEx leftDrive;
    DcMotorEx rightDrive;
    DcMotorEx leftDownDrive;
    DcMotorEx rightDownDrive;

    double piDouble = 3.14159265359; //literally pi
    double wheelDiameter = (1/3); //in feet
    double wheelCircumference = wheelDiameter*piDouble; //in feet
    double power = 0.5;
    double TPR = 1120;

    @Override
    public void runOpMode() throws InterruptedException{
        telemetry.addData("Status","Initialized");
        telemetry.update();

        //hardware map config
        leftDrive=hardwareMap.get(DcMotorEx.class,"left_drive");
        rightDrive=hardwareMap.get(DcMotorEx.class,"right_drive");
        // leftDownDrive=hardwareMap.get(DcMotorEx.class,"left_down_drive");
        // rightDownDrive=hardwareMap.get(DcMotorEx.class,"right_down_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        // leftDownDrive.setDirection(DcMotor.Direction.FORWARD);
        // rightDownDrive.setDirection(DcMotor.Direction.REVERSE);

        //start
        waitForStart();
        runtime.reset();

        //actual autonomous path
        //amount of inches they need to run to turn 90 degrees is 4.5π
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // leftDownDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // rightDownDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        leftDrive.setTargetPosition((int) (575));
        // leftDownDrive.setTargetPosition((int) (4.5/wheelDiameter)*TPR);
        rightDrive.setTargetPosition((int) (-575));
        // rightDownDrive.setTargetPosition((int) (-4.5/wheelDiameter)*TPR);

        // leftDrive.setPower(power);
        // rightDrive.setPower(-power);
        // leftDownDrive.setPower(power);
        // rightDownDrive.setPower(-power);

        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // leftDownDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // rightDownDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        leftDrive.setVelocity((int) (900));
        rightDrive.setVelocity((int) (900));
        while (leftDrive.isBusy()||rightDrive.isBusy()){
            telemetry.addData("position", leftDrive.getCurrentPosition());
            telemetry.addData("position", rightDrive.getCurrentPosition());
            telemetry.update();
        }
        leftDrive.setVelocity((int) (0));
        rightDrive.setVelocity((int) (0));
        
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
