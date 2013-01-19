/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author First1
 */
public class EastridgeJoystick extends Joystick {
    
    private static final int NUM_BUTTONS = 11;
    
    public EastridgeJoystick (int port ){
        super (port);
        
    }
    
    public boolean isPressed (int button){
        return this.getRawButton(button);
        
              
    }
    /**
     * Gets all the button states 
     * @return boolean array where index = button number
     */
    public boolean[] getAllButtonStates () {
        boolean[] states = new boolean[NUM_BUTTONS+1];
        states[0] = isPressed(1);
        for (int i=1; i < NUM_BUTTONS+1; i++){
            states[i] = isPressed(i);
            
        }
        return states;
                
    }
     /**
      * Gets all the state of all the axis
      * @return an array of size 3 where 0=x, 1= y, 2= z
      */
    
    public double[] getAllAxis (){
        double[] states = new double [3];
        states[0] = this.getAxis(AxisType.kX);
        states[1] = this.getAxis(AxisType.kY);
        states[2] = this.getAxis(AxisType.kZ);
        
        return states; 
    }
}
