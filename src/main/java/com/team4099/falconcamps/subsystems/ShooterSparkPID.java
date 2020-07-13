package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSparkPID extends PIDSubsystem {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    private final CANPIDController pidController = shooterFollower.getPIDController();

    public ShooterSparkPID() {
        double ShooterP = 1.7 / 300;
        double ShooterI = 0.0;
        double ShooterD = 5.5 * 14000;
        super(new PIDController(ShooterP, ShooterI, ShooterD));
    }
    
    public double useMeasurement() {
        return getCurrentVelocity();
    }
    
    public void useOutput(double setPoint,double output) {
        shooterLeader.set(output);
    }
    
    @Override
    public void periodic() {}
}
