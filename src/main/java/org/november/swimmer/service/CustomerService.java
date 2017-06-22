package org.november.swimmer.service;

import org.november.swimmer.dao.CustomerRepository;
import org.november.swimmer.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository repository;

	public void saveAllCustomers() {
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
	}
	
	public void saveCustomer(String firstName, String lastName){
		repository.save(new Customer(firstName, lastName));
	}
	
	public Customer getFirstCustomer() {
		Customer customer = repository.findOne(1L);
		log.info("Customer found with findOne(1L):");
		log.info("--------------------------------");
		log.info(customer.toString());
		log.info("");
		return customer;
	}
	
	public void getAllCustomer() {
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

	}
	
	
	public void findCustomerByLastName(String lastName) {
		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		for (Customer bauer : repository.findByLastName(lastName)) {
			log.info(bauer.toString());
		}
		log.info("");
	}
}
