package ie.gmit.mymanger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.gmit.mymanger.model.Customer;


public interface Customers extends JpaRepository<Customer, Long> {

	public List<Customer> findByCustomernameContaining(String customername);

}
