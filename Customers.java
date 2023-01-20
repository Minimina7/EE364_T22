
public class Customers {
	private boolean specialOrder; // determine if the customer have special order or not 
	private boolean largeOrder; // determine if the customer have large order or not 
	private boolean onlineOrder; // determine if the customer order online or not
	private int numberOfOrders; // determine how many meal the customer want
	private int orderNumber;// show the order number // given by cashier
	private int waitingTime;// show how much time the customer wait // from restaurant 
	private Order customerOrder; // the order of the customer
	private double customerRating; // the rating of the customer related to the food quality // from server

	
	public Customers() {
		Order customerOrder = new Order();
		this.customerOrder = customerOrder;
		setSpecialOrder(customerOrder);
		setLargeOrder(customerOrder);
		setNumberOfOrders(customerOrder);
		setOnlineOrder(restaurant.getRandom(0, 101));}
	
	
	public boolean isSpecialOrder() {
		return specialOrder;}

	public void setSpecialOrder(Order customerOrder ) {
		if(customerOrder.getisItSpecial())
			specialOrder = true;}

	public boolean isLargeOrder() {
		return largeOrder;}

	public void setLargeOrder(Order customerOrder) {
		if (customerOrder.getOrderAmount()>=10) // check number
			largeOrder = true;}

	public boolean isOnlineOrder() {
		return onlineOrder;}

	public void setOnlineOrder(int random) {
		if (random>75)// check number
			onlineOrder = true;}

	public int getNumberOfOrders() {
		return numberOfOrders;}//done

	public void setNumberOfOrders(Order customerOrder) {
		numberOfOrders = customerOrder.getOrderAmount();}//we can delete it and do it with large order

	public int getOrderNumber() {
		return orderNumber;}//done

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;}//done // from cashier

	public int getWaitingTime() {
		return waitingTime;}//done // from cashier

	public void setWaitingTime(int waitingTime) {
		this.waitingTime +=1;}//done // from restaurant 

	public Order getCustomerOrder() {
		return customerOrder;}//done // from restaurant

	public void setCustomerOrder(Order customerOrder) {
		this.customerOrder = customerOrder;}

	public double getCustomerRating() {
		return customerRating;}//done 

	public void setCustomerRating(double customerRating) {
		this.customerRating = customerRating;}//need more thinking // from server
	}
