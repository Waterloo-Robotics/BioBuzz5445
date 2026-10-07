
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp_2026_2027", group="Iterative OpMode")
public class TeleOp_2026_2027 extends OpMode
{
    //---Declare Motors---//
    //private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorFR = null;
    private DcMotor motorFL = null;
    private DcMotor motorBR = null;
    private DcMotor motorBL = null;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorFR;
    private DcMotor intakeMotor;
    private DcMotor launcherMotor;

    boolean intakeOn = false;
    boolean launcherOn = false;

    //---Code to run ONCE when the driver hits INIT---//
    @Override
    public void init() 
    {
        //---Initialize Motors---//
        motorFR  = hardwareMap.get(DcMotor.class, "motorFR");
        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        launcherMotor = hardwareMap.get(DcMotor.class, "launcherMotor");

        //---Set Motor Directions---//
        motorFR.setDirection(DcMotor.Direction.FORWARD);
        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        motorBR.setDirection(DcMotor.Direction.FORWARD);
        //---Add telemetry data---//
        telemetry.addData("Status", "Initialized");
    }



    //---Code to run REPEATEDLY after the driver hits INIT, but before they hit START---//
    @Override

    public void init_loop() 
    {
    
    }

    //---Code to run ONCE when the driver hits START---//
    @Override
    public void start() 
    {
        //runtime.reset();
    }

    //---Code to run REPEATEDLY after the driver hits START but before they hit STOP---//
    @Override
    public void loop() 
    {

        driveBase();

        launcher();
        intake();
    }

    //---Code to run ONCE after the driver hits STOP---//
    @Override
    public void stop() 
    {
    
    }

    
    public void launcher()
    {
        launcherOn = gamepad1.dpad_up;

        if(launcherOn){
            launcherMotor.setPower(1);
        }
        else{
            launcherMotor.setPower(0);
        }
    }
    
    public void intake()
    {
        if(gamepad1.aWasReleased()){
            intakeOn = !intakeOn;
        }

        if(intakeOn){
            intakeMotor.setPower(1);
        }
        else{
            launcherMotor.setPower(0);
        }
    }
    
    public void hood()
    {
    
    }

    public void driveBase()
    {
        //Get variables from the gamepad
        double driveForward = -gamepad1.left_stick_y;
        double driveSide = gamepad1.left_stick_x;
        double driveTurn = gamepad1.right_stick_x;
        
        //Translate inputs to outputs for motors
        motorBL.setPower (driveForward + driveTurn - driveSide);
        motorBR.setPower (driveForward - driveTurn + driveSide);
        motorFL.setPower (driveForward + driveTurn + driveSide);
        motorFR.setPower (driveForward - driveTurn - driveSide);
    
    }

}
