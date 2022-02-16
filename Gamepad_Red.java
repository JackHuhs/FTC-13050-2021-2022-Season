//overcommenting edition
package org.firstinspires.ftc.teamcode; //import le package
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //import said Linear OP mode type
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //import teleop
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //import zed teleop
import com.qualcomm.robotcore.hardware.DcMotor; //import la dcmotor class
import com.qualcomm.robotcore.hardware.Servo; //import the servo class
import com.qualcomm.robotcore.util.ElapsedTime; // i dunno just import this stuff
import com.qualcomm.robotcore.util.Range;
//blank line
//blank line
@TeleOp(name="Gamepad_Red", group="Linear Opmode")
//@Disabled
public class Gamepad_Red extends LinearOpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor leftDownDrive;
    DcMotor rightDownDrive;
    DcMotor intakeArm;
    DcMotor liftMotor;
    Servo intServ;
    DcMotor StW;
    DcMotor liftMotorTwo;
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        leftDownDrive  = hardwareMap.get(DcMotor.class, "left_down_drive");
        rightDownDrive = hardwareMap.get(DcMotor.class, "right_down_drive");
        liftMotor = hardwareMap.get(DcMotor.class, "lift_motor");
        intServ = hardwareMap.get(Servo.class, "intSer");
        StW = hardwareMap.get(DcMotor.class, "STW");
        liftMotorTwo = hardwareMap.get(DcMotor.class, "liftMotorTwo");

        //intakeArm = hardwareMap.get(DcMotorEx.class, "intake_arm");
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDownDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDownDrive.setDirection(DcMotor.Direction.REVERSE);
        StW.setDirection(DcMotor.Direction.REVERSE);
        //intakeArm.setDirection(DcMotor.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.REVERSE); //change when making launcher
        // launcherMotor2.setDirection(DcMotor.Direction.FORWARD);
        // intakeMotor.setDirection(DcMotor.Direction.FORWARD); //change when making intake

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Setup a variable for each drive wheel to save power level for telemetry
            double wheelPower;
            double intakePower = 0.5;
            boolean intakeOut = false;
            boolean intakeRunning = false;
            double armMaxRange = 0.0;
            double armMinRange = 1.0;
            double armHome = 0.0;

            //double intakePower;
            wheelPower = 0.65; //different speeds, change to 1.00 for 100 percent of the motor's RPM
            //intakePower = .5; //change later
            //launcher
            //
            // if(gamepad1.right_trigger>0.5){wobbleArm.setPower(wheelPower);}else if(gamepad1.right_bumper){wobbleArm.setPower(-wheelPower);}else{wobbleArm.setPower(0);}
            // if(gamepad1.left_trigger>0.5){firstWheel.setPower(wheelPower);}else if(gamepad1.left_bumper) {firstWheel.setPower(-wheelPower);}else{firstWheel.setPower(0);}
            
            //Turning
            if(gamepad1.left_stick_x>0.75){
                leftDrive.setPower(-wheelPower + 20);
                rightDrive.setPower(wheelPower - 20);
                leftDownDrive.setPower(-wheelPower + 20);
                rightDownDrive.setPower(wheelPower - 20);
           
            } else if (gamepad1.left_stick_x<-0.75){
                leftDrive.setPower(wheelPower - 20);
                rightDrive.setPower(-wheelPower + 20);
                leftDownDrive.setPower(wheelPower - 20);
                rightDownDrive.setPower(-wheelPower + 20);  
            //forward and backwards
             } else if (gamepad1.right_stick_y>0.75){
                leftDrive.setPower(-wheelPower - 20);
                rightDrive.setPower(-wheelPower - 20);
                leftDownDrive.setPower(-wheelPower - 20);
                rightDownDrive.setPower(-wheelPower - 20);

            } else if (gamepad1.right_stick_y<-0.75){
                leftDrive.setPower(wheelPower + 20);
                rightDrive.setPower(wheelPower + 20);
                leftDownDrive.setPower(wheelPower + 20);
                rightDownDrive.setPower(wheelPower + 20);

            } else {
                leftDrive.setPower(0);
                rightDrive.setPower(0);
                leftDownDrive.setPower(0);
                rightDownDrive.setPower(0);
            }
            if(gamepad2.x){
                intServ.setPosition(-1.5);
                //sleep(800);
            }
            if(gamepad2.y){
                intServ.setPosition(1.0);
                //sleep(800);
            }
            
            
        //   if (gamepad2.x){l
        //         if (intakeOut){
                    
        //         } else {
        //             intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //             intakeArm.setTargetPosition((int)(1680));
        //             intakeArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //             intakeArm.setVelocity((int)(600));
        //             while(intakeArm.isBusy()){
        //                 telemetry.addData("position",intakeArm.getCurrentPosition());
        //                 telemetry.update();
        //             }
        //         }
        //     }
            
            if (gamepad2.right_trigger>0.5){
                liftMotor.setPower(0.8); //increase for more torque later
                liftMotorTwo.setPower(0.8);
            } else if (gamepad2.right_bumper){
                liftMotor.setPower(-0.7);
                liftMotorTwo.setPower(-0.95);
            } else {
                liftMotor.setPower(0);
                liftMotorTwo.setPower(0);
            }
            
            if(gamepad2.dpad_down){
                liftMotor.setPower(0.8);
                //liftMotorTwo.setPower(0.8);
            } else if(gamepad2.dpad_up){
                liftMotor.setPower(-0.8);
                //liftMotorTwo.setPower(-0.8);
            } else {
                liftMotor.setPower(0);
                //liftMotorTwo.setPower(0);
            }
            
            if (gamepad2.left_trigger>0.5){
                StW.setPower(-0.19);
            } else {
                StW.setPower(0);
            }
            
            if(gamepad2.dpad_left){
                liftMotorTwo.setPower(0.8);
            } else if(gamepad2.dpad_right){
                liftMotorTwo.setPower(-0.8);
            } else {
                liftMotorTwo.setPower(0);
            }
            
            if(gamepad1.dpad_left){
                leftDrive.setPower(-wheelPower + 40);
                rightDrive.setPower(wheelPower - 40);
                leftDownDrive.setPower(-wheelPower + 40);
                rightDownDrive.setPower(wheelPower - 40);
            } else if(gamepad2.dpad_right){
                leftDrive.setPower(wheelPower - 40);
                rightDrive.setPower(-wheelPower + 40);
                leftDownDrive.setPower(wheelPower - 40);
                rightDownDrive.setPower(-wheelPower + 40);
            } else {
                leftDrive.setPower(0);
                rightDrive.setPower(0);
                leftDownDrive.setPower(0);
                rightDownDrive.setPower(0);
            }
            
            if(gamepad1.dpad_up){
                leftDrive.setPower(wheelPower - 40);
                rightDrive.setPower(wheelPower - 40);
                leftDownDrive.setPower(wheelPower - 40);
                rightDownDrive.setPower(wheelPower - 40);
            } else if(gamepad2.dpad_down){
                leftDrive.setPower(-wheelPower + 40);
                rightDrive.setPower(-wheelPower + 40);
                leftDownDrive.setPower(-wheelPower + 40);
                rightDownDrive.setPower(-wheelPower + 40);
            } else {
                leftDrive.setPower(0);
                rightDrive.setPower(0);
                leftDownDrive.setPower(0);
                rightDownDrive.setPower(0);
            }
            
        }
    }
}
