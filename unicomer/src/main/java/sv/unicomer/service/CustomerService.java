package sv.unicomer.service;

import java.util.List;

import sv.unicomer.entities.Customer;

public interface CustomerService {
	List<Customer> findAll();
}
