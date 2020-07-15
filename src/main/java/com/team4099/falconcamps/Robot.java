package com.team4099.falconcamps;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import io.github.oblarg.oblog.Logger;

public class Robot extends TimedRobot {
    private final RobotContainer robotContainer = new RobotContainer();

    @Override public void robotInit() {
        Logger.configureLoggingAndConfig(this, false);
    }

    @Override public void autonomousInit() {}

    @Override public void teleopInit() {}

    @Override public void disabledInit() {}

    @Override public void robotPeriodic() {
        CommandScheduler.getInstance().run();
        Logger.updateEntries();
    }

    @Override public void autonomousPeriodic() {}

    @Override public void disabledPeriodic() {}
}
