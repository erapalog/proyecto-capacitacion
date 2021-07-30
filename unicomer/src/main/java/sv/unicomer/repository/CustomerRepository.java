package sv.unicomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.unicomer.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	

}
