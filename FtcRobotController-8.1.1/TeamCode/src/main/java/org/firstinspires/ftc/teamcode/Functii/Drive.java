package org.firstinspires.ftc.teamcode.Functii;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {

    private DcMotorEx FrontLeftMotor;
    private DcMotorEx RearLeftMotor;
    private DcMotorEx FrontRightMotor;
    private DcMotorEx RearRightMotor;
    private int p = 1050;
    private double motorPower = 1;


    public Drive(@NonNull HardwareMap hardwareMap) {

        FrontLeftMotor = hardwareMap.get(DcMotorEx.class, "FrontLeftMotor");
        RearLeftMotor = hardwareMap.get(DcMotorEx.class, "RearLeftMotor");
        FrontRightMotor = hardwareMap.get(DcMotorEx.class, "FrontRightMotor");
        RearRightMotor = hardwareMap.get(DcMotorEx.class, "RearRightMotor");

        FrontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RearRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        stopAndResetEncoderMode();
    }

    public void forward(double distance) {
        stopAndResetEncoderMode();
        int r = convert(distance);
        setTargetPosition(r, r, r, r);
        runToPositionMode();
        setVelocity(p, p, p, p);
        waitForMovement();
    }

    public void backward(double distance) {
        stopAndResetEncoderMode();
        int r = convert(-distance);
        setTargetPosition(r, r, r, r);
        runToPositionMode();
        setVelocity(p, p, p, p);
        waitForMovement();
    }

    public void left(double distance) {
        stopAndResetEncoderMode();
        int r1 = convert(distance);
        int r2 = convert(-distance);
        setTargetPosition(r2, r1, r2, r1);
        runToPositionMode();
        setVelocity(p, p, p, p);
        waitForMovement();
    }

    public void right(double distance) {
        stopAndResetEncoderMode();
        int r1 = convert(distance);
        int r2 = convert(-distance);
        setTargetPosition(r1, r2, r1, r2);
        runToPositionMode();
        setVelocity(p, p, p, p);
        waitForMovement();
    }

    public void goForward() {
        stopAndResetEncoderMode();
        runWithoutEncoderMode();
        setMotorPower(motorPower, motorPower, motorPower, motorPower);
    }

    public void goBackward() {
        stopAndResetEncoderMode();
        runWithoutEncoderMode();
        setMotorPower(-motorPower, -motorPower, -motorPower, -motorPower);
    }

    public void goLeft() {
        stopAndResetEncoderMode();
        runWithoutEncoderMode();
        setMotorPower(-motorPower, motorPower, -motorPower, motorPower);
    }

    public void goRight() {
        stopAndResetEncoderMode();
        runWithoutEncoderMode();
        setMotorPower(motorPower, -motorPower, motorPower, -motorPower);
    }

    public void stopMoving() {
        stopAndResetEncoderMode();
        setMotorPower(0, 0, 0, 0);
    }

    private void runWithoutEncoderMode() {
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RearLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RearRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private void stopAndResetEncoderMode() {
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    private void runToPositionMode() {
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RearLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RearRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    private void setVelocity(int frontLeft, int frontRight, int rearLeft, int rearRight) {
        FrontLeftMotor.setVelocity(frontLeft);
        FrontRightMotor.setVelocity(frontRight);
        RearLeftMotor.setVelocity(rearLeft);
        RearRightMotor.setVelocity(rearRight);
    }

    private void setTargetPosition(int frontLeft, int frontRight, int rearLeft, int rearRight) {
        FrontLeftMotor.setTargetPosition(frontLeft);
        FrontRightMotor.setTargetPosition(frontRight);
        RearLeftMotor.setTargetPosition(rearLeft);
        RearRightMotor.setTargetPosition(rearRight);
    }

    private void setMotorPower(double frontLeft, double frontRight, double rearLeft, double rearRight) {
        FrontLeftMotor.setPower(frontLeft);
        FrontRightMotor.setPower(frontRight);
        RearLeftMotor.setPower(rearLeft);
        RearRightMotor.setPower(rearRight);
    }

    private boolean isBusy() {
        return FrontLeftMotor.isBusy() || FrontRightMotor.isBusy() || RearLeftMotor.isBusy() || RearRightMotor.isBusy();
    }

    private void waitForMovement() {
        while (isBusy()) ;
    }

    public int convert(double distance) {
        double ticks = 28;
        double gear = 5;
        double circ = Math.PI * 5.31;
        return (int) ((distance * ticks * gear) / circ);
    }
}
