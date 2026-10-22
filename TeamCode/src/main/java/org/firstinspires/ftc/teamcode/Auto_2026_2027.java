package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

@Autonomous(name="Auto_2026_2027", group="Robot")
public class Auto_2026_2027 extends OpMode {

    //---Declare OpMode members.---//
    private DcMotor motorFR;
    private DcMotor motorFL;
    private DcMotor motorBR;
    private DcMotor motorBL;
    //private DcMotor intakeMotor;
    //private DcMotor launcherMotor;
    GoBildaPinpointDriver pinpoint;


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
        //intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        //launcherMotor = hardwareMap.get(DcMotor.class, "launcherMotor");
        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");

        //---Set Motor Directions---//
        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorFR.setDirection(DcMotor.Direction.FORWARD);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        motorBR.setDirection(DcMotor.Direction.FORWARD);

        //---Add telemetry data---//
        telemetry.addData("Status", "Initialized");

        configurePinpoint();

        pinpoint.setPosition(new Pose2D(DistanceUnit.INCH, 0, 0, AngleUnit.DEGREES, 0));

    }

    public void forward() {
        motorFR.setPower(1);
        motorFL.setPower(1);
        motorBR.setPower(1);
        motorBL.setPower(1);
    }

    public void stopMoving() {
        motorFR.setPower(0);
        motorFL.setPower(0);
        motorBR.setPower(0);
        motorBL.setPower(0);
    }


    public void configurePinpoint(){
       //remember to set offsets
        pinpoint.setOffsets(-84.0, -168.0, DistanceUnit.MM);

        // If you're using goBILDA odometry pods, select either the goBILDA_SWINGARM_POD, or the goBILDA_4_BAR_POD.
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);

        /*
         * Set the direction that each of the two odometry pods count. The X (forward) pod should
         * increase when you move the robot forward. And the Y (strafe) pod should increase when
         * you move the robot to the left.
         */
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.FORWARD);

        pinpoint.resetPosAndIMU();
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
        forward();
        sleep(1000);
        stopMoving();
    }

    //---Code to run REPEATEDLY after the driver hits START but before they hit STOP---//
    @Override
    public void loop()
    {
        pinpoint.update();
        Pose2D pose2D = pinpoint.getPosition();

        telemetry.addData("X coordinate (IN)", pose2D.getX(DistanceUnit.INCH));
        telemetry.addData("Y coordinate (IN)", pose2D.getY(DistanceUnit.INCH));
        telemetry.addData("Heading angle (DEGREES)", pose2D.getHeading(AngleUnit.DEGREES));
    }
}
//NRuke