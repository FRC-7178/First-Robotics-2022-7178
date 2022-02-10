// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
 
package frc.robot;
 
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
 
/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {

  boolean Ocupid = false;

  private static final int kFrontLeftChannel = (0);
  private static final int kFrontLeftChannelB = (3);
  private static final int kRearLeftChannel = (4);
  private static final int kRearLeftChannelB = (5);
  private static final int kFrontRightChannel = (1);
  private static final int kFrontRightChannelB = (6);
  private static final int kRearRightChannel = (2);
  private static final int kRearRightChannelB = (7);
  private static final int kA = (9);
  private static final int kB = (8);
  private static final int dontfollowkB = (11);
  private static final int theOtherOneIGuess = (10);

  //new shooter vars

private static final int shooter1Happy = (13);
private static final int shooter1Happier = (14);
    

  
  
  
  //Movement vars
  private static final WPI_TalonSRX frontLeft = new WPI_TalonSRX(kFrontLeftChannel);
  private static final WPI_TalonSRX rearLeft = new WPI_TalonSRX(kRearLeftChannel);
  private static final WPI_TalonSRX frontRight = new WPI_TalonSRX(kFrontRightChannel);
  private static final WPI_TalonSRX rearRight = new WPI_TalonSRX(kRearRightChannel);
  private static final WPI_TalonSRX frontLeftB = new WPI_TalonSRX(kFrontLeftChannelB);
  private static final WPI_TalonSRX rearLeftB = new WPI_TalonSRX(kRearLeftChannelB);
  private static final WPI_TalonSRX frontRightB = new WPI_TalonSRX(kFrontRightChannelB);
  private static final WPI_TalonSRX rearRightB = new WPI_TalonSRX(kRearRightChannelB);
  //intake vars
  private static final WPI_TalonSRX intakeHappy = new WPI_TalonSRX(kB);
  private static final WPI_TalonSRX dontfollowIntakeHappy = new WPI_TalonSRX(dontfollowkB);
  //shooter vars
  private static final WPI_TalonFX conveyorBeltHappy = new WPI_TalonFX(kA);
  private static final WPI_TalonFX bottomShooterHappy = new WPI_TalonFX(theOtherOneIGuess);

  //new shooter vars
  private static final WPI_TalonFX firstShooterSadMaybe = new WPI_TalonFX(shooter1Happy);
  private static final WPI_TalonFX firstShooterSadMaybeNot = new WPI_TalonFX(shooter1Happier);


  private static final int kJoystickChannel = 0;
 
  private MecanumDrive m_robotDrive;
  private XboxController m_stick;
 
  @Override
  public void robotInit() {
 
    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontRightB.follow(frontRight);    
    frontLeftB.follow(frontLeft);    
    rearRightB.follow(rearRight);    
    rearLeftB.follow(rearLeft);    
    frontRight.setInverted(true);
    rearRight.setInverted(true);
    frontRightB.setInverted(true);
    rearRightB.setInverted(true);
    conveyorBeltHappy.setInverted(true);

 
    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
 
    m_stick = new XboxController(kJoystickChannel);
  }
 
  @Override
  public void teleopPeriodic() {
    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.


    //The .getLeftY() is inverted so that the front of the robot actually goes forwards when the stick is moved forwards
    m_robotDrive.driveCartesian( m_stick.getLeftY(), (-1)* m_stick.getLeftX(), m_stick.getRightX(), 0.0);
   

      //For the conveyor belt
      // if(m_stick.getYButton()){
      //   firstShooterSadMaybe.set(1);
      // }else{
      //   firstShooterSadMaybe.set(0);
      // }



    //for de shooter
    if(m_stick.getAButton()){
      conveyorBeltHappy.set(1);
      firstShooterSadMaybe.set(-0.4);
      //firstShooterSadMaybe.set(1);
      firstShooterSadMaybeNot.set(0.6);
      bottomShooterHappy.set(0.8);
      
    }else{
      firstShooterSadMaybe.set(0);
      conveyorBeltHappy.set(0);
      //firstShooterSadMaybe.set(0);
      firstShooterSadMaybeNot.set(0);
      bottomShooterHappy.set(0);
    }





    //for de intake
    if(m_stick.getBButton()){
      //RUUUUUUUUUUUUN HELP
      
      //astil cals both intake moters with their own
      intakeHappy.set(0.5);
      dontfollowIntakeHappy.set(0.5);

    }else{
      //??? so cunfusased

      intakeHappy.set(0);
      dontfollowIntakeHappy.set(0);
    }
    











  }
}
 

