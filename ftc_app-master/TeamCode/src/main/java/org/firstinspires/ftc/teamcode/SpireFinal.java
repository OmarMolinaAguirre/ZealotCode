package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is the file you gotta run.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *
 *   The desired path in this example is on paper, just look at
 *   it. I don't feel like copying it right now.
 */

@Autonomous(name="FINAL Path Spire", group="Zealot")
public class SpireFinal extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareZealot robot = new HardwareZealot();   // Use Zealot's hardware
    private ElapsedTime runtime = new ElapsedTime();


    static final double FORWARD_SPEED =                                        0.5;
    static final double FORWARD_SPEED_LEFT_WHEEL =           FORWARD_SPEED - 0.105;
    static final double TURN_SPEED =                           FORWARD_SPEED * 0.5;
    static final double TURN_SPEED_LEFT_WHEEL =     FORWARD_SPEED_LEFT_WHEEL * 0.5;
    static final long ROTATE_180 =                                            2950;
    static final long ROTATE_90 =                                             1550;

    @Override
    public void runOpMode() {

        //Initialize Robot.
        robot.init(hardwareMap);
        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        waitForStart();

        // BEGIN PROGRAM-----------------------------------------------
        double counter = 0;
        double rand;
        RedDown();

        while (opModeIsActive() && (runtime.seconds() < 30.0)){
            robot.leftMotorB.setPower(0.895);
            robot.rightMotorB.setPower(counter / 600000.0);




            telemetry.addData("Wheel speed", (counter / 600000.0));
            telemetry.update();

            counter += 0.25
             ;
        }


        StopAll();
        EndProgram();


        //END PROGRAM-------------------------------------------------
    }


    public void RedDown() {
        robot.redServo.setPosition(robot.MID_SERVO);
        telemetry.addData("Path", "Red Down");
        telemetry.update();
    }

    public void RedUp() {
        robot.redServo.setPosition(robot.SERVO_UP);
        telemetry.addData("Path", "Red Up");
        telemetry.update();
    }

    public void StopDriving() {
        robot.leftMotorB.setPower(0);
        robot.rightMotorB.setPower(0);

        telemetry.addData("Path", "Stopped");
        telemetry.update();
    }

    public void StopAll() {
        StopDriving();
        RedUp();
    }

    public void EndProgram() {
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(5000);
    }


// Test Methods
    public void DriveForward (double secs){
        robot.leftMotorB.setPower(FORWARD_SPEED_LEFT_WHEEL);
        robot.rightMotorB.setPower(FORWARD_SPEED);
        long time = (long) (secs * 1000);
        telemetry.addData("Path", "Driving Forward");
        telemetry.update();
        sleep(time);
        StopDriving();
    }

    public void DriveBackward (double secs){
        robot.leftMotorB.setPower(-FORWARD_SPEED_LEFT_WHEEL);
        robot.rightMotorB.setPower(-FORWARD_SPEED);
        long time = (long) (secs * 1000);
        telemetry.addData("Path", "Driving Forward");
        telemetry.update();
        sleep(time);
        StopDriving();
    }

    public void TurnRight (long rot){
        robot.leftMotorB.setPower(TURN_SPEED_LEFT_WHEEL);
        robot.rightMotorB.setPower(-TURN_SPEED);
        telemetry.addData("Path", "Turning Right");
        telemetry.update();
        sleep(rot);
        StopDriving();
    }

    public void TurnLeft (long rot){
        robot.leftMotorB.setPower(-TURN_SPEED_LEFT_WHEEL);
        robot.rightMotorB.setPower(TURN_SPEED);
        telemetry.addData("Path", "Turning Left");
        telemetry.update();
        sleep(rot);
        StopDriving();
    }

}