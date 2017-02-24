package ie.gmit.mymanger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.gmit.mymanger.model.Customer;
import ie.gmit.mymanger.repository.filter.CustomerFilter;
import ie.gmit.mymanger.service.AddCustomerService;


/**
 * The Class CustomerController.
 * 
 * All Requests relates to customers will be calling in this method
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

	// Name of page
	private static final String ADD_CUSTOMER = "AddCustomer";


	@Autowired
	private AddCustomerService addCustomerService;

	/**
	 * New customer.
	 *
	 * @return the model and view, to add a new customer
	 */
	@RequestMapping("/newcustomer")
	public ModelAndView newCustomer() {
		ModelAndView mv = new ModelAndView(ADD_CUSTOMER);
		mv.addObject(new Customer());
		return mv;
	}

	/**
	 * Save.
	 *
	 * @param customer, all values
	 * @param errors, carry errors from bean customer
	 * @param attributes, passing msg between pages
	 * @return Customer list
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Customer customer, Errors errors, RedirectAttributes attributes) {
		
		
		if (errors.hasErrors()) {
			return ADD_CUSTOMER;
		}

		addCustomerService.save(customer); // Save the object
		attributes.addFlashAttribute("message", "Customer saved successfully!"); // Pass MSG
		return "redirect:/customers/newcustomer";

	}

	/**
	 * Search.
	 *
	 * @param filter the filter
	 * @return the model and view
	 */
	@RequestMapping
	public ModelAndView search(@ModelAttribute("filter") CustomerFilter filter) {
		List<Customer> allCustomers = addCustomerService.Filter(filter);

		ModelAndView mv = new ModelAndView("ListCustomer");
		mv.addObject("customers", allCustomers);
		return mv;
	}

	/**
	 * Edits the.
	 *
	 * @param customer the customer
	 * @return the model and view
	 */
	@RequestMapping("{customerid}")
	public ModelAndView edit(@PathVariable("customerid") Customer customer) {
		ModelAndView mv = new ModelAndView(ADD_CUSTOMER);
		mv.addObject(customer);
		return mv;
	}

	/**
	 * Delete.
	 *
	 * @param customerid the customerid
	 * @param attributes the attributes
	 * @return the string
	 */
	@RequestMapping(value = "{code}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long code, RedirectAttributes attributes) {
		addCustomerService.delete(code);

		attributes.addFlashAttribute("message", "Customer deleted successfully!");
		return "redirect:/customers";
	}

}
