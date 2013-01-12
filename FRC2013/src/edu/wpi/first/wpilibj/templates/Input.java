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
   public static boolean bAim;
   public static boolean bSlowSpeedRight;
   public static boolean bSlowSpeedLeft;
   public static boolean bClimb1Left;
   public static boolean bClimb1Right;
   public static boolean bClimb2Left;
   public static boolean bClimb2Right;
   
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
   
   public static boolean getAim(){
       return leftDriverStick.getTrigger();
   }           
   
   public static boolean getSlowSpeedRight(){
       return rightDriverStick.getRawButton(2);
   } 
   
   public static boolean getSlowSpeedLeft(){
       return leftDriverStick.getRawButton(2);
   }
   
   public static boolean getClimb1Left(){
       return leftDriverStick.getRawButton(4);
   }
   
   public static boolean getClimb1Right(){
       return rightDriverStick.getRawButton(4);
   }
   
   public static boolean getClimb2Left(){
       return leftDriverStick.getRawButton(5);
   }
   
   public static boolean getClimb2Right(){
       return rightDriverStick.getRawButton(5);
   }
   
   public static void gatherInput(){
       leftX= getLeftX();
       leftY= getLeftY();
       rightX= getRightX();
       rightY= getRightY();
       bTriggerDown= getTriggerDown();
       bAim= getAim();
       bSlowSpeedRight= getSlowSpeedRight();
       bSlowSpeedLeft= getSlowSpeedLeft();
       bClimb1Left= getClimb1Left();
       bClimb1Right= getClimb1Right();
       bClimb2Left= getClimb2Left();
       bClimb2Right= getClimb2Right();
   }
}
