package org.firstinspires.ftc.teamcode.code;
import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class mason extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        DcMotor launcher = hardwareMap.get(DcMotor.class, "launcher");

        leftMotor.setDirection(REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        Servo rightLauncher = hardwareMap.get(Servo.class, "rightFeeder");
        Servo leftLauncher = hardwareMap.get(Servo.class, "leftFeeder");
//deez
        leftMotor.setZeroPowerBehavior(BRAKE);
        rightMotor.setZeroPowerBehavior(BRAKE);
        launcher.setZeroPowerBehavior(BRAKE);

        double leftPower;
        double rightPower;
    }
}
