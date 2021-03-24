/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


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
  }

  public void setMotorVelocity(double lspeed, double rspeed){
    backLeftMotor.set(ControlMode.PercentOutput, -lspeed);
    backRightMotor.set(ControlMode.PercentOutput, rspeed);
    System.out.println(backLeftMotor.getSelectedSensorVelocity() + ": " + backRightMotor.getSelectedSensorVelocity());
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
