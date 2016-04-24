/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.lib.user;

/**
 *
 * @author vanmi
 */
public class SettingUser {

    private int ID = 0;
    private double radius = 1000;
    private int timeReport = 60 * 30;

    public SettingUser(int ID, double radius, int timeReport) {
        this.ID = ID;
        this.radius = radius;
        this.timeReport = timeReport;
    }

    public SettingUser(double radius, int timeReport) {
        this(0, radius, timeReport);
    }

    public int getID() {
        return ID;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getTimeReport() {
        return timeReport;
    }

    public void setTimeReport(int TimeReport) {
        this.timeReport = TimeReport;
    }
    

    @Override
    public String toString() {
        return "ID: " + ID + " Radius: " + radius + " TimeReport: " + timeReport;
    }

}
