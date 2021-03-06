package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;

public class ShooterPIDSubsystem extends PIDSubsystem implements Loggable {
    @Log
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    @Log
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    @Log
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();

    public ShooterPIDSubsystem() {
        super(new PIDController(1.7 / 300, 0.0, 5.5 * 14000));
    }

    @Override
    public void periodic() {}

    public double getMeasurement() {
        return getCurrentVelocity();
    }
    
    public void useOutput(double setPoint,double output) {
        shooterLeader.set(output);
    }
    
    public double getCurrentVelocity() {
        return shooterEncoder.getVelocity();
    }
}
