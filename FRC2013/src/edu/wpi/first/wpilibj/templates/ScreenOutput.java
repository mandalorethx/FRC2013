/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author First1
 */
public class ScreenOutput {

    private DriverStationLCD screen;
    private int lastLine;
    private static final int MAX_LINE_NUM = 6;
    private static final String CLEAR_LINE = "                              ";

    /**
     * Creates screen object
     */
    public ScreenOutput() {
        initDriverStationScreen();
        lastLine = 0;
    }

    /**
     * Initializes the driver station screen
     */
    public void initDriverStationScreen() {
        this.screen = DriverStationLCD.getInstance();

    }

    /**
     * Writes to the screen to the next available
     *
     * @param line is the line you want to write
     */
    public void screenWrite(String line) {
        screenWrite(line, this.lastLine);
        ++this.lastLine;
        if (this.lastLine >= MAX_LINE_NUM) {
            this.lastLine = 0;
        }

    }

    /**
     * Writes on a certain line
     *
     * @param line is the desired text
     * @param num is the chosen line to write on
     */
    public void screenWrite(String line, int num) {
        if (num < MAX_LINE_NUM) {
            this.clrLine(num);
        }

        switch (num) {
            case 0:
                this.screen.println(DriverStationLCD.Line.kUser1, 1, line);
                break;
            case 1:
                this.screen.println(DriverStationLCD.Line.kUser2, 1, line);
                break;
            case 2:
                this.screen.println(DriverStationLCD.Line.kUser3, 1, line);
                break;
            case 3:
                this.screen.println(DriverStationLCD.Line.kUser4, 1, line);
                break;
            case 4:
                this.screen.println(DriverStationLCD.Line.kUser5, 1, line);
                break;
            case 5:
                this.screen.println(DriverStationLCD.Line.kUser6, 1, line);
                break;
            default:
                this.screen.println(DriverStationLCD.Line.kUser1, 1,
                        "Got unknown line " + Integer.toString(num));
                break;
        }
        screen.updateLCD();

    }

    /**
     * Clears a certain line
     *
     * @param num is the line number
     */
    public void clrLine(int num) {
        switch (num) {
            case 0:
                this.screen.println(DriverStationLCD.Line.kUser1, 1, CLEAR_LINE);
                break;
            case 1:
                this.screen.println(DriverStationLCD.Line.kUser2, 1, CLEAR_LINE);
                break;
            case 2:
                this.screen.println(DriverStationLCD.Line.kUser3, 1, CLEAR_LINE);
                break;
            case 3:
                this.screen.println(DriverStationLCD.Line.kUser4, 1, CLEAR_LINE);
                break;
            case 4:
                this.screen.println(DriverStationLCD.Line.kUser5, 1, CLEAR_LINE);
                break;
            case 5:
                this.screen.println(DriverStationLCD.Line.kUser6, 1, CLEAR_LINE);
                break;
            default:
                this.screen.println(DriverStationLCD.Line.kUser1, 1,
                        "Got unknown line " + Integer.toString(num));
                break;
        }
        this.screen.updateLCD();

    }

    /**
     * Clears entire screen
     */
    public void clrScreen() {
        for (int i = 0; i < MAX_LINE_NUM; i++) {
            clrLine(i);
        }
    }
}
