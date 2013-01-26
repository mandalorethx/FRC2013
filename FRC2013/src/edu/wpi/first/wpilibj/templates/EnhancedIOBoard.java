/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author first1
 */
public class EnhancedIOBoard {
    
    public static DriverStationEnhancedIO EIO;
    public static void initDriverStationEnhancedIO(){
       EIO = DriverStation.getInstance().getEnhancedIO();   
    }
    
    public static void setOutputState(int channel, boolean value){
        try {
            EIO.setDigitalOutput(channel, value);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }      
    }
    
    public static boolean getOutputState(int channel){
        try {
            return EIO.getFixedDigitalOutput(channel);
        } catch (EnhancedIOException ex) {
            ex.printStackTrace();
        }
        finally {
            return false;
        }
    }
}
