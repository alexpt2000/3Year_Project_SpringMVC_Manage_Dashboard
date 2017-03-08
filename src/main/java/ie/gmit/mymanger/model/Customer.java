package ie.gmit.mymanger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The Class Customer.
 */
@Entity
public class Customer {

	/** The customerid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerid;

	/** The customername. */
	@NotEmpty(message = "Customer is required")
	@Size(max = 60, message = "The customer can not contain more than 60 characters")
	private String customername;

	/** The address 1. */
	@Size(max = 60)
	private String address1;

	/** The address 2. */
	@Size(max = 60)
	private String address2;

	/** The city. */
	@Size(max = 25)
	private String city;

	/** The stateprovince. */
	@Size(max = 25)
	private String stateprovince;

	/** The zipcode. */
	@Size(max = 25)
	private String zipcode;

	/** The country. */
	@Size(max = 25)
	private String country;

	/** The phonenumber. */
	@Size(max = 25)
	private String phonenumber;

	/** The email. */
	@Size(max = 25)
	private String email;

	/**
	 * Gets the customerid.
	 *
	 * @return the customerid
	 */
	public Long getCustomerid() {
		return customerid;
	}

	/**
	 * Sets the customerid.
	 *
	 * @param customerid the new customerid
	 */
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	/**
	 * Gets the customername.
	 *
	 * @return the customername
	 */
	public String getCustomername() {
		return customername;
	}

	/**
	 * Sets the customername.
	 *
	 * @param customername the new customername
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
	}

	/**
	 * Gets the address 1.
	 *
	 * @return the address 1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the address 1.
	 *
	 * @param address1 the new address 1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the address 2.
	 *
	 * @return the address 2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the address 2.
	 *
	 * @param address2 the new address 2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the stateprovince.
	 *
	 * @return the stateprovince
	 */
	public String getStateprovince() {
		return stateprovince;
	}

	/**
	 * Sets the stateprovince.
	 *
	 * @param stateprovince the new stateprovince
	 */
	public void setStateprovince(String stateprovince) {
		this.stateprovince = stateprovince;
	}

	/**
	 * Gets the zipcode.
	 *
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Sets the zipcode.
	 *
	 * @param zipcode the new zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the phonenumber.
	 *
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * Sets the phonenumber.
	 *
	 * @param phonenumber the new phonenumber
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
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
		Customer other = (Customer) obj;
		if (customerid == null) {
			if (other.customerid != null)
				return false;
		} else if (!customerid.equals(other.customerid))
			return false;
		return true;
	}

}
