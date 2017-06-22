package org.november.swimmer.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.november.swimmer.domain.Customer;
import org.november.swimmer.dto.Greeting;
import org.november.swimmer.dto.Greeting2;
import org.november.swimmer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CustomerService customerDaoService;
    
    @RequestMapping(value="/saveGreeting", method=RequestMethod.POST)
    public void saveGreeting(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
    	customerDaoService.saveCustomer(firstName, lastName);
    }
    
    @RequestMapping("/greeting2")
    public Greeting2 greeting2(@RequestParam(value="name", defaultValue="World") String name) {
    	Customer customer = customerDaoService.getFirstCustomer();
    	
        return new Greeting2(customer.getId(), customer.getFirstName(), customer.getLastName());
    }
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	Customer customer = customerDaoService.getFirstCustomer();
    	
        return new Greeting(counter.incrementAndGet(), customer);
    }
}