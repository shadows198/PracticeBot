/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * An example command that uses an example subsystem.
 */
public class ArcadeDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSystem m_Drive;
  public XboxController controller;
  public double speedDivision = 2;
  public double turnDivision = 6;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDrive(DriveSystem drive) {
    m_Drive = drive;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    controller = new XboxController(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = (-(controller.getTriggerAxis(Hand.kRight) - controller.getTriggerAxis(Hand.kLeft))/ speedDivision);
    double rotation = (controller.getX(Hand.kLeft) / turnDivision);
    double lspeed = (speed - rotation);
    double rspeed = (speed + rotation);

    if(controller.getAButtonPressed()){
        //speedDivision -= .1;
        turnDivision -= .1;
    }
    if(controller.getYButtonPressed()){ 
      //speedDivision += .1;
      turnDivision += .1;
    }
    //m_Drive.drive.arcadeDrive(speed, rotation);
    if(Math.abs(speed) < .1 && Math.abs(rotation) < .1){
      m_Drive.stopMotors();
    }
    else{
      m_Drive.setMotorVelocity(lspeed, rspeed);
      //m_Drive.drive.arcadeDrive(xSpeed, zRotation, squareInputs);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
