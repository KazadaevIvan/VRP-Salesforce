package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Account {
    String accountName;
    String website;
    String type;
    String phone;
    String description;
    String industry;
    String employees;
    String billingStreet;
    String billingCity;
    String billingState;
    String billingZip;
    String billingCountry;
    String shippingStreet;
    String shippingCity;
    String shippingState;
    String shippingZip;
    String shippingCountry;

    public String billingAddressConstructor() {
        return getBillingStreet() + "\n" + getBillingZip() + " " + getBillingCity() + "\n" + getBillingState() +
                " " + getBillingCountry() + "\n";
    }

    public String shippingAddressConstructor() {
        return getShippingStreet() + "\n" + getShippingZip() + " " + getShippingCity() + "\n" + getShippingState() +
                " " + getShippingCountry() + "\n";
    }
}