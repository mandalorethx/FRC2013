/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author first1
 */
public class Think {

    public static double newJoystickLeft;
    public static double newJoystickRight;
    public static boolean bShooterOn;
    public static double dShooterPower;
    public static boolean bClimb1;
    public static boolean bClimb2;
    public static boolean done;
    
    public static CameraData cData;
    public static double highCMX;
    public static double highCMY;
    public static double lowLeftCMX;
    public static double lowLeftCMY;
    public static double lowRightCMX;
    public static double lowRightCMY;
    public static double P;
    public static double I;
    public static double D;
    public static double outP;
    public static double inP;
    public static double wantPosition = 0;
    public static double currError;
    public static double lastError = 0;
    public static double sumError;
    public static double currentPosition;
    
    public static int currentTarget = 0;
    
    public static double tolUpper = 8;
    public static double tolLower = -8;
    

    /**
     * Lines up robot to shoot
     *
     * @param right
     * @param left
     * @param cd is the value from the sensor targeting the reflective tape
     * @return
     */
    public static double[] aimAdjust(double right, double left) {
        switch(currentTarget) {
            case 0: // High
                currentPosition = highCMX;
                break;
            case 1: // Low Left
                currentPosition = lowLeftCMX;
                break;
            case 2: // Low Right
                currentPosition = lowRightCMX;
                break;
            default:
                Output.display.screenWrite("Current Target: ERROR!", 1);
                currentPosition = highCMX;
                break;
        }
        inP = right;
        outP = inP;
        currError = wantPosition - currentPosition;
        if(currError >= tolLower && currError <= tolUpper) {
            outP = 0;
        } else {
            sumError += currError;
            outP += P * currError + I * sumError + D * (lastError - currError);
            lastError = currError;
        }
        
        return new double[]{outP, (outP * -1)};
    }

    /*
     * Converts the joystick values to usable values.
     * @param rawRight the value of the right joystick.
     * @param rawLeft the value of the left joystick.
     * @returns usable values as an array. The left value is at index 0
     *      The right is at index 1
     */
    public static double[] processJoystick(double rawRight, double rawLeft) {
        double[] retVal = new double[2];

        if (rawLeft > 0) {
            retVal[0] = rawLeft * rawLeft;
        } else {
            retVal[0] = (-1) * (rawLeft * rawLeft);
        }
        if (rawRight > 0) {
            retVal[1] = rawRight * rawRight;
        } else {
            retVal[1] = (-1) * (rawRight * rawRight);
        }

        retVal[0] *= (-1);
        retVal[1] *= (-1);

        retVal[0] *= (0.9);
        retVal[1] *= (0.9);

        return retVal;
    }

    /**
     * Returns the value of shootIn
     *
     * @param shootIn
     * @return is the input value sent to the motors
     */
    public static double shooterInOut(double shootIn) {
        double retVal;
        retVal = shootIn;
        return retVal;
    }

    /**
     * Returns the value sent from climbIn
     *
     * @param climbIn
     * @return is the climbIn value being sent to the output
     */
    public static double climbInOut(double climbIn) {
        double retVal;
        retVal = climbIn;
        return retVal;
    }

    /**
     * Sets values for the robot's functions - Responds to the inputs
     */
    public static void robotThink() {
        double[] temp = new double[2];
        temp = processJoystick(Input.rightY, Input.leftY);
        newJoystickLeft = temp[0];
        newJoystickRight = temp[1];
        bShooterOn = Input.bTriggerDown;

        /**
         * Sets the value for the robot's slow speed
         */
        if (Input.bSlowSpeedRight || Input.bSlowSpeedLeft) {
            newJoystickLeft *= .75;
            newJoystickRight *= .75;
        }

        /**
         * Returns the boolean value for the robot to start climbing
         */
        if (Input.bClimb1Left || Input.bClimb1Right) {
            bClimb1 = true;
        }

        /**
         * Returns the boolean value for the robot's second climb cycle
         */
        if (Input.bClimb2Left || Input.bClimb2Right) {
            bClimb2 = true;
        }

        /**
         * Assigns new values to the joystick inputs
         */
        if (Input.bAim) {
            //temp = aimAdjust(newJoystickLeft, newJoystickRight, Input.cd);
            newJoystickLeft = temp[0];
            newJoystickRight = temp[1];

        }

        /**
         * Sets power values for boolean inputs to shooter
         */
        if (bShooterOn == false) {
            dShooterPower = 0;

        } else {
            dShooterPower = 1.0;
        }
        cData = Input.image;
        if (cData != null) {
            double[] adjusted = aimAdjust(newJoystickRight, newJoystickLeft);
            newJoystickRight = adjusted[0];
            newJoystickLeft = adjusted[1];
        }

        highCMX = cData.high.center_mass_x_normalized;
        highCMY = cData.high.center_mass_y_normalized;
        lowLeftCMX = cData.lowLeft.center_mass_x_normalized;
        lowLeftCMY = cData.lowLeft.center_mass_y_normalized;
        lowRightCMX = cData.lowRight.center_mass_x_normalized;
        lowRightCMY = cData.lowRight.center_mass_y_normalized;
        
        
        
    }
    }