
package com.restapi.main.service;

import java.util.List;

import com.restapi.main.model.Customer;

/**
 * @author mahedi.hassan
 *
 */
public interface CustomerService {
	List<Customer> getCustomers();
	Customer saveCustomer(Customer em);
	Customer getCustomerByID(Long id);
	void deleteCustomerById(Long id);
	Customer updateCustomerByID(Customer em);


}
