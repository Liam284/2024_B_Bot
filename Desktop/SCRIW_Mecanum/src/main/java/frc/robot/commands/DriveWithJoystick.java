// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveSystem.*;
import frc.robot.subsystems.DriveSystem;

public class DriveWithJoystick extends Command {

  DriveSystem driveSystem;
  Joystick joy;
  
  private double x;
  private double y;
  private double z;
  /** Creates a new DriveWithJoystick. */
  public DriveWithJoystick(DriveSystem driveSystem, Joystick joy) {
    addRequirements(driveSystem);
    this.driveSystem = driveSystem;
    this.joy = joy;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    x = MathUtil.applyDeadband(joy.getX(), 0.15);
    y = MathUtil.applyDeadband(joy.getY(), 0.15);
    z = MathUtil.applyDeadband(joy.getZ(), 0.15);

    driveSystem.drive(-x, y, -z / 2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    driveSystem.drive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}
