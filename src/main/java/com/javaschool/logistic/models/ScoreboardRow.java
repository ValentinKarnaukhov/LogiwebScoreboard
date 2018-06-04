package com.javaschool.logistic.models;

import java.io.Serializable;
import java.util.List;

public class ScoreboardRow implements Serializable {

    private int number;
    private String cityFrom;
    private String cityTo;
    private String truck;
    private int cargoes;
    private List<String> drivers;
    private boolean status;

    public ScoreboardRow() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCituTo() {
        return cityTo;
    }

    public void setCituTo(String cituTo) {
        this.cityTo = cituTo;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public int getCargoes() {
        return cargoes;
    }

    public void setCargoes(int cargoes) {
        this.cargoes = cargoes;
    }

    public List<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<String> drivers) {
        this.drivers = drivers;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ScoreboardRow{" +
                "number=" + number +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", truck='" + truck + '\'' +
                ", cargoes=" + cargoes +
                ", drivers=" + drivers +
                ", status=" + status +
                '}';
    }
}

