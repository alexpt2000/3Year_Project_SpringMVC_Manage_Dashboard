package ie.gmit.mymanger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.gmit.mymanger.model.Customer;


/**
 * The Interface Customers.
 */
public interface Customers extends JpaRepository<Customer, Long> {

	/**
	 * Find by customername containing.
	 *
	 * @param customername the customername
	 * @return the list
	 */
	public List<Customer> findByCustomernameContaining(String customername);

}
