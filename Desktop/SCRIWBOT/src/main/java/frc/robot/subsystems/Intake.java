// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.management.relation.Relation;

import static frc.robot.Constants.IntakeConstants.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkAnalogSensor.Mode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public final CANSparkMax intake;
  
  private DigitalInput intakeSensor;
  private DutyCycleEncoder throughBore;
  private RelativeEncoder encoder;
  private SparkPIDController controller;
  private XboxController joy;
  

  private double velocity;     
  

  public Intake() {
    intake = new CANSparkMax(INTAKE_MOTOR, CANSparkLowLevel.MotorType.kBrushless);
    //intake.setSmartCurrentLimit(60);
    intake.setIdleMode(IdleMode.kBrake);

    intakeSensor = new DigitalInput(5);
    joy = new XboxController(1);
    encoder = intake.getEncoder();

    controller = intake.getPIDController();
    controller.setP(0.01);
    controller.setFF(0.02);
    velocity = 0.50;
  }

  //command version
  public Command spinIntake(){
    return runEnd( () -> {

      if(intakeSensor.get()){
        intake.set(-0.7);
      }

      else {
        intake.set(0);
      }
    }, 
    
    () -> {intake.set(0);});
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
