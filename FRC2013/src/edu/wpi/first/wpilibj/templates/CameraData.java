/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;


/**
 *
 * @author First1
 */
public class CameraData {
    
    private ParticleAnalysisReport High;
    private ParticleAnalysisReport lowLeft;
    private ParticleAnalysisReport lowRight;
    private double highDistance;
    private double lowLeftDistance;
    private double lowRightDistance;
    
    public CameraData(ParticleAnalysisReport High, double highDistance, 
            ParticleAnalysisReport lowLeft, double lowLeftDistance,
            ParticleAnalysisReport lowRight, double lowRightDistance){
        this.High= High;
        this.lowLeft= lowLeft;
        this.lowRight= lowRight;
        this.highDistance= highDistance;
        this.lowLeftDistance= lowLeftDistance;
        this.lowRightDistance= lowRightDistance;
    }
    
}
