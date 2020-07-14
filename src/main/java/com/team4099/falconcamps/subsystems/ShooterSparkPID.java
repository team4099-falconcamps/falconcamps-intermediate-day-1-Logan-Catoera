package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSparkPID extends PIDSubsystem {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    private final CANPIDController pidController = shooterFollower.getPIDController();

    private double TargetVelocity = 0.0;

    public ShooterSparkPID() {
        //super(new PIDController(1.7 / 300, 0.0, 5.5 * 14000));
        pidController.setP(1.7 / 300);
        pidController.setI(0.0);
        pidController.setD(5,5 * 14000);
        shooterFollower.follow(shooterLeader);
    }
    public double getCurrentVelocity() {
        return shooterEncoder.getVelocity();
    }
    
    public double getMeasurement() {
        return getCurrentVelocity();
    }
    
    public void useOutput(double setPoint,double output) {
        shooterLeader.set(output);
    }
    public void setTargetVelocity(double setPoint) {
    TargetVelocity = setPoint;
    }
    
    @Override
    public void periodic() {
        
        pidController.setReference(TargetVelocity, ControlType.kVelocity);
    }
}
