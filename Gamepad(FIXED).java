//overcommenting edition
package org.firstinspires.ftc.teamcode; //import le package
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //import said Linear OP mode type
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //import teleop
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //import zed teleop
import com.qualcomm.robotcore.hardware.DcMotor; //import la dcmotor class
import com.qualcomm.robotcore.hardware.Servo; //import the servo class
import com.qualcomm.robotcore.util.ElapsedTime; // i dunno just import this stuff
import com.qualcomm.robotcore.util.Range;
//blank line
//blank line
@TeleOp(name="Gamepad", group="Linear Opmode")
//@Disabled
public class Gamepad extends LinearOpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor leftDownDrive;
    DcMotor rightDownDrive;
    double power = 1;
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
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDownDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDownDrive.setDirection(DcMotor.Direction.REVERSE);
        // liftMotor.setDirection(DcMotor.Direction.FORWARD); //change when making launcher
        // launcherMotor2.setDirection(DcMotor.Direction.FORWARD);
        // intakeMotor.setDirection(DcMotor.Direction.FORWARD); //change when making intake

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Setup a variable for each drive wheel to save power level for telemetry
            double wheelPower;
            //double intakePower;
            wheelPower = 0.85; //different speeds, change to 1.00 for 100 percent of the motor's RPM
            //intakePower = .5; //change later
            //launcher
            //
            // if(gamepad1.right_trigger>0.5){wobbleArm.setPower(wheelPower);}else if(gamepad1.right_bumper){wobbleArm.setPower(-wheelPower);}else{wobbleArm.setPower(0);}
            // if(gamepad1.left_trigger>0.5){firstWheel.setPower(wheelPower);}else if(gamepad1.left_bumper) {firstWheel.setPower(-wheelPower);}else{firstWheel.setPower(0);}
            
            //Turning
            if(gamepad1.left_stick_x>0.75){
                leftDrive.setPower(wheelPower);
                rightDrive.setPower(-wheelPower);
                leftDownDrive.setPower(wheelPower);
                rightDownDrive.setPower(-wheelPower);
           
            } else if (gamepad1.left_stick_x<-0.75){
                leftDrive.setPower(-wheelPower);
                rightDrive.setPower(wheelPower);
                leftDownDrive.setPower(-wheelPower);
                rightDownDrive.setPower(wheelPower);  
            //forward and backwards
             } else if (gamepad1.right_stick_y>0.75){
                leftDrive.setPower(wheelPower);
                rightDrive.setPower(wheelPower);
                leftDownDrive.setPower(wheelPower);
                rightDownDrive.setPower(wheelPower);

            } else if (gamepad1.right_stick_y<-0.75){
                leftDrive.setPower(-wheelPower);
                rightDrive.setPower(-wheelPower);
                leftDownDrive.setPower(-wheelPower);
                rightDownDrive.setPower(-wheelPower);

            }//else if (gamepad1.right_trigger>0.5){
            //     liftMotor.setPower(launchPower);

            // }else if (gamepad1.right_bumper){
            //     liftMotor.setPower(-launchPower);
            // }
        }
    }
}
