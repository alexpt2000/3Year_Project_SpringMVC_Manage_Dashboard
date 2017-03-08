package ie.gmit.mymanger.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.gmit.mymanger.model.StatusInvoice;
import ie.gmit.mymanger.model.Customer;
import ie.gmit.mymanger.model.Invoice;
import ie.gmit.mymanger.model.ListCustomerName;
import ie.gmit.mymanger.repository.filter.CustomerFilter;
import ie.gmit.mymanger.repository.filter.InvoiceFilter;
import ie.gmit.mymanger.service.AddInvoiceService;



/**
 * The Class InvoiceController.
 */
@Controller
@RequestMapping("/invoices")
public class InvoiceController {

	/** The Constant ADD_INVOICE. */
	private static final String ADD_INVOICE = "AddInvoice";

	/** The add invoice service. */
	@Autowired
	private AddInvoiceService addInvoiceService;

	/**
	 * New invoice.
	 *
	 * @return the model and view to add a new invoice
	 */
	@RequestMapping("/newinvoice")
	public ModelAndView newInvoice() {
		ModelAndView mv = new ModelAndView(ADD_INVOICE);
		mv.addObject(new Invoice());
		return mv;
	}

	/**
	 * Save Invoice into Database.
	 *
	 * @return the string AddInvoice
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Invoice invoice, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return ADD_INVOICE;
		}

		// try if no errors the invoice will be saved
		try {
			addInvoiceService.save(invoice);
			attributes.addFlashAttribute("message", "Invoice saved successfully!");
			return "redirect:/invoices/newinvoice";
			// if are some errors, the invoice will returns errors
		} catch (IllegalArgumentException e) {
			errors.rejectValue("duedate", null, e.getMessage());
			return ADD_INVOICE;
		}
	}

	/**
	 * Search Ivoice
	 */
	@RequestMapping
	public ModelAndView search(@ModelAttribute("filter") InvoiceFilter filter) {
		List<Invoice> allInvoices = addInvoiceService.Filter(filter);

		ModelAndView mv = new ModelAndView("ListInvoice");
		mv.addObject("invoices", allInvoices);
		return mv;
	}

	/**
	 * Edits the.
	 *
	 * @param invoice the invoice code
	 * @return the model and view AddInvoice
	 */
	@RequestMapping("{code}")
	public ModelAndView edit(@PathVariable("code") Invoice invoice) {
		ModelAndView mv = new ModelAndView(ADD_INVOICE);
		mv.addObject(invoice);
		return mv;
	}

	/**
	 * Delete invoice.
	 *
	 * @return the string list invoices
	 */
	@RequestMapping(value = "{code}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long code, RedirectAttributes attributes) {
		
		// Pass the code and for delete.
		addInvoiceService.delete(code);

		attributes.addFlashAttribute("message", "Invoice deleted successfully!");
		return "redirect:/invoices";
	}

	/**
	 * Receive, Set the status as Received
	 */
	@RequestMapping(value = "/{code}/receive", method = RequestMethod.PUT)
	public @ResponseBody String receive(@PathVariable Long code) {
		return addInvoiceService.receive(code);
	}

	/**
	 * All customers invoice.
	 *
	 * @return the array list
	 */
//	@ModelAttribute("allCustomersInvoice")
//	public ArrayList<ListCustomerName> allCustomersInvoice() {
//		ArrayList<ListCustomerName> customerList = new ArrayList<ListCustomerName>();
//		customerList.add(new ListCustomerName("Alex"));
//		customerList.add(new ListCustomerName("Vanessa"));
//
//		return customerList;
//	}

	/**
	 * All status invoice PENDING OR RECEIVED.
	 *
	 * @return the list enum StatusInvoice
	 */
	@ModelAttribute("allStatusInvoice")
	public List<StatusInvoice> allStatusInvoice() {
		return Arrays.asList(StatusInvoice.values());
	}

}
