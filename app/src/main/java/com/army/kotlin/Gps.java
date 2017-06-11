package com.army.kotlin;

/**
 * Created by Army on 2017/06/11.
 */

public class Gps {
    public static final String TABLE_NAME = "GPS";
    public static final String SYSTIME = "systime";
    public static final String LOCTIME = "loctime";
    public static final String LON = "lon";
    public static final String LAT = "lat";
    public static final String PROVIDER = "provider";
    public static final String ACCURACY = "accuracy";
    public static final String SPEED = "speed";
    public static final String BEARING = "bearing";
    public static final String _ID = "_id";
    /**
     * systime : 2016-03-31 11:27:20
     * loctime : 1459394840666
     * lon : 116.302013
     * lat : 39.982823
     * provider : gps
     * accuracy : 0
     * speed : 5.099999904632568
     * bearing : 90
     */
    private long _id;
    private String systime;
    private long loctime;
    private double lon;
    private double lat;
    private String provider;
    private double accuracy;
    private double speed;
    private double bearing;

    public Gps(long _id, String systime, long loctime, double lon, double lat, String provider, double accuracy, double speed, double bearing) {
        this._id = _id;
        this.systime = systime;
        this.loctime = loctime;
        this.lon = lon;
        this.lat = lat;
        this.provider = provider;
        this.accuracy = accuracy;
        this.speed = speed;
        this.bearing = bearing;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getSystime() {
        return systime;
    }

    public void setSystime(String systime) {
        this.systime = systime;
    }

    public long getLoctime() {
        return loctime;
    }

    public void setLoctime(long loctime) {
        this.loctime = loctime;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getBearing() {
        return bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    @Override
    public String toString() {
        return "Gps{" +
                "_id=" + _id +
                ", systime='" + systime + '\'' +
                ", loctime=" + loctime +
                ", lon=" + lon +
                ", lat=" + lat +
                ", provider='" + provider + '\'' +
                ", accuracy=" + accuracy +
                ", speed=" + speed +
                ", bearing=" + bearing +
                '}';
    }
}
