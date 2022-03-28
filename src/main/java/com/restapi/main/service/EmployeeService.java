package com.restapi.main.service;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Repository;

import com.restapi.main.request.EmployeeRequest;

/**
 * @author mahedi.hassan
 *
 */
@Service
@Repository
public class EmployeeService {
	
	public String getEmploye(EmployeeRequest req) {
		Client client = ClientBuilder.newClient();
		WebTarget resource = client.target("http://localhost:8081/employees/"+req.getId());
		Builder request = resource.request();
		request.accept(MediaType.APPLICATION_JSON);
		Response response = request.get();
		String responseAsString = response.readEntity(String.class);
		System.out.println(responseAsString);
		if (response.getStatusInfo().getFamily() == Family.SUCCESSFUL) {
		    System.out.println("Success! " + response.getStatus());
		   // System.out.println(response.getEntity());
		} else {
		    System.out.println("ERROR! " + response.getStatus());    
		    //System.out.println(response.getEntity());
		}
		return responseAsString;
	}

}
