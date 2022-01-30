//Origional code source at docs.ctre-phoenix.com/en/stable/ch13_MC.html

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Shooter extends TimedRobot {

  TalonSRX _talon0 = new TalonSRX(8);
  Joystick _joystick = new Joystick(8);

  @Override
  public void teleopPeriodic(){
    double stick = _joystick.getRawAxis(1);
    _talon0.set(ControlMode.PercentOutput, stick);
  }

}