package sv.unicomer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.unicomer.entities.Customer;
import sv.unicomer.service.CustomerService;

@RestController
public class CustomerController {

	ResponseEntity<?> response;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("getCustomer")
	public ResponseEntity<?> getAllCustomer(){	
		
		try {
			List<Customer> listCustomer;
			
			listCustomer=customerService.findAll();
			
			if(!listCustomer.isEmpty()) {
				response= new ResponseEntity<>(listCustomer,HttpStatus.OK);
			}
			else {
				response= new ResponseEntity<>(listCustomer,HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception ex) {
			response= new ResponseEntity<>("",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	
}
