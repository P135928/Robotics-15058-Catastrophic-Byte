// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode.code;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous
public class oldAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Motors
        DcMotor motortl = hardwareMap.get(DcMotor.class, "leftFront"); // slot 0
        DcMotor motortr = hardwareMap.get(DcMotor.class, "rightFront"); // slot 1
        DcMotor motorbl = hardwareMap.get(DcMotor.class, "leftBack"); // slot 2
        DcMotor motorbr = hardwareMap.get(DcMotor.class, "rightBack"); //slot 3
        // Setting the brake power to 0 so it doesn't jitter
        motortl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motortr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Reversing the motors for proper driving
        motortl.setDirection(DcMotor.Direction.REVERSE);
        motorbl.setDirection(DcMotor.Direction.REVERSE);
        // This waits for start
        waitForStart();
        //noinspection LoopStatementThatDoesntLoop
        while (opModeIsActive()){
            motortl.setPower(.3);
            motortr.setPower(.3);
            motorbl.setPower(.3);
            motorbr.setPower(.3);
            sleep(3000);
            motortl.setPower(0);
            motortr.setPower(0);
            motorbl.setPower(0);
            motorbr.setPower(0);
            break;
        }
    }//i have lost the ability to control the clanker
}//its grown to powerful (make sure to rate limit the motors)