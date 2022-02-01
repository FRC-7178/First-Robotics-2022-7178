//Origional code source at docs.ctre-phoenix.com/en/stable/ch13_MC.html

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.XboxController.Button;

public class Shooter extends TimedRobot {

  TalonSRX talon8 = new TalonSRX(8);
  Joystick _joystick = new Joystick(8);
  
  //private static final int kA = (8);
  //private static final WPI_TalonSRX  = new WPI_TalonSRX(kA);



  @Override
  public void teleopPeriodic(){
    double stick = _joystick.getRawAxis(1);
    talon8.set(ControlMode.PercentOutput, stick);
  }

}
