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
    public static void initConfig(String Filename) {
        int lineNumber = 0;
        try {
            openFile(CONFIG_FILE);
            while (inFile.available() != 0) {
                
                switch (lineNumber) {
                    case 0: // Line 0 is runAuton
                        runAuton = inFile.readBoolean();
                        ++lineNumber;
                        break;
                    case 1: 
                        dUpperDistanceLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 2:
                        dLowerDistanceLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 3:
                        dLoadForwardPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 4:
                        dLoadReversePower = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 5:
                        dUpperAngleLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 6:
                        dLowerAngleLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 7:
                        dStopPower = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 8:
                        dUpperPowerStopLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 9:
                        dLowerPowerStopLimit = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 10:
                        dMaxMotorValLeft = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 11:
                        dMaxMotorValRight = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 12:
                        dSlowSpeedLeft = inFile.readDouble();
                        ++lineNumber;
                        break;
                    case 13:
                        dSlowSpeedRight = inFile.readDouble();
                        ++lineNumber;
                        break;
                        
                    // Add new cases for new variables
                    default:
                        System.out.println("unknown line number");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not read file " + Filename + " : " + e);
        } finally {
            closeFile();
        }
    }

    // Getters for variables in config file
    
    public static boolean isAuton() {
        return runAuton;
    }
    
    // Add more getters below
}
 