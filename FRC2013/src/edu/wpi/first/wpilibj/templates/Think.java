/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.camera.AxisCameraException;

/**
 *
 * @author first1
 */
public class Think {

    private static final int k_KICKER_INIT = 0;
    private static final int k_KICKER_MID = 1;
    private static final int k_KICKER_STOP = 2;
    private static final int k_LOAD_LINE = 0;
    private static final int k_LOAD_ADJUSTD = 1;
    private static final int k_LOAD_TURN = 2;
    private static final int k_LOAD_MOVE = 3;
    public static final double k_LOAD_ANGLE = 30;
    public static final double k_LOAD_DISTANCE = 135.29;
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
    public static double currentPositionNew;
    public static double dKickerMotorPower;
    public static double dKickerOnPower;
    public static int iKickerState;
    public static boolean bKickerDone;
    public static boolean bKickerLastState;
    public static int currentTarget = 0;
    public static double tolUpper = 8;
    public static double tolLower = -8;
    public static CameraData image;
    public static int iLoadState;
    public static boolean bDoLoad;
    
    public static void initKicker() {
        dKickerOnPower = 1;
        iKickerState = k_KICKER_INIT;
        bKickerDone = false;
    }
    
    public static double[] loadAdjust(double right, double left){
        double distance = image.lowLeftDistance;
        double retVal[] = new double[2];
        currentPositionNew = currentPosition;
        switch(iLoadState){
            case k_LOAD_LINE:
                currentPosition = lowLeftCMX;
                retVal = aimAdjust(right, left);
                if(retVal [0] >= -0.1 && retVal [0] <= 0.1 ){
                    iLoadState++;  
                }
                break;
            case k_LOAD_ADJUSTD:
                if(distance >= 0.9*k_LOAD_DISTANCE && distance <= 1.1*k_LOAD_DISTANCE){
                    retVal[0] = 0;
                    retVal[1] = 0;
                    iLoadState++;
                }
                else if(distance > 1.1*k_LOAD_DISTANCE){
                    retVal[0] = 0.9;
                    retVal[1] = 0.9;
                  
                }
                else if (distance < 0.9*k_LOAD_DISTANCE) {
                    retVal[0] = -0.9;
                    retVal [1] = -0.9;
                    
                }
                    
                break;
            case k_LOAD_TURN:
                double curAngle = Input.getGyro();
                if(curAngle >= 0.9*k_LOAD_ANGLE && curAngle <= 1.1*k_LOAD_ANGLE){
                    retVal[0] = 0;
                    retVal[1] = 0; 
                    iLoadState++;        
                }
                else if(curAngle > 1.1*k_LOAD_ANGLE){
                    retVal[0] = -0.9;
                    retVal[1] = 0.9;
                }
                else if(curAngle < 0.9* k_LOAD_ANGLE){
                    retVal[0] = 0.9;
                    retVal[1] = -0.9;
                }
                break;
            case k_LOAD_MOVE:
                retVal[0] = -0.9;
                retVal[1] = -0.9;
                        
                break;
            default:
                break;
        }
        currentPosition = currentPositionNew;
        return retVal;
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
        switch (currentTarget) {
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
        if (currError >= tolLower && currError <= tolUpper) {
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
        ScreenOutput out = new ScreenOutput();
        //out.screenWrite("RAW LEFT: " + rawLeft + " RAW RIGHT: " + rawRight);

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

        //out.screenWrite("LEFT: " + retVal[0] + " RIGHT: " + retVal[1]);

        return retVal;
    }

    /**
     * Returns the value of shootIn
     *
     * @param shootIn
     * @return is the input value sent to the motors
     */
    public static double getShooterPower() {
        double retVal = 0;

        if (bKickerDone = true) {
            retVal = 0;
        } else {
            retVal = dKickerOnPower;
            switch (iKickerState) {
                case k_KICKER_INIT:
                    if (Input.getKickerSwitchValue() == true) {
                        iKickerState++;
                    }
                    break;
                case k_KICKER_MID:
                    if (Input.getKickerSwitchValue() == false) {
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
        double leftMotorVal = Output.leftDriveMotor.get();
        double rightMotorVal = Output.rightDriveMotor.get();
        temp = processJoystick(Input.rightY, Input.leftY);
        newJoystickLeft = temp[0];
        newJoystickRight = temp[1];
        bShooterOn = Input.bTriggerDown;

        if(Input.getLoadButtonLeft()||Input.getLoadButtonRight()){
            bDoLoad = true;
        }
        else {
            bDoLoad = false;
        }
        
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

        if (bDoLoad == true){
            temp = loadAdjust(rightMotorVal, leftMotorVal);
            newJoystickLeft = temp[0];
            newJoystickRight = temp[1];
        }
        else{
            iLoadState = k_LOAD_LINE;
        }
        
        if (Input.bAim) {
            try {
                image = Input.getTarget(false, true, true);
                if(image == null){
                    Output.display.screenWrite("No Valid Target",0);
                }
                else{
                    if(image.high != null) {
                        highCMX = image.high.center_mass_x_normalized;
                        highCMY = image.high.center_mass_y_normalized;
                        Output.display.screenWrite("High Target Found",2);
                    } else {
                        Output.display.screenWrite("High Target not seen.", 2);
                    }
                    
                    if(image.lowLeft != null) {
                        lowLeftCMX = image.lowLeft.center_mass_x_normalized;
                        lowLeftCMY = image.lowLeft.center_mass_y_normalized;
                        Output.display.screenWrite("Left Target Found",3);
                    } else {
                        Output.display.screenWrite("Low Left Target not seen.", 3);
                    }
                    
                    if(image.lowRight != null) {
                        lowRightCMX = image.lowRight.center_mass_x_normalized;
                        lowRightCMY = image.lowRight.center_mass_y_normalized;
                        Output.display.screenWrite("Right Target Found",4);
                    } else {
                        Output.display.screenWrite("Low Right Target not seen.", 4);
                    }

                    //temp = aimAdjust(newJoystickLeft, newJoystickRight);
                    //newJoystickLeft = temp[0];
                    //newJoystickRight = temp[1];
                    image = null;
                }
            } catch (AxisCameraException ex) {
                ex.printStackTrace();
                image = null;
            }
        } else {
            lastError = 0;
            sumError = 0;
            currError = 0;
            image = null;
        }

        /**
         * Sets trigger value to true or false to tell kicker to start or not
         */
        if (bShooterOn == false) {
            dKickerMotorPower = 0;
            bKickerDone = false;

        } else {
            dKickerMotorPower = getShooterPower();
        }
    }
}
