package com.team4099.falconcamps;

public class RobotContainer {
    private final IntakeSubsystem subsystem = new IntakeSubsystem();
    XboxController driverController = new XboxController(0);
   
    public RobotContainer() {
        new Trigger(driverController::getAButton).whileActive(new MyCommand(subsystem));

    }
}
