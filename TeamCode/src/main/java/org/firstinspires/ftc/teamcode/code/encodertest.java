// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode.code;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class encodertest extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Motors
        DcMotor motor0 = hardwareMap.get(DcMotor.class, "motor0");
        DcMotor motor1 = hardwareMap.get(DcMotor.class, "motor1");
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "motor2");//Never turn it on after midnight
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "motor3");
        // Encoders
        DcMotor ency1 = hardwareMap.get(DcMotor.class, "motor0");
        DcMotor ency2 = hardwareMap.get(DcMotor.class, "motor1");
        DcMotor encx1 = hardwareMap.get(DcMotor.class, "motor2");
        // Servo(s)
        Servo servo0 = hardwareMap.get(Servo.class, "servo0");
        // Resets Encoders
        ency1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ency2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encx1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // This waits for start
        waitForStart();
        while (opModeIsActive()){
            // Variables for everything! Turning, and the encoders positions.
            double turn = gamepad1.right_stick_x;
            double y_move = gamepad1.left_stick_y;
            double ypos1 = ency1.getCurrentPosition();
            double ypos2 = ency2.getCurrentPosition();
            double xpos1 = encx1.getCurrentPosition();
            // If the turn and y_move are both at full power (1+1) it will move the servo
            if (turn + y_move == 2) {
                servo0.setPosition(1);
            } else {
                servo0.setPosition(0);
            }
            // This sets the motors power based on the turn and y movement
            motor0.setPower(y_move + turn);
            motor1.setPower(y_move + turn);
            motor3.setPower(y_move - turn);
            motor2.setPower(y_move - turn);
            // This puts the Encoders Positions into telemetry
            telemetry.addData("Encoder Y1 Position", ypos1);
            telemetry.addData("Encoder Y2 Position", ypos2);
            telemetry.addData("Encoder X1 Position", xpos1);
            telemetry.update();
        }

    }
}