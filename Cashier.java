import java.util.ArrayList;

public class Cashier extends Worker{

    private int normalOrderCounter = 1; // instance variable that save the order counter
    private int onlineOrderCounter = 1000; // instance variable that save the order counter for online orders


 public  void serveCustomer(Customers customersAtservice){ // method to get the order from the customer and give it a number
     setCustomerAndCustomerOrder(customersAtservice);
     if(customersAtservice.isOnlineOrder()) { // if the order is online set the order number from onlineOrderCounter variable 
         setOrderNumber(onlineOrderCounter);
         onlineOrderCounter++;
     }
     else { // if the order is not online set the order number from normalOrderCounter variable 
         setOrderNumber(normalOrderCounter);
         normalOrderCounter++; 
     }
}
 
 public  int[] chefTrigger(ArrayList<Customers> customersWhoOrdered){
	 int[] chefTriggers = new int[6];//{broast,spicyBroast,nuggets,spicyNuggets,jumboShrimp,sandwich}

	 for(Customers customers:customersWhoOrdered) {
	 Order order = customers.getCustomerOrder();
	 
		 int broast = order.getNumberOfBroastNormal();
		 int broastSpicy = order.getNumberOfBroastSpicy();
		   int nuggets = order.getNumberOfNuggetsNormal();
		   int nuggetsSpicy = order.getNumberOfNuggetsSpicy();
		   int sandwich = order.getNumberOfSandwich();
	       int jumboShrimp = order.getNumberOfJumboShrimp();

	       chefTriggers[0] += broast;
	       chefTriggers[1] += broastSpicy;
	       chefTriggers[2] += nuggets;
	       chefTriggers[3] += nuggetsSpicy;
	       chefTriggers[4] += jumboShrimp;
	       chefTriggers[5] += sandwich;
	 }
		 
	 
	 
	 return chefTriggers;  
  
}
   

}