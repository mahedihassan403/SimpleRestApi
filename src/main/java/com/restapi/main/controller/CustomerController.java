package com.restapi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.main.model.Customer;
import com.restapi.main.service.CustomerServiceImpl;

/**
 * @author mahedi.hassan
 *
 */
@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceImpl eService;

	/**
	 * @value can read the property of application.property file
	 */
	@Value("app.name: default app")
	String appName;

	private String getAppversion() {
		return appName;
	}

	@GetMapping("/customers")
	private List<Customer> getCustomers() {
		return eService.getCustomers();
	}

	@GetMapping("/customers/{id}")
	private Customer getCustomerById(@PathVariable("id") Long id) {
		return eService.getCustomerByID(id);
	}

	// localhost:8080/customers/100
	@PutMapping("/customers/{id}")
	private Customer updateCustomerById(@PathVariable("id") Long id, @RequestBody Customer customer) {
		customer.setId(id);
		return eService.updateCustomerByID(customer);
	}

	@PostMapping("/customers")
	private Customer addNewCustomer(@RequestBody Customer customer) {
		return eService.saveCustomer(customer);
	}

	// localhost:8080/customers? id =100
	@DeleteMapping("/customers")
	private void deleteCustomerById(@RequestParam("id") Long id) {
		eService.deleteCustomerById(id);
	}

}
