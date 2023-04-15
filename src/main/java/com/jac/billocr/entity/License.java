package com.jac.billocr.entity;

public class License {
    private String vin;
    private String people;
    private String licensePlate;
    private String registrationDate;
    private String nature;

    public License() {
    }

    public License(String vin, String people, String licensePlate, String registrationDate, String nature) {
        this.vin = vin;
        this.people = people;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
        this.nature = nature;
    }

    /**
     * 获取
     * @return vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * 设置
     * @param vin
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * 获取
     * @return people
     */
    public String getPeople() {
        return people;
    }

    /**
     * 设置
     * @param people
     */
    public void setPeople(String people) {
        this.people = people;
    }

    /**
     * 获取
     * @return licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * 设置
     * @param licensePlate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * 获取
     * @return registrationDate
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * 设置
     * @param registrationDate
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * 获取
     * @return nature
     */
    public String getNature() {
        return nature;
    }

    /**
     * 设置
     * @param nature
     */
    public void setNature(String nature) {
        this.nature = nature;
    }

    public String toString() {
        return "License{vin = " + vin + ", people = " + people + ", licensePlate = " + licensePlate + ", registrationDate = " + registrationDate + ", nature = " + nature + "}";
    }
}
