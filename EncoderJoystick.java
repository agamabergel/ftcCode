package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;




@TeleOp(name = "gamepad", group = "tests")
public class EncoderJoystick extends LinearOpMode {

    private DcMotor FLMotor;
    private DcMotor BLMotor;
    private DcMotor FRMotor;
    private DcMotor BRMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        FLMotor = hardwareMap.dcMotor.get("FLMotor");
        BLMotor = hardwareMap.dcMotor.get("BRMotor");
        FRMotor = hardwareMap.dcMotor.get("FRMotor");
        BRMotor = hardwareMap.dcMotor.get("BRMotor");

        DriveClass driveClass = new DriveClass(FLMotor, FRMotor, BLMotor, BRMotor);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive())
        {
            double leftY = -gamepad1.left_stick_y; 
            double leftX = gamepad1.left_stick_x * 1.1; 
            double rightX = gamepad1.right_stick_x;


            double denominator = Math.max(Math.abs(leftY) + Math.abs(leftX) + Math.abs(rightX), 1);
            double frontLeftPower = (leftY + leftX + rightX) / denominator;
            double backLeftPower = (leftY - leftX + rightX) / denominator;
            double frontRightPower = (leftY - leftX - rightX) / denominator;
            double backRightPower = (leftY + leftX - right) / denominator;

            FLMotor.setPower(frontLeftPower);
            BLMotor.setPower(backLeftPower);
            FRMotor.setPower(frontRightPower);
            BRMotor.setPower(backRightPower);

            //other option for redians of the deriction of the joystick
            //Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x)
            }
        }
    }
}