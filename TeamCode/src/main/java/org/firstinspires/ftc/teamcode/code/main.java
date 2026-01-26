// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode.code;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="oldMain")

public class main extends LinearOpMode {
    @Override
    public void runOpMode() {
        encoders encoders = new encoders(hardwareMap);
        encoders.resetEncoders();
        // Motors
        DcMotor motor0 = hardwareMap.get(DcMotor.class, "motortl");
        DcMotor motor1 = hardwareMap.get(DcMotor.class, "motortr");
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "motorbl");
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "motorbr");
        DcMotorEx motor4 = hardwareMap.get(DcMotorEx.class, "launcher1");
        DcMotorEx motor5 = hardwareMap.get(DcMotorEx.class, "launcher2");
        motor3.setDirection(DcMotor.Direction.REVERSE);
        // Servo(s)
        Servo servo1 = hardwareMap.get(Servo.class,"Servo1");
        Servo servo2 = hardwareMap.get(Servo.class,"Servo2");
        // This waits for start
        waitForStart();
        while (opModeIsActive()){
            motor4.setPower(gamepad1.right_trigger);
            motor5.setPower(gamepad1.right_trigger);

            servo1.setPosition(gamepad1.left_trigger);
            // Variables for everything! Turning, and the encoders positions.
            double y_move = gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            double y1dist = encoders.y1distance();
            double y2dist = encoders.y2distance();
            double x1dist = encoders.x1distance();
            // This sets the motors power based on the turn and y movement
            motor0.setPower((y_move + turn)/2);
            motor1.setPower((y_move + turn)/2);
            motor2.setPower((y_move - turn)/2);
            motor3.setPower((y_move - turn)/2);
            telemetry.addData("Y1 Distance", y1dist);
            telemetry.addData("Y2 Distance", y2dist);
            telemetry.addData("X1 Distance", x1dist);
            telemetry.update();
        }
    }//HELP
}