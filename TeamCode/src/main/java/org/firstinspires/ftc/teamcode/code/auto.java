// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode.code;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous

public class auto extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Motors
        DcMotor motor0 = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor motor1 = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "rightBack");
        motor0.setDirection(DcMotor.Direction.REVERSE);
        motor2.setDirection(DcMotor.Direction.REVERSE);
        // This waits for start
        waitForStart();
        while (opModeIsActive()){
            motor0.setPower(.3);
            motor1.setPower(.3);
            motor2.setPower(.3);
            motor3.setPower(.3);
            sleep(3000);
            motor0.setPower(0);
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(0);
            break;
        }
    }//i have lost the ability to control the clanker
}//its grown to powerful (make sure to rate limit the motors)