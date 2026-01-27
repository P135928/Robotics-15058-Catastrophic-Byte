// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode.code;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name="driveTrain_Tester")
public class main extends LinearOpMode {
    @Override
    public void runOpMode() {
        encoders encoders = new encoders(hardwareMap);
        encoders.resetEncoders();
        // Motors
        DcMotor motortl = hardwareMap.get(DcMotor.class, "leftFront"); // slot 0
        DcMotor motortr = hardwareMap.get(DcMotor.class, "rightFront"); // slot 1
        DcMotor motorbl = hardwareMap.get(DcMotor.class, "leftBack"); // slot 2
        DcMotor motorbr = hardwareMap.get(DcMotor.class, "rightBack"); //slot 3
        DcMotor motorLauncher = hardwareMap.get(DcMotor.class, "launcher"); // slot something
        // Setting the brake power to 0 so it doesn't jitter
        motortl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motortr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Reversing the motors for proper driving
        motortl.setDirection(DcMotor.Direction.REVERSE);
        motorbl.setDirection(DcMotor.Direction.REVERSE);
        // Servo(s)
        Servo servo1 = hardwareMap.get(Servo.class,"Servo1");
        // This waits for start
        waitForStart();
        while (opModeIsActive()){
            motorLauncher.setPower(gamepad1.right_trigger);
            servo1.setPosition(gamepad1.left_trigger / 2);
            // Variables for everything! Turning, and the encoders positions.
            double x_move = gamepad1.right_stick_x;
            double y_move = gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            double y1dist = encoders.y1distance();
            double y2dist = encoders.y2distance();
            double x1dist = encoders.x1distance();
            // This sets the motors power based on the turn and y movement
            motortl.setPower((y_move + turn + x_move) / 2);
            motortr.setPower((y_move - turn - x_move) / 2);
            motorbl.setPower((y_move + turn - x_move) / 2);
            motorbr.setPower((y_move - turn + x_move) / 2);
            telemetry.addData("Y1 Distance", String.valueOf(y1dist), "Inches travelled");
            telemetry.addData("Y2 Distance", String.valueOf(y2dist), "Inches travelled");
            telemetry.addData("X1 Distance", String.valueOf(x1dist), "Inches travelled");
            telemetry.update();
        }
    }//HELP
}