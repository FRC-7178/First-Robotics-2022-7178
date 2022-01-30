package frc.robot;

//Imports stuff, I need this please dont telslaew 
 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;






public class Shooter extends TimedRobot{

    private MecanumDrive m_robotDrive;
      private XboxController m_stick;



    private static final int kSideChannel = (8);

    private static final WPI_TalonSRX shooter = new WPI_TalonSRX(kSideChannel);

    m_robotDrive = new MecanumDrive(shooter);

    private static final int kJoystickChannel = 0;


    @Override
    public void teleopPeriodic() {



        m_robotDrive.driveCartesian( (-1)* m_stick.getLeftY(), m_stick.getLeftX(), m_stick.getRightX(), 0.0);
    }
}

