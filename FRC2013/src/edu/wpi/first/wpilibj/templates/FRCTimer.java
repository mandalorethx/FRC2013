/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author First1
 */
public class FRCTimer {
    
    public static Timer clock;
    public static void initTimer(){
        clock= new Timer();
    }
    
    /**
     * Start the timer
     */
    public static void start(){
        clock.start();
    }
    
    
    /**
     * Stop the timer
     */
    public static void stop(){
        clock.stop();
    }
    
    /**
     * Resets the timer
     */
    public static void reset(){
        clock.reset();
    }
    
    /**
     * Gets the current time on the timer in seconds
     * @return time in seconds
     */
    public double getSeconds(){
        return clock.get() / 1000000;
    }
    
}
