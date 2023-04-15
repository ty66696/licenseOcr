package com.jac.billocr.entity;

public class Invoice {
    private String vin;
    private String invoiceCode;
    private String invoiceNumber;
    private String invoiceDate;
    private String invoicePrice;
    private String invoiceVerification;

    public Invoice() {
    }

    public Invoice(String vin, String invoiceCode, String invoiceNumber, String invoiceDate, String invoicePrice, String invoiceVerification) {
        this.vin = vin;
        this.invoiceCode = invoiceCode;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoicePrice = invoicePrice;
        this.invoiceVerification = invoiceVerification;
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
     * @return invoiceCode
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 设置
     * @param invoiceCode
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    /**
     * 获取
     * @return invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * 设置
     * @param invoiceNumber
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * 获取
     * @return invoiceDate
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * 设置
     * @param invoiceDate
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * 获取
     * @return invoicePrice
     */
    public String getInvoicePrice() {
        return invoicePrice;
    }

    /**
     * 设置
     * @param invoicePrice
     */
    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    /**
     * 获取
     * @return invoiceVerification
     */
    public String getInvoiceVerification() {
        return invoiceVerification;
    }

    /**
     * 设置
     * @param invoiceVerification
     */
    public void setInvoiceVerification(String invoiceVerification) {
        this.invoiceVerification = invoiceVerification;
    }

    public String toString() {
        return "invoice{vin = " + vin + ", invoiceCode = " + invoiceCode + ", invoiceNumber = " + invoiceNumber + ", invoiceDate = " + invoiceDate + ", invoicePrice = " + invoicePrice + ", invoiceVerification = " + invoiceVerification + "}";
    }
}
