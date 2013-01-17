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
    
    public static void start(){
        clock.start();
    }
    
    public static void stop(){
        clock.stop();
    }
    
    public static void reset(){
        clock.reset();
    }
    
    public double getSeconds(){
        return clock.get() / 1000000;
    }
    
}
