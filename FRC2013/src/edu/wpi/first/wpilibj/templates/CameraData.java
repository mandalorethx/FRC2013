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

    public ParticleAnalysisReport high;
    public ParticleAnalysisReport lowLeft;
    public ParticleAnalysisReport lowRight;
    public double highDistance;
    public double lowLeftDistance;
    public double lowRightDistance;

    public CameraData(ParticleAnalysisReport High, double highDistance,
            ParticleAnalysisReport lowLeft, double lowLeftDistance,
            ParticleAnalysisReport lowRight, double lowRightDistance) {
        this.high = High;
        this.lowLeft = lowLeft;
        this.lowRight = lowRight;
        this.highDistance = highDistance;
        this.lowLeftDistance = lowLeftDistance;
        this.lowRightDistance = lowRightDistance;
    }
}
