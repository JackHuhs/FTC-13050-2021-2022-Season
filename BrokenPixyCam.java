package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //import said Linear OP mode type
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //import teleop
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //import zed teleop
import com.qualcomm.robotcore.hardware.DcMotor; //import la dcmotor class
import com.qualcomm.robotcore.hardware.Servo; //import the servo class
import com.qualcomm.robotcore.util.ElapsedTime; // i dunno just import this stuff
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class TestFile extends LinearOpMode{

    
    pixyCam = I2cDeviceSynch;

    pixyCam2 = harwareMap.I2cDeviceSynch.get("pixyCam");


    Pixy_LEGO_Protocol_1.0.pdf;


    pixyCam2.engage();

    sign1 = pixyCam.read(0x51,5);

    sign2 = pixyCam.read(0x52,5);

    telemetry.addData("X value of sign1", 0xff&sign1[1]);

    telemetry.addData("X value of sign2", 0xff&sign2[1]);

}
