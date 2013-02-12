package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

/**
 *
 * @author First1
 */
public class CameraData {

    public double dHighCMX, dHighCMY, dHighDistance;
    public double dLowLeftCMX, dLowLeftCMY, dLowLeftDistance;
    public double dLowRightCMX, dLowRightCMY, dLowRightDistance;

    public CameraData(ParticleAnalysisReport High, double highDistance,
            ParticleAnalysisReport lowLeft, double lowLeftDistance,
            ParticleAnalysisReport lowRight, double lowRightDistance) {

        if (High != null) {
            this.dHighCMX = High.center_mass_x_normalized;
            this.dHighCMY = High.center_mass_y_normalized;
            this.dHighDistance = highDistance;
        } else {
            this.dHighCMX = 0.0d;
            this.dHighCMY = 0.0d;
            this.dHighDistance = 0.0d;
        }

        if (lowLeft != null) {
            this.dLowLeftCMX = lowLeft.center_mass_x_normalized;
            this.dLowLeftCMY = lowLeft.center_mass_y_normalized;
            this.dLowLeftDistance = lowLeftDistance;
        } else {
            this.dLowLeftCMX = 0.0d;
            this.dLowLeftCMY = 0.0d;
            this.dLowLeftDistance = 0.0d;
        }

        if (lowRight != null) {
            this.dLowRightCMX = lowRight.center_mass_x_normalized;
            this.dLowRightCMY = lowRight.center_mass_y_normalized;
            this.dLowRightDistance = lowRightDistance;
        } else {
            this.dLowRightCMX = 0.0d;
            this.dLowRightCMY = 0.0d;
            this.dLowRightDistance = 0.0d;
        }
    }
    
    /*public static void setData(ParticleAnalysisReport High, double highDistance,
            ParticleAnalysisReport lowLeft, double lowLeftDistance,
            ParticleAnalysisReport lowRight, double lowRightDistance) {
        if (High != null) {
            dHighCMX = High.center_mass_x_normalized;
            dHighCMY = High.center_mass_y_normalized;
            dHighDistance = highDistance;
        } else {
            dHighCMX = 0.0d;
            dHighCMY = 0.0d;
            dHighDistance = 0.0d;
        }

        if (lowLeft != null) {
            dLowLeftCMX = lowLeft.center_mass_x_normalized;
            dLowLeftCMY = lowLeft.center_mass_y_normalized;
            dLowLeftDistance = lowLeftDistance;
        } else {
            dLowLeftCMX = 0.0d;
            dLowLeftCMY = 0.0d;
            dLowLeftDistance = 0.0d;
        }

        if (lowRight != null) {
            dLowRightCMX = lowRight.center_mass_x_normalized;
            dLowRightCMY = lowRight.center_mass_y_normalized;
            dLowRightDistance = lowRightDistance;
        } else {
            dLowRightCMX = 0.0d;
            dLowRightCMY = 0.0d;
            dLowRightDistance = 0.0d;
        }
    }*/
}