/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author first1
 */
public class Output {
    
    public static Victor leftFrontDriveMotor;
    public static Victor leftRearDriveMotor;
    public static Victor rightRearDriveMotor;
    public static Victor rightFrontDriveMotor;

    public static void initMotors(){
        rightFrontDriveMotor= new Victor(1);
        rightRearDriveMotor= new Victor(2);
        leftFrontDriveMotor= new Victor(3);
        leftRearDriveMotor= new Victor(4);
    }
    
    public static void setPower(double leftPower, double rightPower){
        rightFrontDriveMotor.set(rightPower);
        rightRearDriveMotor.set(rightPower);
        leftFrontDriveMotor.set(leftPower);
        leftRearDriveMotor.set(leftPower);
    }
}
