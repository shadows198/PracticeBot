package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

public class PositionPID extends CommandBase{
  private final DriveSystem m_Drive;

  public PositionPID(DriveSystem drive){
    m_Drive = drive;
    addRequirements(m_Drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drive.setMotorPosition(10);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_Drive.getLeftEncoderPosition() > (10*4096)){
        return true;
    }
    else return false;
  }
}