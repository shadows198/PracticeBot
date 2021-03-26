/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class DriveSystem extends SubsystemBase {
  
  public DifferentialDrive drive;
  public VictorSPX frontRightMotor;
  public TalonSRX backRightMotor;
  public VictorSPX frontLeftMotor;
  public TalonSRX backLeftMotor;

  public SpeedControllerGroup rightMotors;
  public SpeedControllerGroup leftMotors;


  public DriveSystem() {
    frontRightMotor = new VictorSPX(1);
    backRightMotor = new TalonSRX(2);
    frontRightMotor.set(ControlMode.Follower, 2);

    frontLeftMotor = new VictorSPX(3);
    backLeftMotor = new TalonSRX(4);
    frontLeftMotor.set(ControlMode.Follower, 4);

    backLeftMotor.setInverted(true);
    backRightMotor.setInverted(false);
    //backRightMotor.setSensorPhase(true);
    //backLeftMotor.setSensorPhase(true);

  }
  public double getLeftEncoderPosition(){
    return backLeftMotor.getSelectedSensorPosition();
  }
  public double getRightEncoderPosition(){
    return backRightMotor.getSelectedSensorPosition();
  }

  public void setMotorVelocity(double lspeed, double rspeed){
    backLeftMotor.set(ControlMode.PercentOutput, lspeed);
    backRightMotor.set(ControlMode.PercentOutput, rspeed);
  }

  public void setMotorPosition(int distance){
    int encoderRotations = distance * 4096;
    backLeftMotor.set(ControlMode.Position, encoderRotations);
    backRightMotor.set(ControlMode.Position, encoderRotations);
  }

  public void stopMotors(){
    backLeftMotor.set(ControlMode.PercentOutput, 0);
    backRightMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
