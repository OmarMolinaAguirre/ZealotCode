package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Zealot hardware class to define the drive on the robot.
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

@Autonomous(name="Test Autonomous Linear", group="Zealot")
@Disabled
public class Test_Original extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareZealot robot = new HardwareZealot();   // Use Zealot's hardware
    private ElapsedTime runtime = new ElapsedTime();


    static final double FORWARD_SPEED = 0.5;
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

        long startTime = System.nanoTime();

        DriveForwardByTurns(2);
        //System.out.println(System.nanoTime() - startTime);
        //startTime = System.nanoTime();


        StopAll();
        EndProgram();


        //END PROGRAM
    }

    public void DriveForward(double secs) {
        robot.leftMotorB.setPower(FORWARD_SPEED);
        robot.rightMotorB.setPower(FORWARD_SPEED);
        robot.leftMotorF.setPower(FORWARD_SPEED);
        robot.rightMotorF.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < secs)) {
            telemetry.addData("Path", "Drive Forward: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void DriveBackward(double secs) {
        robot.leftMotorB.setPower(-FORWARD_SPEED);
        robot.rightMotorB.setPower(-FORWARD_SPEED);
        robot.leftMotorF.setPower(-FORWARD_SPEED);
        robot.rightMotorF.setPower(-FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < secs)) {
            telemetry.addData("Path", "Drive Backwards: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void TurnRight(double secs) {
        // Step 2:  Spin right for x seconds
        robot.leftMotorB.setPower(-TURN_SPEED);
        robot.leftMotorF.setPower(-TURN_SPEED);
        robot.rightMotorB.setPower(TURN_SPEED);
        robot.rightMotorF.setPower(TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < secs)) {
            telemetry.addData("Path", "Turn Right: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }

    public void TurnLeft(double secs) {
        // Step :  Spin left for x seconds
        robot.leftMotorB.setPower(TURN_SPEED);
        robot.leftMotorF.setPower(TURN_SPEED);
        robot.rightMotorB.setPower(-TURN_SPEED);
        robot.rightMotorF.setPower(-TURN_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < secs)) {
            telemetry.addData("Path", "Turn Lert: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
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
        robot.leftMotorF.setPower(0);
        robot.rightMotorF.setPower(0);

        telemetry.addData("Path", "Stopped");
        telemetry.update();
        sleep(1000);
    }

    public void StopAll() {
        StopDriving();
        RedUp();
    }

    public void EndProgram() {
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }



    public void DriveForwardByTurns(int turns) {
        long turnCount = 0;
        robot.leftMotorB.setPower(FORWARD_SPEED);
        robot.rightMotorB.setPower(FORWARD_SPEED);
        robot.leftMotorF.setPower(FORWARD_SPEED);
        robot.rightMotorF.setPower(FORWARD_SPEED);


        while (opModeIsActive() && (turnCount < turns)) {
            telemetry.addData("Drive Forward, Turns Elapsed: ", turnCount);
            telemetry.update();
            if (robot.turnSensor.getValue() > .1) {
                turnCount++;
            }
        }
    }
}
