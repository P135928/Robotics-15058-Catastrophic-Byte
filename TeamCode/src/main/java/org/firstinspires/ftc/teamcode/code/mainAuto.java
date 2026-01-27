// This imports all the packages and libs.
package org.firstinspires.ftc.teamcode.code;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous
public class mainAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Initial pose
        Pose2d beginPose = new Pose2d(0, 0, 0);
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        // Build the trajectory to move back 10 inches using coordinates
        Action robotAuto = drive.actionBuilder(beginPose)
                .lineToX(-10)
                .build();
        // Wait for the driver to press start
        waitForStart();

        if (isStopRequested()) return;

        // Execute the trajectory
        Actions.runBlocking(robotAuto);
    }
}
