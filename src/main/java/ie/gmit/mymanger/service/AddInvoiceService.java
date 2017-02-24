package ie.gmit.mymanger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ie.gmit.mymanger.model.StatusInvoice;
import ie.gmit.mymanger.model.Invoice;
import ie.gmit.mymanger.repository.Invoices;
import ie.gmit.mymanger.repository.filter.InvoiceFilter;


@Service
public class AddInvoiceService {

	@Autowired
	private Invoices invoices;

	public void save(Invoice invoice) {
		try {
			invoices.save(invoice);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Invalid date format");
		}
	}

	public void delete(Long codigo) {
		System.out.println("Delete ok");
		invoices.delete(codigo);
	}

	public String receive(Long codigo) {
		Invoice invoice = invoices.findOne(codigo);
		invoice.setStatus(StatusInvoice.RECEIVED);
		invoices.save(invoice);

		return StatusInvoice.RECEIVED.getDescription();
	}

	public List<Invoice> Filter(InvoiceFilter filter) {
		String customer = filter.getCustomer() == null ? "%" : filter.getCustomer();
		return invoices.findByCustomerContaining(customer);
	}

}
