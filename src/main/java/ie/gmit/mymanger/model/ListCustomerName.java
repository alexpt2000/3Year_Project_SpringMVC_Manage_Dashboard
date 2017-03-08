package ie.gmit.mymanger.model;

/**
 * The Class ListCustomerName.
 */
public class ListCustomerName {

	/** The Customer name. */
	private String CustomerName;

	/**
	 * Instantiates a new list customer name.
	 *
	 * @param customerName the customer name
	 */
	public ListCustomerName(String customerName) {
		CustomerName = customerName;
	}

	/**
	 * Gets the customer name.
	 *
	 * @return the customer name
	 */
	public String getCustomerName() {
		return CustomerName;
	}

	/**
	 * Sets the customer name.
	 *
	 * @param customerName the new customer name
	 */
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

}
