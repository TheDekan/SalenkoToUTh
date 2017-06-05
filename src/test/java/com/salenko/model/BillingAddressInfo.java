package com.salenko.model;

//https://unidoc.unitedthinkers.com/processing-api/realtime/operations#component_Sale_Request_field_group_Billing_Address_Information
public class BillingAddressInfo {

    private String zipCode;

    public BillingAddressInfo(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
