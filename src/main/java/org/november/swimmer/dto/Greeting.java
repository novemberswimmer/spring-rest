package org.november.swimmer.dto;

import org.november.swimmer.domain.Customer;

public class Greeting {

    private final long id;
    private final Customer customer;

    public Greeting(long id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
    	return customer;
    }
}