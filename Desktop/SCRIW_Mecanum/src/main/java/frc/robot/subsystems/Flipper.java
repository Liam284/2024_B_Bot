// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.DriveConstants.*;
import frc.robot.Constants.DriveConstants;

public class Flipper extends SubsystemBase {

  private DutyCycleEncoder throughBore;
  private CANSparkMax flipperMotor;

  private RelativeEncoder flipperEncoder;
  private SparkPIDController flipperPID;

  /** Creates a new Flipper. */
  public Flipper() {
    flipperMotor = new CANSparkMax(DriveConstants.FLIPPER_ID, MotorType.kBrushless);
    flipperMotor.setInverted(false);
    flipperMotor.setIdleMode(IdleMode.kBrake);

    flipperEncoder = flipperMotor.getEncoder();
    flipperPID = flipperMotor.getPIDController();

    flipperPID.setP(0.0001);
    flipperPID.setFF(0.5);
    flipperPID.setSmartMotionAllowedClosedLoopError(100, 0);
    flipperPID.setOutputRange(0, 5000);
    throughBore = new DutyCycleEncoder(2);

    

  }

  public void flip(double speed){
      flipperMotor.set(speed);
    }

public DutyCycleEncoder getthroughBore(){
  return throughBore;
}


  public void stop(){
    flipperMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
