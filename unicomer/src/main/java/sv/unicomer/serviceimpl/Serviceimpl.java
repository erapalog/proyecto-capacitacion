package sv.unicomer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.unicomer.entities.Customer;
import sv.unicomer.repository.CustomerRepository;
import sv.unicomer.service.CustomerService;

@Service
public class Serviceimpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public List<Customer> findAll(){		
		return customerRepository.findAll();
	}
	

}
