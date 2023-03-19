package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Functii.RobotTeleOp;

@TeleOp(name = "Gamepad", group = "Linear Opmode")

public class Gamepad extends RobotTeleOp {

    private Boolean UD = false, OC=false, RATA=false;

    public final void init() {
        super.initialize();
    }

    public final void loop() {
        movement();
        brat();
        telemetry.update();
    }

    private void movement() {
        if (gamepad1.dpad_left) {
            drive.goLeft();
        } else if (gamepad1.dpad_down) {
            drive.goBackward();
        } else if (gamepad1.dpad_right) {
            drive.goRight();
        } else if (gamepad1.dpad_up) {
            drive.goForward();
        } else {
            drive.stopMoving();
        }
    }

    private void brat() {
        if (gamepad1.x) {
            if (!UD) {
                brat.toggleUD();
                UD = true;
            }
        } else {
            UD = false;
        }
        if (gamepad1.a) {
            if (!OC) {
                brat.toggleOC();
                OC = true;
            }
        } else {
            OC = false;
        }
        if (gamepad1.b) {
            if (!RATA) {
                brat.toggleRata();
                RATA = true;
            }
        } else {
            RATA = false;
        }
    }
}
