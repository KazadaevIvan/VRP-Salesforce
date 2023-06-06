package service;

import model.Account;

public class AccountCreator {

    public static Account withParametersFromProperty() {
        return Account.builder()
                .accountName("Account for testing")
                .website("website")
                .type("Analyst")
                .description("description")
                .phone("12345678")
                .industry("Banking")
                .employees("20")
                .billingStreet("ul. Lenina")
                .billingCity("Minsk")
                .billingState("Minsk")
                .billingZip("220140")
                .billingCountry("Belarus")
                .shippingStreet("ul. Pushkina")
                .shippingCity("Minsk")
                .shippingState("Minsk")
                .shippingZip("220018")
                .shippingCountry("Belarus")
                .build();
    }
}
