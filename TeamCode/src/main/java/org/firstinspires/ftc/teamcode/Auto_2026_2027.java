package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto_2026_2027", group="Robot")
public class Auto_2026_2027 extends OpMode {

    //---Declare OpMode members.---//
    private DcMotor motorFR;
    private DcMotor motorFL;
    private DcMotor motorBR;
    private DcMotor motorBL;


    private ElapsedTime runtime = new ElapsedTime();

    //---Code to run ONCE when the driver hits INIT---//
    @Override
    public void init()
    {
        //---Initialize Motors---//
        motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");

        //---Set Motor Directions---//
        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);

        //---Add telemetry data---//
        telemetry.addData("Status", "Initialized");

    }

    public void forward() {
        motorFR.setPower(1);
        motorFL.setPower(1);
        motorBR.setPower(1);
        motorBL.setPower(1);
    }
    public void stop() {
        motorFR.setPower(0);
        motorFL.setPower(0);
        motorBR.setPower(0);
        motorBL.setPower(0);
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
        forward();
        Thread.sleep(1000);
        stop();
    }
}
