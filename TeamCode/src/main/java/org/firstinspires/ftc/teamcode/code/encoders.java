package org.firstinspires.ftc.teamcode.code;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class encoders {
    DcMotor ency1, ency2, encx1;
    public encoders(HardwareMap hwMap) {
        ency1 = hwMap.get(DcMotor.class, "motortl");
        ency2 = hwMap.get(DcMotor.class, "motortr");
        encx1 = hwMap.get(DcMotor.class, "motorbl");
    }
    public double y1distance() {

        double ypos1 = ency1.getCurrentPosition();
        return ticksToDistance(ypos1);
    }
    public double y2distance() {
        double ypos2 = ency2.getCurrentPosition();
        return ticksToDistance(ypos2);
    }
    public double x1distance() {
        double xpos1 = encx1.getCurrentPosition();
        return ticksToDistance(xpos1);
    }
    public void resetEncoders() {
        ency1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ency2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encx1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        ency1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ency2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        encx1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private double ticksToDistance(double ticks) {
        final int ppr = 2000;
        final double diameter = 1.259843; // in but is 32mm
        double circumference = Math.PI * diameter;
        double revolutions = ticks / ppr;
        return circumference * revolutions;
    }
}