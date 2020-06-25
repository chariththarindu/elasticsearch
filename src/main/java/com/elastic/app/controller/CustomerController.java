package com.elastic.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.app.model.Customer;
import com.elastic.app.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	final CustomerRepository customerRepository;

	@Autowired
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PostMapping()
	public ResponseEntity<?> saveCustomer(@RequestBody List<Customer> customers) {
	  Iterable<Customer> res = customerRepository.saveAll(customers);
		return new ResponseEntity<>(customers.size() , HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllCustomers() {
		
		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{firstname}")
	public ResponseEntity<?> findByFirstName(@PathVariable("firstname") String firstname) {
		
		List<Customer> cus = customerRepository.findByFirstName(firstname);
		return new ResponseEntity<>(cus, HttpStatus.OK);
	}
}
