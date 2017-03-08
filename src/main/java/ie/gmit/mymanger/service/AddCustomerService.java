package ie.gmit.mymanger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.mymanger.model.Customer;
import ie.gmit.mymanger.repository.Customers;
import ie.gmit.mymanger.repository.filter.CustomerFilter;

/**
 * The Class AddCustomerService.
 */
@Service
public class AddCustomerService {

	/** The customers. */
	@Autowired
	private Customers customers;

	/**
	 * Save. Into Database
	 *
	 * @param customer the customer
	 */
	public void save(Customer customer) {

		customers.save(customer);

	}

	/**
	 * Delete. Customer from database
	 *
	 * @param customerid the customerid
	 */
	public void delete(Long customerid) {
		customers.delete(customerid);
	}

	/**
	 * Filter. Geting Customer from Database
	 *
	 * @param filter the filter
	 * @return the list whit customers
	 */
	public List<Customer> Filter(CustomerFilter filter) {
		String customername = filter.getCustomer() == null ? "%" : filter.getCustomer();
		return customers.findByCustomernameContaining(customername);
	}

}
