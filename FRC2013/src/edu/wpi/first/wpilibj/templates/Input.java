/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author first1
 */
public class Input {
    
   public static Joystick rightDriverStick;
   public static Joystick leftDriverStick;
   public static boolean bTriggerDown;
   
   public static double leftX;
   public static double rightX;
   public static double leftY;
   public static double rightY;

   public static void initJoystick(){
       rightDriverStick= new Joystick(1);
       leftDriverStick= new Joystick(2);
   }
   
   public static double getRightX(){
       return rightDriverStick.getX();
   }
   
   public static double getLeftX(){
       return leftDriverStick.getX();
   }
   
   public static double getLeftY(){
       return leftDriverStick.getY();
   }
   
   public static double getRightY(){
       return rightDriverStick.getY();
   }
   
   public static boolean getTriggerDown(){
       return rightDriverStick.getTrigger();
   }
   
   public static void gatherInput(){
       leftX= getLeftX();
       leftY= getLeftY();
       rightX= getRightX();
       rightY= getRightY();
       bTriggerDown= getTriggerDown();
   }
}
