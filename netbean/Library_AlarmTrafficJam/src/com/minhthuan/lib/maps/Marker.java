/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.lib.maps;

/**
 *
 * @author sev_user
 */
public class Marker {

    public final static int GOOD = 0, LIGHT_JAM = 1, JAM = 2, HEAVY_JAM = 3;

    public enum Level {

        Good(GOOD), Light_Jam(LIGHT_JAM), Jam(JAM), Heavy_Jam(HEAVY_JAM);
        private int level;

        private Level(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

    }

    private int id;
    private int reporter;
    private Level level;
    private String timeReport;
    private String comment;
    private MyLatLong myLatLong;
    public final double EarthRadiusMeters = 6378137.0; // meters

    public Marker(int id, MyLatLong myLatLong, Level level, int reporter, String timeReport, String comment) {
        this.id = id;
        this.myLatLong = myLatLong;
        this.reporter = reporter;
        this.timeReport = timeReport;
        this.comment = comment;
        this.level = level;
    }

    public Marker(MyLatLong myLatLong, Level level, int reporter, String timeReport, String comment) {
        this(0, myLatLong, level, reporter, timeReport, comment);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public MyLatLong getLatLong() {
        return myLatLong;
    }


    public int getReporter() {
        return reporter;
    }

    public String getTimeReport() {
        return timeReport;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLatLong(MyLatLong myLatLong) {
        this.myLatLong = myLatLong;
    }


    public void setReporter(int reporter) {
        this.reporter = reporter;
    }

    public void setTimeReport(String timeReport) {
        this.timeReport = timeReport;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return myLatLong.toString() + " reporter: " + reporter + "timeReport: " + timeReport;
    }

    public double distanceFrom(MyLatLong end) {

        double dLat = (end.getLatitude() - myLatLong.getLatitude()) * Math.PI / 180;
        double dLon = (end.getLongitude() - myLatLong.getLongitude()) * Math.PI / 180;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(myLatLong.getLatitude() * Math.PI / 180)
                * Math.cos(end.getLatitude() * Math.PI / 180)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = EarthRadiusMeters * c;
        return d;
    }

}
