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
 