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
    public static Victor shooterMotor1;
    public static Victor shooterMotor2;
    public static Victor climbMotor1;
    public static Victor climbMotor2;
    
    public static DigitalModule digimod; 
    
    public static void initModule (){
        digimod = DigitalModule.getInstance(1);
        
     
    }
    public static void drop () {
        digimod.setRelayForward(1, true);
        digimod.setRelayForward(2, true);
    }
    public static void close () {
        digimod.setRelayForward(1, false);
        digimod.setRelayForward(2, false);
        
    }
    public static void climb (double power) {
        climbMotor1.set(power);
        climbMotor2.set(-1*power);
    }
    public static void ascend () {
        digimod.setRelayForward(3, true);
    }
    
    /**
     * Creates new motor objects
     */
    public static void initMotors(){
        rightDriveMotor= new Victor(1);
        leftDriveMotor= new Victor(2);
        shooterMotor1= new Victor(3);
        shooterMotor2 = new Victor (4);
        climbMotor1 = new Victor (5);
        climbMotor2 = new Victor (6);
        
    }
    
    /**
     * Sets motor's power based on input
     * @param leftPower - Power value for left motor
     * @param rightPower - Power value for right motor
     */
    public static void setPower(double leftPower, double rightPower, double shooterPower){
        rightDriveMotor.set(rightPower);
        leftDriveMotor.set(leftPower);
        shooterMotor1.set(shooterPower);
        shooterMotor2.set (shooterPower);
        
    }
    
    /**
     * Sets the motor's power based on Think.newJoystickLeft and
     * Think.newJoystickRight generated after a Think.robotThink()
     */
    public static void sendOutput(){
        setPower(Think.newJoystickLeft, Think.newJoystickRight, Think.dShooterPower);
        if (Think.bClimb1) {
            climb (1.0);
            
        }
        if (Think.bClimb2) {
            ascend ();
            
        }
    }
}

