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

@Autonomous(name="Test Encoder Setup (Newest)", group="Zealot")
public class Test_EncoderSetup extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareZealot robot = new HardwareZealot();   // Use Zealot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                                                          (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.2;
    static final double     d180                = 9.0 * Math.PI;
    static final double     d90                 = d180 / 2;




    @Override
    public void runOpMode() {

        //Initialize Robot.
        robot.init(hardwareMap);
        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        waitForStart();

        // BEGIN PROGRAM-----------------------------------------------

        sleep(3000);

        DriveForward(24);
        TurnLeft(d90);
        TurnRight(d180);
        TurnLeft(d90);
        DriveBackward(24);


        StopAll();
        EndProgram();


        //END PROGRAM-------------------------------------------------
    }


    public void MarkerDown() {
        robot.redServo.setPosition(robot.MID_SERVO);
        telemetry.addData("Path", "Red Down");
        telemetry.update();
    }

    public void MarkerUp() {
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
        MarkerUp();
    }

    public void EndProgram() {
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(5000);
    }


// Test Methods

    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = robot.leftMotorB.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = robot.rightMotorB.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            robot.leftMotorB.setTargetPosition(newLeftTarget);
            robot.rightMotorB.setTargetPosition(newRightTarget);



            // reset the timeout time and start motion.
            runtime.reset();
            robot.leftMotorB.setPower(Math.abs(speed));
            robot.rightMotorB.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.leftMotorB.isBusy() && robot.rightMotorB.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d",
                        robot.leftMotorB.getCurrentPosition(),
                        robot.rightMotorB.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            robot.leftMotorB.setPower(0);
            robot.rightMotorB.setPower(0);



            //  sleep(250);   // optional pause after each move
        }
    }
    
    //Weird Methods

    public void DriveForward (double dist){
        encoderDrive(DRIVE_SPEED, dist, dist, 10.0);
    }

    public void DriveBackward (double dist){
        encoderDrive(DRIVE_SPEED, -dist, -dist, 10.0);
    }

    public void TurnRight (double rot){
        encoderDrive(DRIVE_SPEED, rot, -rot, 10.0);
    }

    public void TurnLeft (double rot){
        encoderDrive(DRIVE_SPEED, rot, -rot, 10.0);
    }

}