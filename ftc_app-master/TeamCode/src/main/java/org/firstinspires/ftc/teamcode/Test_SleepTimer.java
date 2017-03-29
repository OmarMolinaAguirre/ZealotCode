package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the Zealot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 */

@Disabled
@Autonomous(name="Test Sleep Timer (Working)", group="Zealot")
public class Test_SleepTimer extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareZealot robot = new HardwareZealot();   // Use Zealot's hardware
    private ElapsedTime runtime = new ElapsedTime();


    static final double FORWARD_SPEED = 0.5;
    static final double FORWARD_SPEED_LEFT_WHEEL = 0.5 - 0.105;
    static final double TURN_SPEED = 0.5;

    @Override
    public void runOpMode() {

        //Initialize Robot.
        robot.init(hardwareMap);
        //telemetry.setAutoClear(false);
        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        waitForStart();

        // BEGIN PROGRAM


        DriveForwardAlt(3.0);



        StopAll();
        EndProgram();


        //END PROGRAM
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
    public void DriveForwardAlt (double secs){
        robot.leftMotorB.setPower(FORWARD_SPEED_LEFT_WHEEL);
        robot.rightMotorB.setPower(FORWARD_SPEED);
        long time = (long) secs * 1000;
        telemetry.addData("Path", "Driving Forward");
        telemetry.update();
        sleep(time);
        StopDriving();
    }
}