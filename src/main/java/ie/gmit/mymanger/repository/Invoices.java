package ie.gmit.mymanger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.gmit.mymanger.model.Invoice;

public interface Invoices extends JpaRepository<Invoice, Long> {

	public List<Invoice> findByCustomerContaining(String customer);

}
