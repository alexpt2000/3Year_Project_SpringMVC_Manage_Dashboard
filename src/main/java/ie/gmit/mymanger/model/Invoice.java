package ie.gmit.mymanger.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


/**
 * The Class Invoice.
 */
@Entity
public class Invoice {

	/** The code. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	/** The customer. */
	@NotEmpty(message = "Customer is required")
	@Size(max = 60, message = "The customer can not contain more than 60 characters")
	private String customer;

	/** The duedate. */
	@NotNull(message = "Due date is mandatory")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date duedate;

	/** The total. */
	// Set Validation
	@NotNull(message = "Total is mandatory")
	@DecimalMin(value = "0.01", message = "Total can not be less than 0.01")
	@DecimalMax(value = "9999999.99", message = "Total can not be greater than 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal total;

	/** The status. */
	@Enumerated(EnumType.STRING)
	private StatusInvoice status;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * Gets the duedate.
	 *
	 * @return the duedate
	 */
	public Date getDuedate() {
		return duedate;
	}

	/**
	 * Sets the duedate.
	 *
	 * @param duedate the new duedate
	 */
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public StatusInvoice getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(StatusInvoice status) {
		this.status = status;
	}

	/**
	 * Checks if is pending.
	 *
	 * @return true, if is pending
	 */
	public boolean isPending() {
		return StatusInvoice.PENDING.equals(this.status);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
