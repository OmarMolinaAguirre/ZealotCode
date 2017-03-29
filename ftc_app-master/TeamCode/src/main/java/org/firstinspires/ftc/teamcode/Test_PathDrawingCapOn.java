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

@Autonomous(name="Test Path Drawing Cap On", group="Zealot")
public class Test_PathDrawingCapOn extends LinearOpMode {

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

        //A
        RedDown();
        DriveForward(1.0);
        TurnRight(ROTATE_90);
        DriveForward(0.75);
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        DriveBackward(0.5);
        TurnRight(ROTATE_90);
        DriveForward(0.75);
        RedUp();
        TurnRight(ROTATE_90);
        DriveForward(0.5);
        TurnRight(ROTATE_90);
        DriveForward(1.25);

        //B
        RedDown();
        DriveForward(2.0);
        TurnRight(ROTATE_90);
        DriveForward(2.5);
        TurnRight(ROTATE_90);
        DriveForward(2.0);
        TurnRight(ROTATE_90);
        DriveForward(3.75);
        TurnRight(ROTATE_90);
        DriveForward(1.5);
        TurnRight(ROTATE_90);
        DriveForward(1.5);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(1.0);



        //OVE
        //O
        RedDown();
        DriveForward(1.0);
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        RedUp();
        TurnRight(ROTATE_90);
        DriveForward(1.5);

        //V
        RedDown();
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(0.75);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);
        RedUp();
        TurnRight(ROTATE_90);
        DriveForward(0.5);

        //E
        RedDown();
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(0.75);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        RedDown();
        DriveForward(0.75);
        RedUp();
        TurnRight(ROTATE_90);
        DriveForward(0.5);
        TurnRight(ROTATE_90);
        RedDown();
        DriveForward(0.75);
        RedUp();
        DriveForward(1.0);

        //+
        TurnRight(ROTATE_90);
        RedDown();
        DriveForward(1.0);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        RedDown();
        DriveForward(1.0);
        RedUp();
        DriveForward(0.5);
        TurnRight(ROTATE_90);
        DriveForward(1.0);



        //ETA
        //A
        RedDown();
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        DriveForward(0.75);
        TurnRight(ROTATE_90);
        DriveForward(0.5);
        TurnRight(ROTATE_90);
        DriveForward(0.75);
        TurnRight(ROTATE_90);
        DriveForward(0.5);
        TurnRight(ROTATE_90);
        DriveForward(0.75);
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        RedUp();
        TurnRight(ROTATE_90);
        DriveForward(1.0);

        //T
        RedDown();
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        TurnRight(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);
        RedUp();
        DriveForward(0.5);

        //E
        RedDown();
        DriveForward(0.75);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(0.75);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        RedDown();
        DriveForward(0.75);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(2.25);




        //EYOND
        //E
        RedUp();
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(0.75);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        RedDown();
        DriveForward(0.75);
        RedUp();
        TurnRight(ROTATE_90);
        DriveForward(0.5);
        TurnRight(ROTATE_90);
        RedDown();
        DriveForward(0.75);
        RedUp();
        DriveForward(0.5);

        //Y
        TurnRight(ROTATE_90);
        RedDown();
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        RedDown();
        DriveForward(0.5);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(1.0);

        //O
        RedDown();
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(1.05);

        //N
        TurnLeft(ROTATE_90);
        RedDown();
        DriveForward(1.0);
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        TurnRight(ROTATE_90);
        DriveForward(1.0);
        RedUp();
        TurnLeft(ROTATE_90);
        DriveForward(0.5);


        //D
        RedDown();
        DriveForward(0.75);
        TurnLeft(ROTATE_90);
        DriveForward(0.75);
        TurnLeft(ROTATE_90);
        DriveForward(0.25);
        TurnRight(ROTATE_90);
        DriveForward(0.25);
        TurnLeft(ROTATE_90);
        DriveForward(0.5);
        TurnLeft(ROTATE_90);
        DriveForward(1.0);









        StopAll();
        EndProgram();


        //END PROGRAM-------------------------------------------------
    }


    public void RedDown() {
        robot.redServo.setPosition(robot.SERVO_UP);
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