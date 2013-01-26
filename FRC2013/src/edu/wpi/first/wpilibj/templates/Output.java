/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.Victor;

/**
 * Generates outputs for robot
 * @author first1
 */
public class Output {
    
    public static Victor leftDriveMotor;
    public static Victor rightDriveMotor;
    public static Victor shooterMotor;
    public static Victor climbMotor1;
    public static Victor climbMotor2;
    public static Victor kickerMotor;
    
    public static DigitalModule digimod;
    
    public static ScreenOutput display;
    
    /**
     * Initializes the screen display
     */
    public static void initScreen(){
        display= new ScreenOutput();
    }
    
   /**
    * Turns Camera Light On
    */
   public static void cameraLightOn (){
       digimod.setRelayForward(3, true);
       
   }
   
   /**
    * Turns Camera Light Off
    */
   public static void cameraLightOff (){
       digimod.setRelayForward(3, false);
       
   }
   
   /**
    * Initializes the digital module
    */
   public static void initModule (){
        digimod = DigitalModule.getInstance(1);
       
    }
   
   /**
    * Opening up to drop discs in goal
    */
    public static void drop () {
        digimod.setRelayForward(1, true);
        digimod.setRelayForward(2, true);
    }
    
    /**
     * Closes claw
     */
    public static void close () {
        digimod.setRelayForward(1, false);
        digimod.setRelayForward(2, false);
        
    }
    /**
     * Reaches pyramid rung
     * @param power sets power value for motors
     */
    public static void climb (double power) {
        climbMotor1.set(power);
        climbMotor2.set(-1*power);
    }
    
    /**
     * Lifts robot above rung
     */
    public static void ascend () {
        digimod.setRelayForward(3, true);
    }
    
    /**
     * Creates new motor objects
     */
    public static void initMotors(){
        rightDriveMotor= new Victor(1);
        leftDriveMotor= new Victor(2);
        shooterMotor= new Victor(3);
        climbMotor1 = new Victor (4);
        climbMotor2 = new Victor (5);
        kickerMotor = new Victor (6);
    }
    
    /**
     * Sets motor's power based on input
     * @param leftPower - Power value for left motor
     * @param rightPower - Power value for right motor
     * @param shooterPower  - Power value for the shooter motor
     */
    public static void setPower(double leftPower, double rightPower, double shooterPower,
                                                                        double kickerPower){
        rightDriveMotor.set(rightPower);
        leftDriveMotor.set((-1) * leftPower);
        shooterMotor.set(shooterPower);
        kickerMotor.set(kickerPower);
        
    }
    
    /**
     * Sets the motor's power based on Think.newJoystickLeft and
     * Think.newJoystickRight generated after a Think.robotThink()
     */
    public static void sendOutput(){
        setPower(
                Think.newJoystickLeft,
                Think.newJoystickRight,
                Think.dShooterPower,
                Think.dKickerMotorPower);
        
        if (Think.bClimb1) {
            climb (1.0);            
        }
        if (Think.bClimb2) {
            ascend ();
        }
        if (Think.currentTarget== 0)
            display.screenWrite("Current Target: High");
        
        else if (Think.currentTarget== 1)
            display.screenWrite("Current Target: Low Left");
        
        else if (Think.currentTarget== 2)
            display.screenWrite("Current Target: Low Right");
 
    }
}

