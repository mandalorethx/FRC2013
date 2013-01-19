/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author First1
 */
public class ScreenOutput {
    
    private DriverStationLCD screen;
    private int lastLine;

    private static final int MAX_LINE_NUM= 6;
    
    public ScreenOutput(){
        initDriverStationScreen();
        lastLine= 0;
    }
    
    public void initDriverStationScreen(){
        this.screen= DriverStationLCD.getInstance();
        
    }
    public void screenWrite(String line){
        
    }        
}

