
public class Customers {
	private boolean specialOrder; // detirmine if the customer have special order or not 
	private boolean largeOrder; // detirmine if the customer have large order or not 
	private boolean onlineOrder; // detirmine if the customer order online or not
	private int numberOfOrders; // detirmine how many meal the customer want // con
	private int orderNumber;// show the order number // given by cashier
	private int waitingTime;// show how much time the customer wait // from restorant 
	private Order customerOrder; // the order of the customer
	private double customerRating; // the rating of the customer related to the food quality 

	
	public Customers() {
		// craete order arraymeal array snacks //Order amount
		if 
	}
	

	
	
	
	
	
	
	
	
	
	


	public boolean isSpecialOrder() {
		return specialOrder;}//done

	public void setSpecialOrder() {
		specialOrder = true;}//done

	public boolean isLargeOrder() {
		return largeOrder;}//done

	public void setLargeOrder(int numberOfOrder) {
		if (numberOfOrder>10)
			largeOrder = true;}//check number

	public boolean isOnlineOrder() {
		return onlineOrder;}//done

	public void setOnlineOrder() {
		// random method needed
		onlineOrder = onlineOrder;}

	public int getNumberOfOrders() {
		return numberOfOrders;}//done

	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;}//done

	public int getOrderNumber() {
		return orderNumber;}//done

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;}//done

	public int getWaitingTime() {
		return waitingTime;}//done

	public void setWaitingTime(int waitingTime) {
		this.waitingTime +=1;}//done

	public Order getCustomerOrder() {
		return customerOrder;}//done

	public void setCustomerOrder(Order customerOrder) {
		this.customerOrder = customerOrder;}

	public double getCustomerRating() {
		return customerRating;}//done 

	public void setCustomerRating(double customerRating) {
		customerRating = customerRating;}//need more thinking
	}
