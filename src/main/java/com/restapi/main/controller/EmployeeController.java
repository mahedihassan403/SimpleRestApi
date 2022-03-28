package com.restapi.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.main.request.EmployeeRequest;
import com.restapi.main.service.EmployeeService;
/**
 * @author mahedi.hassan
 *
 */
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService emp;
	
	@GetMapping("/get_employee")
	public String getEmplyee(@RequestBody EmployeeRequest empReq){
		return emp.getEmploye(empReq);
	} 

}
