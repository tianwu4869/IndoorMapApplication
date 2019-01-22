package com.group10.indoormap.entity;

/**
 * Created by songda on 3/28/18.
 */

public class Feature {
    private String FloorNumber;
    private String open_time;
    private String close_time;
    private String info;
    private String name;
    private int id;

    public Feature(String FloorNumber, String open_time, String close_time, String info, String name, int id) {
        this.FloorNumber = FloorNumber;
        this.open_time = open_time;
        this.close_time = close_time;
        this.info = info;
        this.name = name;
        this.id = id;
    }

    public String getFloorNumber() {
        return FloorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        FloorNumber = floorNumber;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getClose_time() {
        return close_time;
    }

    public void setClose_time(String close_time) {
        this.close_time = close_time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
