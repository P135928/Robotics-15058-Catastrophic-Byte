// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class main extends LinearOpMode {
    @Override
    public void runOpMode() {
        encoders encoders = new encoders(hardwareMap);
        encoders.resetEncoders();
        // Motors
        DcMotor motortl = hardwareMap.get(DcMotor.class, "motortl");
        DcMotor motortr = hardwareMap.get(DcMotor.class, "motor1");
        DcMotor motorbl = hardwareMap.get(DcMotor.class, "motor2");
        DcMotor motorbr = hardwareMap.get(DcMotor.class, "motor3");
        // Reverse right side motors so they spin forward correctly
        motortr.setDirection(DcMotor.Direction.REVERSE);
        motorbr.setDirection(DcMotor.Direction.REVERSE);
        // Add brake power so it never jitters when swapping opModes
        motortl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motortr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // This waits for start
        waitForStart();
        while (opModeIsActive()){
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            motortl.setPower(y + x + turn);
            motorbl.setPower(y - x + turn);
            motortr.setPower(y - x - turn);
            motorbr.setPower(y + x - turn);

            // Telemetry for debugging
            telemetry.addData("Y1 Distance", encoders.y1distance());
            telemetry.addData("Y2 Distance", encoders.y2distance());
            telemetry.addData("X1 Distance", encoders.x1distance());
            telemetry.update();
        }
    }
}