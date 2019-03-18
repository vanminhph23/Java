
package com.minhthuan.lib.maps;

public class MyLatLong {
    private final double latitude;
    private final double longitude;

    public MyLatLong(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    @Override
    public String toString() {
        return "latPoint: " + latitude + " longPoint: " + longitude;
    }
    
    
}
