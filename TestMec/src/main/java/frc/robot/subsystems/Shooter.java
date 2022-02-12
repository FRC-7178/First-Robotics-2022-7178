package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.XboxController;


public class Shooter extends SubsystemBase {
    /** Creates a new Shooter subsystem. */

    private static final int shooterFront = (13);
    private static final int shooterBottom = (14);

    private static final WPI_TalonFX frontShooterHappy = new WPI_TalonFX(shooterFront);
    private static final WPI_TalonFX bottomShooterHappy = new WPI_TalonFX(shooterBottom);

    public final double shooterSpeed = 0.3;

    /*
     * @Override
     * public void periodic() {
     * 
     * }
     * 
     * @Override
     * public void simulationPeriodic() {
     * // This method will be called once per scheduler run during simulation
     * }
     */

    public void shootSTD() {
        frontShooterHappy.set(1); //Change this speed later
    }

    public void shootFast() {
        final float shooterSpeedFastHappy = 5; //change value later
        frontShooterHappy.set(shooterSpeedFastHappy);
        bottomShooterHappy.set(shooterSpeedFastHappy);

    }

    public void stopShooter() {
        frontShooterHappy.set(0);
        bottomShooterHappy.set(0);
    }

    public void setShooters(double speed){
        frontShooterHappy.set(ControlMode.Velocity, speed);
        bottomShooterHappy.set(ControlMode.Velocity, speed);
    }


}