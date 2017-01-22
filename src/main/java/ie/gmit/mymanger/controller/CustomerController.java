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

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private static final String ADD_CUSTOMER = "AddCustomer";

	@Autowired
	private AddCustomerService addCustomerService;

	@RequestMapping("/newcustomer")
	public ModelAndView newCustomer() {
		ModelAndView mv = new ModelAndView(ADD_CUSTOMER);
		mv.addObject(new Customer());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Customer customer, Errors errors, RedirectAttributes attributes) {
		
		System.out.println("Recebendo post");
		
		if (errors.hasErrors()) {
			return ADD_CUSTOMER;
		}

		System.out.println("Teste primeiro save");
		addCustomerService.save(customer);
		attributes.addFlashAttribute("message", "Customer saved successfully!");
		return "redirect:/customers/newcustomer";

	}

	@RequestMapping
	public ModelAndView search(@ModelAttribute("filter") CustomerFilter filter) {
		List<Customer> allCustomers = addCustomerService.Filter(filter);

		ModelAndView mv = new ModelAndView("ListCustomer");
		mv.addObject("customers", allCustomers);
		return mv;
	}

	@RequestMapping("{customerid}")
	public ModelAndView edit(@PathVariable("customerid") Customer customer) {
		ModelAndView mv = new ModelAndView(ADD_CUSTOMER);
		mv.addObject(customer);
		return mv;
	}

	@RequestMapping(value = "{curtomerid}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long customerid, RedirectAttributes attributes) {
		addCustomerService.delete(customerid);

		attributes.addFlashAttribute("message", "Customer deleted successfully!");
		return "redirect:/customers";
	}

}
