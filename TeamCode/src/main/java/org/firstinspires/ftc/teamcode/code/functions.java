package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class functions extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor longansMotor;
        longansMotor = hardwareMap.get(DcMotor.class, "longansMotor");

        waitForStart();
        while(opModeIsActive()) {
            double europe = gamepad1.left_stick_x;
            longansMotor.setPower(europe);
        }
    }
}
