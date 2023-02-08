
public abstract class Worker {
	private int orderNumber; // instance variable that save the order number
	private Order customerOrder; // instance variable that save the customer order
	private Customers customersAtservice; // instance variable that deal with the customers at service

	public int getOrderNumber() { // method to get the order number
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) { // method to set order number

		this.orderNumber = orderNumber;
		customersAtservice.setOrderNumber(orderNumber);

	}

	public Order getCustomerOrder() { // method to get customer order
		return customerOrder;
	}

	public void setCustomerAndCustomerOrder(Customers customersAtservice) { // method to set customer and customerOrder
		this.customersAtservice = customersAtservice;
		this.customerOrder = customersAtservice.getCustomerOrder();
	}

	public abstract void serveCustomer(Customers customersAtservice); // abstract method to serve the customer

	public Customers getServedCustomer() { // method that return the service to the customer
		return customersAtservice;
	}

}
