package ie.gmit.mymanger.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import ie.gmit.mymanger.model.Invoice;
import ie.gmit.mymanger.repository.filter.InvoiceFilter;
import ie.gmit.mymanger.service.AddInvoiceService;


@Controller
@RequestMapping("/invoices")
public class InvoiceController {
	
	private static final String ADD_INVOICE = "AddInvoice";
	
	@Autowired
	private AddInvoiceService addInvoiceService;

	@RequestMapping("/newinvoice")
	public ModelAndView newInvoice() {
		ModelAndView mv = new ModelAndView(ADD_INVOICE);
		mv.addObject(new Invoice());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated Invoice invoice, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return ADD_INVOICE;
		}
		
		try {
			addInvoiceService.save(invoice);
			attributes.addFlashAttribute("message", "Invoice saved successfully!");
			return "redirect:/invoices/newinvoice";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("duedate", null, e.getMessage());
			return ADD_INVOICE;
		}
	}
	
	@RequestMapping
	public ModelAndView search(@ModelAttribute("filter") InvoiceFilter filter) {
		List<Invoice> allInvoices = addInvoiceService.Filter(filter);
		
		ModelAndView mv = new ModelAndView("ListInvoice");
		mv.addObject("invoices", allInvoices);
		return mv;
	}
	
	@RequestMapping("{code}")
	public ModelAndView edicao(@PathVariable("code") Invoice invoice) {
		ModelAndView mv = new ModelAndView(ADD_INVOICE); 
		mv.addObject(invoice);
		return mv;
	}
	
	@RequestMapping(value="{code}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long code, RedirectAttributes attributes) {
		addInvoiceService.delete(code);
		
		attributes.addFlashAttribute("message", "Invoice deleted successfully!");
		return "redirect:/invoices";
	}
	
	@RequestMapping(value = "/{code}/receive", method = RequestMethod.PUT)
	public @ResponseBody String receive(@PathVariable Long code) {
		return addInvoiceService.receive(code);
	}
	
	@ModelAttribute("allStatusInvoice")
	public List<StatusInvoice> allStatusInvoice() {
		return Arrays.asList(StatusInvoice.values());
	}
	
}
