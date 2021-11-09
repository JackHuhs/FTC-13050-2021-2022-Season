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
    
    //functions
    public void driveForward(int dst, int spd){ //can also drive backwards with a negative speed
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        leftDrive.setTargetPosition((int) (-dst));
        rightDrive.setTargetPosition((int) (-dst));
        
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        leftDrive.setVelocity((int) (spd));
        rightDrive.setVelocity((int) (spd));
        while (leftDrive.isBusy()||rightDrive.isBusy()){
            telemetry.addData("position", leftDrive.getCurrentPosition());
            telemetry.addData("position", rightDrive.getCurrentPosition());
            telemetry.update();
        }
        leftDrive.setVelocity((int) (0));
        rightDrive.setVelocity((int) (0));
    }
    
    public void turn(int dgr, int spd){ //positive dgr is right, negative dgr is left
        double turnPos = 575*dgr/90;
        if (dgr < 0){
            spd*=-1;
        }
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        leftDrive.setTargetPosition((int) (-turnPos));
        rightDrive.setTargetPosition((int) (turnPos));
        
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        leftDrive.setVelocity((int) (-spd));
        rightDrive.setVelocity((int) (spd));
        while (leftDrive.isBusy()||rightDrive.isBusy()){
            telemetry.addData("position", leftDrive.getCurrentPosition());
            telemetry.addData("position", rightDrive.getCurrentPosition());
            telemetry.update();
        }
        leftDrive.setVelocity((int) (0));
        rightDrive.setVelocity((int) (0));
    }
    
    private ElapsedTime runtime = new ElapsedTime();
    //variables
    DcMotorEx leftDrive;
    DcMotorEx rightDrive;
    DcMotorEx leftDownDrive;
    DcMotorEx rightDownDrive;

    // double piDouble = 3.14159265359; //literally pi
    // double wheelDiameter = (1/3); //in feet
    // double wheelCircumference = wheelDiameter*piDouble; //in feet
    // double power = 0.5;
    // double TPR = 1120;

    @Override
    public void runOpMode() throws InterruptedException{
        telemetry.addData("Status","Initialized");
        telemetry.update();

        //hardware map config
        leftDrive=hardwareMap.get(DcMotorEx.class,"left_drive");
        rightDrive=hardwareMap.get(DcMotorEx.class,"right_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        //start
        waitForStart();
        runtime.reset();

        //actual autonomous path
        
        turn((int)(90),(int)(900)); //right 90 degrees
        
        driveForward((int)(401),(int)(900)); //forward 9 inches
        
        //SPIN DUCKS HERE
        
        turn((int)(-90),(int)(900)); //left 90 degrees
        
        driveForward((int)(1025),(int)(900)); //forward 23 inches
        
        turn((int)(-90),(int)(900)); //left 90 degrees
        
        driveForward((int)(936),(int)(900)); //forward 21 inches
        
        //PLACE STARTING BOX ON FOUNTAIN THING
        
        driveForward((int)(-936),(int)(900)); //backward 21 inches
        
        turn((int)(-90),(int)(900)); //left 90 degrees
        
        driveForward((int)(312),(int)(900)); //forward 7 inches
        
        //PARK (END)
    }
}
