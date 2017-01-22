package ie.gmit.mymanger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.gmit.mymanger.model.Customer;
import ie.gmit.mymanger.repository.Customers;
import ie.gmit.mymanger.repository.filter.CustomerFilter;

@Service
public class AddCustomerService {

	@Autowired
	private Customers customers;

	public void save(Customer customer) {

		System.out.println("Teste Save");
		customers.save(customer);

	}

	public void delete(Long customerid) {
		customers.delete(customerid);
	}

	public List<Customer> Filter(CustomerFilter filter) {
		String customername = filter.getCustomer() == null ? "%" : filter.getCustomer();
		return customers.findByCustomernameContaining(customername);
	}

}
