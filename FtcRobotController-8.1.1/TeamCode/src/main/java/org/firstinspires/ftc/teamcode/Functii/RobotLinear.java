package org.firstinspires.ftc.teamcode.Functii;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class RobotLinear extends LinearOpMode {

    public Drive drive;

    public void initialize() {
        drive = new Drive(hardwareMap);
    }
}
