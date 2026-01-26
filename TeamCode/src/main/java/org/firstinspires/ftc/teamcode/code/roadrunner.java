package org.firstinspires.ftc.teamcode.code;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@TeleOp(name="USE ME!!! ME NO ONE ELSE!!!", group="TeleOp")
public class roadrunner extends LinearOpMode {
    @Override
    public void runOpMode() {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        Servo servoa = hardwareMap.get(Servo.class, "servoa");
        servoa.setDirection(Servo.Direction.REVERSE);
        DcMotor motora = hardwareMap.get(DcMotor.class, "motora");
        waitForStart();

        while (opModeIsActive()) {
            // Get driver control input
            double x = -gamepad1.left_stick_y;   // forward/back
            double y = -gamepad1.left_stick_x;   // strafe
            double turn = -gamepad1.right_stick_x; // rotate
            // Road Runner 0.5 drive control
            drive.setDrivePowers(
                    new PoseVelocity2d(
                            new Vector2d(x, y),
                            turn
                    )
            );
            drive.updatePoseEstimate();
            if (gamepad2.a) {
                motora.setPower(1);
            } else {
                motora.setPower(0);
            }
            servoa.setPosition(gamepad2.right_trigger);
        }
    }
}
