/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;

/**
 * Generates outputs for robot
 * @author first1
 */
public class Output {
    
    public static Victor leftFrontDriveMotor;
    public static Victor leftRearDriveMotor;
    public static Victor rightRearDriveMotor;
    public static Victor rightFrontDriveMotor;
    public static Victor shooterMotor1;
    public static Victor shooterMotor2;
    public static Victor climbMotor1;
    public static Victor climbMotor2;
    
    /**
     * Creates new motor objects
     */
    public static void initMotors(){
        rightFrontDriveMotor= new Victor(1);
        rightRearDriveMotor= new Victor(2);
        leftFrontDriveMotor= new Victor(3);
        leftRearDriveMotor= new Victor(4);
        shooterMotor1= new Victor(5);
        shooterMotor2 = new Victor (6);
        climbMotor1 = new Victor (7);
        climbMotor2 = new Victor (8);
        
    }
    
    /**
     * Sets motor's power based on input
     * @param leftPower - Power value for left motor
     * @param rightPower - Power value for right motor
     */
    public static void setPower(double leftPower, double rightPower, double shooterPower){
        rightFrontDriveMotor.set(rightPower);
        rightRearDriveMotor.set(rightPower);
        leftFrontDriveMotor.set(leftPower);
        leftRearDriveMotor.set(leftPower);
        shooterMotor1.set(shooterPower);
        shooterMotor2.set (shooterPower);
        
    }
    
    /**
     * Sets the motor's power based on Think.newJoystickLeft and
     * Think.newJoystickRight generated after a Think.robotThink()
     */
    public static void sendOutput(){
        setPower(Think.newJoystickLeft, Think.newJoystickRight, Think.dShooterPower);
    }
}

