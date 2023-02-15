public class test {
	public static void main(String[] args) {

		
	        Customers x = new Customers();
	        System.out.println(x.getCustomerRating());
	        System.out.println(x.getNumberOfOrders());
	        System.out.println(x.getOrderNumber());
	        System.out.println(x.getWaitingTime());
	        System.out.println(x.isLargeOrder());
	        System.out.println(x.isOnlineOrder());
	        System.out.println(x.isSpecialOrder());
	        System.out.println("\n comapre \n");
	        //System.out.println(x.getCustomerOrder());
	        System.out.println(x.getCustomerOrder().getOrderAmount());
	        System.out.println(x.getCustomerOrder().getMeals());
	        System.out.println(x.getCustomerOrder().getSnacks());
	        System.out.println(x.getCustomerOrder().getNumberOfBroast());
	        System.out.println(x.getCustomerOrder().getNumberOfJumboShrimp());
	        System.out.println(x.getCustomerOrder().getNumberOfNuggets());
	        System.out.println(x.getCustomerOrder().getNumberOfSandwich());
	        System.out.println(x.getCustomerOrder().getisItSpecial());

	    

	}
}