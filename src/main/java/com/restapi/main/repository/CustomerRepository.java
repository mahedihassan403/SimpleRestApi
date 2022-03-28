/**
 * 
 */
package com.restapi.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.restapi.main.model.Customer;

/**
 * @author mahedi.hassan
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

   // @RestResource(path = "names")
    List<Customer> findByName(@RequestParam("name") String name);

}
