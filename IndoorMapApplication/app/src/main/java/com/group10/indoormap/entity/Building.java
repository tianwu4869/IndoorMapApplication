package com.group10.indoormap.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songda on 3/28/18.
 */

public class Building {
    private String name;
    private String info;
    private String opening;
    private String closing;
    private List<String> floors;
    private List<Feature> printerArr;
    private List<Feature> venderArr;
    private List<Feature> classroomArr;
    private List<Feature> coffeArr;
    private List<Feature> compLabArr;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getClosing() {
        return closing;
    }

    public void setClosing(String closing) {
        this.closing = closing;
    }

    public List<String> getFloors() {
        return floors;
    }

    public void setFloors(List<String> floors) {
        this.floors = floors;
    }

    public List<Feature> getPrinterArr() {
        return printerArr;
    }

    public void setPrinterArr(List<Feature> printerArr) {
        this.printerArr = printerArr;
    }

    public List<Feature> getVenderArr() {
        return venderArr;
    }

    public void setVenderArr(List<Feature> venderArr) {
        this.venderArr = venderArr;
    }

    public List<Feature> getClassroomArr() {
        return classroomArr;
    }

    public void setClassroomArr(List<Feature> classroomArr) {
        this.classroomArr = classroomArr;
    }

    public List<Feature> getCoffeArr() {
        return coffeArr;
    }

    public void setCoffeArr(List<Feature> coffeArr) {
        this.coffeArr = coffeArr;
    }

    public List<Feature> getCompLabArr() {
        return compLabArr;
    }

    public void setCompLabArr(List<Feature> compLabArr) {
        this.compLabArr = compLabArr;
    }

    public Building(String name, String info, String opening, String closing, List<String> floors, List<Feature> printerArr, List<Feature> venderArr, List<Feature> classroomArr, List<Feature> coffeArr, List<Feature> compLabArr, int image) {
        this.name = name;
        this.info = info;
        this.opening = opening;
        this.closing = closing;
        this.floors = floors;
        this.printerArr = printerArr;
        this.venderArr = venderArr;
        this.classroomArr = classroomArr;
        this.coffeArr = coffeArr;
        this.compLabArr = compLabArr;
        this.image = image;
    }
}
