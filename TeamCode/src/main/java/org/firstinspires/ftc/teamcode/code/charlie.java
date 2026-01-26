package org.firstinspires.ftc.teamcode.code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class charlie extends LinearOpMode {
    DcMotor motor1 = hardwareMap.get(DcMotor.class, "motor1");
    Servo servo1 = hardwareMap.get(Servo.class, "servo2");

    @Override
    public void runOpMode() throws InterruptedException {
        motor1.setPower(gamepad1.right_trigger);
        servo1.setPosition(1);
        motor1.getCurrentPosition();
    }
}