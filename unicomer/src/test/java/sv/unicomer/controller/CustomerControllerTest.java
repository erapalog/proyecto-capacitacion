package sv.unicomer.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import sv.unicomer.entities.Customer;
import sv.unicomer.service.CustomerService;


@WebMvcTest(value=CustomerController.class)
class CustomerControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	

	@Test
	void test() throws Exception {
		
		List<Customer> listCustomer= new ArrayList<>();
		
		Customer customer= new Customer();
		customer.setId(1);
		customer.setName("Ana");
		
		listCustomer.add(customer);
		 
		//Interceta llamada a servicio
		Mockito.when(customerService.findAll()).thenReturn(listCustomer);
		
		RequestBuilder requestBuilder =  MockMvcRequestBuilders.get("/getCustomer").accept(MediaType.APPLICATION_JSON);
		
		MvcResult resul=mockMvc.perform(requestBuilder).andReturn();
		
		
		Assertions.assertEquals(200, resul.getResponse().getStatus());

	}

}
