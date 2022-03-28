
package com.restapi.main.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restapi.main.model.Customer;
import com.restapi.main.repository.CustomerRepository;
/**
 * @author mahedi.hassan
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer em) {
		return customerRepo.save(em);
	}

	@Override
	public Customer getCustomerByID(Long id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		}
		throw new RuntimeException("no customer found for the id: " + id);
	}

	@Override
	public void deleteCustomerById(Long id) {
		customerRepo.deleteById(id);
	}

	@Override
	public Customer updateCustomerByID(Customer em) {
		return customerRepo.save(em);
	}

}
