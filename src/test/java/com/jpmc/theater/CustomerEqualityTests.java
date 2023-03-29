package com.jpmc.theater;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerEqualityTests {

    @Test
    void checkEqualityCustomer() {
        Customer customer1 = new Customer("John", "1");
        Customer customer2 = new Customer("John", "1");
        Assertions.assertEquals(customer1 , customer2);
    }

    @Test
    void checkUnEqualityCustomerNoSerialIdInOneCustomer() {
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("John", "1");
        Assertions.assertNotEquals(customer1 , customer2);
    }

    @Test
    void checkUnEqualityCustomerNoSerialId() {
        Customer customer1 = new Customer("John1");
        Customer customer2 = new Customer("John" );
        Assertions.assertNotEquals(customer1 , customer2);
    }

    @Test
    void checkUnEqualityCustomerWithSerialId() {
        Customer customer1 = new Customer("John1");
        Customer customer2 = new Customer("John", "seqid" );
        Assertions.assertNotEquals(customer1 , customer2);
    }
}
