package com.autowiringparadox.dto;

public class Data {

    private int number;
    private int power;

    public Data() {
    }

    public Data(int number, int power) {
        this.number = number;
        this.power = power;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Data{" +
                "number=" + number +
                ", power=" + power +
                '}';
    }
}
