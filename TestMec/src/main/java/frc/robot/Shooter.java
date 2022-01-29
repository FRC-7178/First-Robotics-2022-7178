package frc.robot;

//Imports stuff, I need this please dont telslaew 
 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;






public class Shooter extends TimedRobot{
    private static final int LEFT_TRIGGER = (8);

    private static final WPI_TalonSRX shooter = new WPI_TalonSRX(LEFT_TRIGGER);




    


    @Override
    public void teleopPeriodic() {



  
    }
}