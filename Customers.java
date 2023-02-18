import java.util.ArrayList;

public class Customers {
	
	// Data field 
	
	private boolean specialOrder; // determine if the customer have special order or not 
	private boolean largeOrder; // determine if the customer have large order or not 
	private boolean onlineOrder; // determine if the customer order online or not
	private int numberOfOrders; // determine how many meal the customer want
	private int orderNumber;// show the order number // given 
	private int waitingTime;// show how much time the customer wait // from restaurant 
	private Order customerOrder; // the order of the customer
	private double customerRating; // the rating of the customer related to the food quality // from server
	private ArrayList<Food> receivedOrder = new ArrayList<Food>(); // The Food that he will receive from the server 


	// constructor
	public Customers() {
		Order customerOrder = new Order();
		this.customerOrder = customerOrder;
		setSpecialOrder(customerOrder);
		setLargeOrder(customerOrder);
		setNumberOfOrders(customerOrder);
		setOnlineOrder(Restaurant.getRandom(0, 101));
		while (customerOrder.getOrderAmount()==0) { // to ensure that there is order with the customer
			customerOrder = new Order();
		}
	}
	
	// isSpecialOrder getter
	public boolean isSpecialOrder() {
		return specialOrder;}
	
	// isSpecialOrder setter
	public void setSpecialOrder(Order customerOrder ) {
		if(customerOrder.getisItSpecial())
			specialOrder = true;}
	
	// isLargeOrder setter
	public boolean isLargeOrder() {
		return largeOrder;}

	//LargeOrder setter
	public void setLargeOrder(Order customerOrder) {
		if (customerOrder.getOrderAmount()>=10)
			largeOrder = true;}

	// isOnlineOrder getter
	public boolean isOnlineOrder() {
		return onlineOrder;}

	// OnlineOrder setter
	public void setOnlineOrder(int random) {
		if (random>75)
			onlineOrder = true;}

	// NumberOfOrders getter
	public int getNumberOfOrders() {
		return numberOfOrders;}

	// NumberOfOrders setter
	public void setNumberOfOrders(Order customerOrder) {
		numberOfOrders = customerOrder.getOrderAmount();}

	// OrderNumber getter
	public int getOrderNumber() {
		return orderNumber;}

	// OrderNumber setter
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
		customerOrder.setOrderNumber(orderNumber);}

	// WaitingTime getter 
	public int getWaitingTime() {
		return waitingTime;}

	// WaitingTime setter
	public void setWaitingTime() {
		this.waitingTime +=1;} 

	// CustomerOrder getter
	public Order getCustomerOrder() {
		return customerOrder;}

	// CustomerOrder setter
	public void setCustomerOrder(Order customerOrder) {
		this.customerOrder = customerOrder;}

	// CustomerRating getter
	public double getCustomerRating() {
		return customerRating;}

	// CustomerRating setter
	public void setCustomerRating(double customerRating) {
		this.customerRating = customerRating;}
	
	// ReceivedOrder array getter
	public ArrayList<Food> getReceivedOrder() {
		return receivedOrder;
	}
	
	// ReceivedOrder array getter
	public void setReceivedOrder(ArrayList<Food> receivedOrder) {
		this.receivedOrder = receivedOrder;
	}
	
	
	}
