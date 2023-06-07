package service;

import model.Account;

public class AccountCreator {
    public static final String ACCOUNT_NAME = TestDataReader.getTestData("accountName");
    public static final String WEBSITE = TestDataReader.getTestData("website");
    public static final String TYPE = TestDataReader.getTestData("type");
    public static final String DESCRIPTION = TestDataReader.getTestData("description");
    public static final String PHONE = TestDataReader.getTestData("phone");
    public static final String UPDATED_PHONE = TestDataReader.getTestData("updatedPhone");
    public static final String INDUSTRY = TestDataReader.getTestData("industry");
    public static final String EMPLOYEES = TestDataReader.getTestData("employees");
    public static final String BILLING_STREET = TestDataReader.getTestData("billingStreet");
    public static final String BILLING_CITY = TestDataReader.getTestData("billingCity");
    public static final String BILLING_STATE = TestDataReader.getTestData("billingState");
    public static final String BILLING_ZIP = TestDataReader.getTestData("billingZip");
    public static final String BILLING_COUNTRY = TestDataReader.getTestData("billingCountry");
    public static final String SHIPPING_STREET = TestDataReader.getTestData("shippingStreet");
    public static final String SHIPPING_CITY = TestDataReader.getTestData("shippingCity");
    public static final String SHIPPING_STATE = TestDataReader.getTestData("shippingState");
    public static final String SHIPPING_ZIP = TestDataReader.getTestData("shippingZip");
    public static final String SHIPPING_COUNTRY = TestDataReader.getTestData("shippingCountry");


    public static Account withParametersFromProperty() {
        return Account.builder()
                .accountName(ACCOUNT_NAME)
                .website(WEBSITE)
                .type(TYPE)
                .description(DESCRIPTION)
                .phone(PHONE)
                .industry(INDUSTRY)
                .employees(EMPLOYEES)
                .billingStreet(BILLING_STREET)
                .billingCity(BILLING_CITY)
                .billingState(BILLING_STATE)
                .billingZip(BILLING_ZIP)
                .billingCountry(BILLING_COUNTRY)
                .shippingStreet(SHIPPING_STREET)
                .shippingCity(SHIPPING_CITY)
                .shippingState(SHIPPING_STATE)
                .shippingZip(SHIPPING_ZIP)
                .shippingCountry(SHIPPING_COUNTRY)
                .build();
    }

    public static Account withUpdatedPhone() {
        return Account.builder()
                .accountName(ACCOUNT_NAME)
                .website(WEBSITE)
                .type(TYPE)
                .description(DESCRIPTION)
                .phone(UPDATED_PHONE)
                .industry(INDUSTRY)
                .employees(EMPLOYEES)
                .billingStreet(BILLING_STREET)
                .billingCity(BILLING_CITY)
                .billingState(BILLING_STATE)
                .billingZip(BILLING_ZIP)
                .billingCountry(BILLING_COUNTRY)
                .shippingStreet(SHIPPING_STREET)
                .shippingCity(SHIPPING_CITY)
                .shippingState(SHIPPING_STATE)
                .shippingZip(SHIPPING_ZIP)
                .shippingCountry(SHIPPING_COUNTRY)
                .build();
    }
}
