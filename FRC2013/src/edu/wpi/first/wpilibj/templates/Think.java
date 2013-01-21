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

    private static final int k_KICKER_INIT = 0;
    private static final int k_KICKER_MID = 1;
    private static final int k_KICKER_STOP = 2;
    
    
    public static double newJoystickLeft;
    public static double newJoystickRight;
    public static boolean bShooterOn;
    public static double dShooterPower;
    public static boolean bClimb1;
    public static boolean bClimb2;
    public static CameraData cData;
    public static double dKickerMotorPower;
    public static double dKickerOnPower;
    public static int iKickerState;
    public static boolean bKickerDone;
    public static boolean bKickerLastState;
    
    public static void initKicker(){
        dKickerOnPower = 1;
        iKickerState = k_KICKER_INIT;
        bKickerDone = false;
    }
    
    /**
     * Lines up robot to shoot
     *
     * @param right
     * @param left
     * @param cd is the value from the sensor targeting the reflective tape
     * @return
     */
    public static double[] aimAdjust(double right, double left) {
        return new double[]{left, right};
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
    public static double getShooterPower() {
        double retVal=0;
        
        if (bKickerDone=true){
            retVal=0;
        }
        else{
            retVal= dKickerOnPower;
            switch(iKickerState){
                case k_KICKER_INIT:
                    if(Input.getKickerSwitchValue() == true){
                        iKickerState++;
                    }
                    break;
                case k_KICKER_MID:
                    if(Input.getKickerSwitchValue() == false){
                        iKickerState++;
                    }
                    break;
                case k_KICKER_STOP:
                    bKickerDone = true;
                    iKickerState = k_KICKER_INIT;
                    break;
            }
                    
        }
            
       
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
         * Sets trigger value to true or false to tell kicker to start or not
         */
        if (bShooterOn == false) {
            dKickerMotorPower = 0;
            bKickerDone = false;

        } // Test Commit
        else {
            dKickerMotorPower = getShooterPower();
        }
        cData = Input.image;
        if (cData != null) {
            double[] adjusted = aimAdjust(newJoystickRight, newJoystickLeft);
            newJoystickRight = adjusted[0];
            newJoystickLeft = adjusted[1];
        }

    }
}
