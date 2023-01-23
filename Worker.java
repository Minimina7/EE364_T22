
public abstract class Worker {
private int orderNumber;
private Order customerOrder;
private Customers customersAtservice;
public int getOrderNumber() {
	return orderNumber;
}
public void setOrderNumber(int orderNumber) {
	this.orderNumber = orderNumber;
}
public Order getCustomerOrder() {
	return customerOrder;
}
public void setCustomerOrder(Order customerOrder) {
	this.customerOrder = customerOrder;
}
public abstract void serveCustomer(Customers customersAtservice);
}
