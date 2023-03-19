package org.firstinspires.ftc.teamcode.Functii;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class RobotTeleOp extends OpMode {

    public Drive drive;
    public Brat brat;

    public void initialize() {
        drive = new Drive(hardwareMap);
        brat = new Brat(hardwareMap);
    }
}
