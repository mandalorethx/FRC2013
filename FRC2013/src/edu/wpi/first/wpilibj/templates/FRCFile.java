/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import com.sun.squawk.microedition.io.FileConnection;
import java.io.DataInputStream;
import javax.microedition.io.Connector;

/**
 *
 * @author First1
 */
public class FRCFile {

    private static DataInputStream inFile;
    private static FileConnection fc;
    
    // Config file
    private static final String CONFIG_FILE = "config.properties";
    
    // Define variables in config file with default values
    public static boolean runAuton = true;
    public static boolean bEnableCamera = true;
    public static double dUpperDistanceLimit = 1.1;
    public static double dLowerDistanceLimit = 0.9;
    public static double dLoadForwardPower = 0.9;
    public static double dLoadReversePower = -0.9;
    public static double dUpperAngleLimit = 1.1;
    public static double dLowerAngleLimit = 0.9;
    public static double dStopPower = 0;
    public static double dUpperPowerStopLimit = 0.1;
    public static double dLowerPowerStopLimit = -0.1;
    public static double dMaxMotorValLeft = 0.9;
    public static double dMaxMotorValRight = 0.9;
    public static double dSlowSpeedLeft = .75;
    public static double dSlowSpeedRight = .75;
    public static double dClimbPower = 1.0;
    public static int iRightDriveMotorSlot = 6;
    public static int iLeftDriveMotorSlot = 5;
    public static int iShooterMotorSlot = 3;
    public static int iClimbMotor1Slot = 2;
    public static int iClimbMotor2Slot = 1;
    public static int iKickerMotorSlot = 2;
    public static int iHookerMotorSlot = 7;
    public static int iDropSlot1 = 1;
    public static int iDropSlot2 = 2;
    public static int iDropSlot3 = 3;
    public static int iDriverPortRight = 1;
    public static int iDriverPortLeft = 2;
    public static int iDriverPortCo = 3;
    public static double dAutonPowerLimitUpper = 0.1;
    public static double dAutonPowerLimitLower = -0.1;
    public static double dHookMotorPower = 0;
    public static double dFwdHookMotorPower = 1.0;
    public static double dReverseHookMotorPower = -1.0;
    public static double dClimbMotorPower = 0;
    public static double dMaxClimbMotorPower = 1.0;
    public static double dLeftAdjust = 0;
    public static double dRightAdjust = 0;
    public static double dAdjustPower = .01;
    public static double dAngleVary = 5.0;
    public static boolean bGyroEnable = true;
    public static boolean bGoStraight = false;
    /**
     * Opens file
     *
     * @param Filename Name of the file to open
     */
    private static void openFile(String Filename) {
        try {
            fc = (FileConnection) Connector.open("file:///" + Filename,
                    Connector.READ);
            //fc.create();
            inFile = fc.openDataInputStream();
        } catch (Exception e) {
            System.out.println("Could not open file" + Filename);
        }
    }

    /**
     * Closes the file
     */
    private static void closeFile() {
        try {
            if (inFile != null) {
                inFile.close();
            }
            if (fc != null) {
                fc.close();
            }
        } catch (Exception e) {
            System.out.println("Could not close file: " + e);
        }
    }

