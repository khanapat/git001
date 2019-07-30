package com.example.demo4.model;

public class CustomerRequest {

    private String iD;
    private String firstName;
    private String lastName;
    private int dayReg;
    private int monthReg;

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDayReg() {
        return dayReg;
    }

    public void setDayReg(int dayReg) {
        this.dayReg = dayReg;
    }

    public int getMonthReg() {
        return monthReg;
    }

    public void setMonthReg(int monthReg) {
        this.monthReg = monthReg;
    }
}
