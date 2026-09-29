package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp_2026_2027", group="Iterative OpMode")
public class TeleOp_2026_2027 extends OpMode
{
    //---Declare Motors---//
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
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        launcherMotor = hardwareMap.get(DcMotor.class, "launcherMotor");

        //---Set Motor Directions---//
        leftDrive.setDirection(DcMotor.Direction.REVERSE);

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
        runtime.reset();
    }

    //---Code to run REPEATEDLY after the driver hits START but before they hit STOP---//
    @Override
    public void loop() 
    {
        launcher();
        intake();
    }

    //---Code to run ONCE after the driver hits STOP---//
    @Override
    public void stop() 
    {
    
    }
    
    public void drivebase()
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

}
