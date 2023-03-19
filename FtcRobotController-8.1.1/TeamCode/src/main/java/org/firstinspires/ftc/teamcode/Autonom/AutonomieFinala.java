package org.firstinspires.ftc.teamcode.Autonom;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Functii.RobotLinear;

@Autonomous(name = "AutonomieFinala", group = "Final")

public class AutonomieFinala extends RobotLinear {


    @Override
    public void runOpMode() {
        initialize();

        waitForStart();
        drive.forward(30);
        drive.backward(30);
        drive.left(30);
        drive.right(30);
    }
}
