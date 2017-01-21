package ie.gmit.mymanger.model;

public enum StatusInvoice {

	PENDING("Pending"),
	RECEIVED("Received");
	
	private String description;
	
	StatusInvoice(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
