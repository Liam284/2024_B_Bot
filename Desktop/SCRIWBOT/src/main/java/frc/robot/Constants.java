// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
  public static class IntakeConstants {
    public static final int INTAKE_SENSOR = 1;
    
    public static final int INTAKE_MOTOR = 10;
  
    public static final int WRIST_ID = 9;
    public static final int LEFT_ELEV_ID = 13;
    public static final int RIGHT_ElEV_ID = 14;
  
    public static final int MAG_ENCODER = 7;
  
    public static final double INTAKE_SPEED = 0.6;
    public static final double INTAKE_SHOOT_SPEED = 1;
    public static final double FEED_SHOOTER_SPEED = 1; 
    public static final double WRIST_SPEED = 0.7;
  
  public static final double LOW_WRIST_POS = 0.9;
    public static final double HIGH_WRIST_POS = 0.30;
    public static final double AMP_POS = 0.531; // In memoriam of 0.342 :(
  
    public static final double MAX_DISTANCE = 83;
    
    public static final double DESIRED_SPEED = 5100;
    
    public static final double DEFAULT_CURRENT = 30;
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
