package com.sstl.sharebike.model;

public class LngLatObject {
    private double lng;
    private double lat;
    private String bicycle_id;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getBicycle_id() {
        return bicycle_id;
    }

    public void setBicycle_id(String bicycle_id) {
        this.bicycle_id = bicycle_id;
    }
}
