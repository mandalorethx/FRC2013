/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class FRC2013 extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public static final int k_AUTON_DELAY = 0;
    public static final int k_AUTON_AIMING = 1;
    public static final int k_AUTON_FIRE = 2;
    public static final int k_AUTON_MOVING = 3;
    public static final int k_AUTON_DONE = 4;
    public static int iAutonState;
    public static double dRightX;
    public static double dLeftX;
    public static double dRightY;
    public static double dLeftY;
    public static boolean dSlowRight;
    public static boolean dSlowLeft;
    public static boolean dAimRight;
    public static boolean dAimLeft;
    public static boolean dNextTarget;
    public static boolean dPrevTarget;
    public static boolean dCamLightOn;
    public static boolean dCamLightOff;
    
    public void robotInit() {

        Input.initJoystick();
        Input.initGyro();
        Output.initMotors();
        //Output.cameraLightOn();
        Input.initVision(true);
    }

    public static void autonInit(){
        iAutonState = k_AUTON_DELAY;
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
       Input.gatherInput();
       Think.robotThink();
       Output.sendOutput();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