    /**
     * Reads the file and runs autonomous mode
     *
     * @param Filename is the file to be read
     */
    public static void initConfig() {
        int lineNumber = 0;
        try {
            openFile(CONFIG_FILE);
            while (inFile.available() != 0) {
                
                switch (lineNumber) {
                    
                    /*
                     * First line
                     * Variable that decides whether to start autonomous
                     * True = Start
                     * False = Do not do anything
                     * Type: Boolean
                     */
                    case 0: // Line 0 is runAuton
                        runAuton = inFile.readBoolean();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 2
                     * Sets the value for the maximum distance tolerance from loading station
                     * 1.1 = max tolerance
                     * Type: Double
                     */    
                    case 1: 
                        dUpperDistanceLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 3
                     * Sets the value for the minimum distance tolerance from the loading station
                     * 0.9 = min tolerance
                     * Type: Double
                     */
                    case 2:
                        dLowerDistanceLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 4
                     * Sets adjusted values for moving forward to load
                     * 0.9 = Forward power
                     * Type: Double
                     */    
                    case 3:
                        dLoadForwardPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 5
                     * Sets adjusted values for moving backward to load
                     * -0.9 = Backward power
                     * Type: Double
                     */    
                    case 4:
                        dLoadReversePower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 6
                     * Sets maximum tolerance for the angle at which the robot turns to load
                     * 1.1 = Maximum tolerance
                     * Type: Double
                     */    
                    case 5:
                        dUpperAngleLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 7
                     * Sets minimum tolerance for the angle at which the robot turns to load
                     * 0.9 = Minimum tolerance
                     * Type: Double
                     */    
                    case 6:
                        dLowerAngleLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 8
                     * Sets motor power to stop robot when it's ready to load
                     * 0.0 = Motor power
                     * Type: Double
                     */    
                    case 7:
                        dStopPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 9
                     * Checks that motor power is below a maximum, ensures that it won't move
                     * 0.1 = Maximum motor tolerance for stop
                     * Type: Double
                     */    
                    case 8:
                        dUpperPowerStopLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 10
                     * Checks that motor power is above a minimum, ensures that it won't move
                     * -0.1 = Minimum motor tolerance for stop
                     * Type: Double
                     */    
                    case 9:
                        dLowerPowerStopLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 11
                     * Sets maximum power for the left drive motor
                     * 0.9 = max motor power
                     * Type: Double
                     */    
                    case 10:
                        dMaxMotorValLeft = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 12
                     * Sets maximum power for the right drive motor
                     * 0.9 = max motor power
                     * Type: Double
                     */    
                    case 11:
                        dMaxMotorValRight = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 13
                     * Sets slow speed for left motor when button is pressed
                     * 0.75 = Slow power setting
                     * Type: Double
                     */    
                    case 12:
                        dSlowSpeedLeft = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 14
                     * Sets slow speed for right motor when button is pressed
                     * 0.75 = Slow power setting
                     * Type: Double
                     */    
                    case 13:
                        dSlowSpeedRight = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 15
                     * Assigns the slot for the right drive motor
                     * 3 = Slot for right drive motor
                     * Type: Integer
                     */    
                    case 14:
                        iRightDriveMotorSlot = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 16
                     * Assigns the slot for the left drive motor
                     * 4 = Slot for the left drive motor
                     * Type: Integer
                     */    
                    case 15:
                        iLeftDriveMotorSlot = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 17
                     * Assigns the slot for the shooter motor
                     * 5 = Slot for the shooter motor
                     * Type: Integer
                     */
                    case 16:
                        iShooterMotorSlot = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 18
                     * Assigns the slot for the first climb motor
                     * 2 = Slot for climb motor 1
                     * Type: Integer
                     */    
                    case 17: 
                        iClimbMotor1Slot = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 19
                     * Assigns the slot for the second climb motor
                     * 1 = Slot for climb motor 2
                     * Type: Integer
                     */    
                    case 18:
                        iClimbMotor2Slot = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 20
                     * Assigns the slot for the kicker motor
                     * 6 = Slot for the kicker motor
                     * Type: Integer
                     */    
                    case 19:
                        iKickerMotorSlot = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 21
                     * Assigns the slot for the first drop slot 
                     * 1 = Slot for drop slot 1
                     * Type: Integer
                     */    
                    case 20:
                        iDropSlot1 = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 22
                     * Assigns the slot for the second drop slot
                     * 2 = Slot for drop slot 2
                     * Type: Integer
                     */
                    case 21:
                        iDropSlot2 = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 23
                     * Assigns the slot for the third drop slot
                     * 3 = Slot for drop slot 3
                     * Type: Integer
                     */
                    case 22:
                        iDropSlot3 = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 24
                     * Sets the power for the climbing motor
                     * Default value = 1.0
                     * Type: Double
                     */
                    case 23:
                        dClimbPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 25
                     * Assigns the right joystick for the driver
                     * Default = 1
                     * Type: Integer
                     */
                    case 24:
                        iDriverPortRight = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 26
                     * Assigns the left joystick for the driver
                     * Default = 2
                     * Type: Integer
                     */
                    case 25:
                        iDriverPortLeft = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 27
                     * Assigns the co-driver joystick for the driver
                     * Default = 3
                     * Type: Integer
                     */
                    case 26:
                        iDriverPortCo = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 28
                     * Sets the maximum tolerance of power for the driving motors
                     * 0.1 = maximum tolerance
                     * Type: Double
                     */
                    case 27:
                        dAutonPowerLimitUpper = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 29
                     * Sets the minimum tolerance of power for the driving motors
                     * -0.1 = minimum tolerance
                     * Type: Double
                     */
                    case 28:
                        dAutonPowerLimitLower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 30
                     * Assigns the slot for the hook motor
                     * Default value = 7
                     * Type: Integer
                     */
                    case 29:
                        iHookerMotorSlot = inFile.readInt();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 31
                     * Sets the power for the hook motor
                     * Default value = 0
                     * Type = Double
                     */
                    case 30:
                        dHookMotorPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 32
                     * Sets the power for the forward hook motor
                     * Default value = 1.0
                     * Type = Double
                     */
                    case 31:
                        dFwdHookMotorPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 33
                     * Sets the power for the reverse hook motor
                     * Default value = -1.0
                     * Type = Double
                     */
                    case 32:
                        dReverseHookMotorPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 34
                     * Values are assigned to this in the code...
                     * Not sure what it does...
                     */
                    case 33:
                        dClimbMotorPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 35
                     * Sets the maximum power of the climb motor
                     * Default value = 1.0
                     * Type = Double
                     */
                    case 34:
                        dMaxClimbMotorPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 36
                     * Assigns the ammount to adjust the left motor according to
                     * gyro inputs
                     * Default value = 0
                     * Type = Double
                     */
                    case 35:
                        dLeftAdjust = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 37
                     * Assigns the ammount to adjust the right motor according to
                     * gyro inputs
                     * Default value = 0
                     * Type = Double
                     */
                    case 36:
                        dRightAdjust = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 38
                     * Does not appear to be currently used anywhere...
                     */
                    case 37: 
                        dAdjustPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 39
                     * Sets the allowable angle varriance when moving straight
                     * Default value = 5.0
                     * Type = Double
                     */
                    case 38: 
                        dAngleVary = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 40
                     * Sets if the camera should be enabled or not
                     * Default value = true
                     * Type = Boolean
                     */
                    case 39:
                        bEnableCamera = inFile.readBoolean();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 41
                     * Sets if the robot should be going straight
                     * Default value = false
                     * Type = Boolean
                     */
                    case 40:
                        bGoStraight = inFile.readBoolean();
                        ++lineNumber;
                        break;
                        
                    /*
                     * Line 42
                     * Sets if the gyro should be enabled
                     * Default value = true
                     * Type = Boolean
                     */
                    case 41:
                        bGyroEnable = inFile.readBoolean();
                        ++lineNumber;
                        break;
                    // Add new cases for new variables
                    default:
                        System.out.println("unknown line number " + lineNumber);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not read file " + CONFIG_FILE + " : " + e);
        } finally {
            closeFile();
        }
    }

    // Getters for variables in config file
    
    public static boolean isAuton() {
        return runAuton;
    }
    
    // Add more getters below
    public static void main(String[] args) {
       initConfig();  
    } 
}
 
