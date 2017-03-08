package ie.gmit.mymanger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.gmit.mymanger.model.Invoice;

/**
 * The Interface Invoices.
 */
public interface Invoices extends JpaRepository<Invoice, Long> {

	/**
	 * Find by customer containing.
	 *
	 * @param customer the customer
	 * @return the list
	 */
	public List<Invoice> findByCustomerContaining(String customer);

}
