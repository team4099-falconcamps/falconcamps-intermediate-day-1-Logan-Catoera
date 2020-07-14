package com.team4099.falconcamps;

import com.team4099.falconcamps.commands.shooter.ShootPIDSubsystemCommand;
import com.team4099.falconcamps.commands.shooter.ShootSparkPIDCommand;
import com.team4099.falconcamps.commands.shooter.ShooterPIDSubsystemIdleCommand;
import com.team4099.falconcamps.commands.shooter.ShooterSparkPIDIdleCommand;
import com.team4099.falconcamps.subsystems.ShooterPIDSubsystem;
import com.team4099.falconcamps.subsystems.ShooterSparkPID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    private final ShooterSparkPID sparkSubsystem = new ShooterSparkPID();
    private final ShooterPIDSubsystem subsystem = new ShooterPIDSubsystem();
    XboxController driverController = new XboxController(0);

    public RobotContainer() {
        new Trigger(driverController::getAButton).whileActiveOnce(new ShootPIDSubsystemCommand(subsystem));
        subsystem.setDefaultCommand(new ShooterPIDSubsystemIdleCommand(subsystem));
    }
}
