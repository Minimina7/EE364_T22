import java.util.ArrayList;
import java.util.Random;
public class Restaurant {
	


	public static void main(String[] args) {

		
		int normalServerNumber = 0 ; // check
		int  onlineServerNumber = 1000; //check
		double totalQualityAverage= 0;
		int totalWaitingTime = 0;
		
		// customers array
		ArrayList<Customers> cashierCustomers = new ArrayList<Customers>();
		ArrayList<Customers> serverCustomers = new ArrayList<Customers>();

		// bench creation
		Bench<Broast> broast = new Bench<Broast>();
		Bench<Broast> spicyBroast = new Bench<Broast>();
		Bench<Nuggets> nuggets = new Bench<Nuggets>();
		Bench<Nuggets> spicyNuggets = new Bench<Nuggets>();
		Bench<JumboShrimp> jumboShrimp = new Bench<JumboShrimp>();
		Bench<Sandwich> sandwich = new Bench<Sandwich>();
		Bench<Corn> corn = new Bench<Corn>();
		Bench<Drinks> drinks = new Bench<Drinks>();
		Bench<IceCream> iceCream = new Bench<IceCream>();
		
		// array of servers
		ArrayList<Server> servers = new ArrayList<Server>();
		
		// Servers Creation
		Server server1 = new Server(serverCustomers, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server1);// add the server to the array
		Server server2 = new Server(serverCustomers, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server2);// add the server to the array
		Server server3 = new Server(serverCustomers, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server3);// add the server to the array
		
		// make the server work
		for (Server server: servers ) {
			
					
			server.takeNextOrder(onlineServerNumber, normalServerNumber);
			if (server.isServerTookOnlineNumber()) {
				onlineServerNumber+=1;
			}
			if (server.isServerTookNormalNumber()) {
				normalServerNumber+=1;
			}
			if (server.isThereSpecialOrder()) { // server need a sandwich not in the sandwiches bench
				ArrayList<Sandwich> sandwiches = server.getSpecialSandwich();
				// chief code  [ sadwiches]. // ask the chef to make the sandwich
			}
			
			if (server.isOrderIsReady()) { // the server prepared the order
				
				// bring customer information from the server
				double foodQuality = server.getQuality();
				ArrayList<Food> costumerOrder = server.getSubmittedOrder();
				int costomerNumber = server.getCustomerOrderNumber();
				int customerWaitingTime;

				// deal with customer
				for (int i = 0; i <= (serverCustomers.size() - 1); i++) {
					Customers customer = serverCustomers.get(i);
					if (customer.getOrderNumber() == costomerNumber) {
						customer.setWaitingTime();
						customer.setReceivedOrder(costumerOrder);
						customer.setCustomerRating(foodQuality);
						customerWaitingTime = customer.getWaitingTime();

						// remove customer
						serverCustomers.remove(i);

						// gather information
						totalQualityAverage += foodQuality;
						totalWaitingTime += customerWaitingTime;

						// brake the loop
						break;
					}

				}
			}

		}
		
		// time effect

		// customers
		for (Customers customer : cashierCustomers) {
			customer.setWaitingTime();
		}

		for (Customers customer : serverCustomers) {
			customer.setWaitingTime();
		}
		
		// Food
		
		for (Broast meal : broast.getBench()) {
			meal.editQuality();
		}
		for (Broast meal : broast.getBench()) {
			meal.editQuality();
		}
		
		
	}


 public static int getRandom(int firstNumber, int secondNumber) {
	 Random randomNumber = new Random();
	 int random = randomNumber.nextInt(secondNumber)+ firstNumber;
	 return random;}
 
 
// public int getOnlineorder() {
//	 return onlineorder;
// }
// 
// 
// public void setOnlineorder(int onlineorder) {
//	 this.onlineorder = onlineorder;
// }
// 
// 
// public int getCashierorder() {
//	 return cashierorder;
// }
// 
// 
// public void setCashierorder(int cashierorder) {
//	 this.cashierorder = cashierorder;
// }
// 
// 
// public int getServerNumber() {
//	 return serverNumber;
// }
// 
// 
// public void setServerNumber(int serverNumber) {
//	 this.serverNumber = serverNumber;
// }
// 
// 
// public int getOnlineServerNumber() {
//	 return onlineServerNumber;
// }
// 
// 
// public void setOnlineServerNumber(int onlineServerNumber) {
//	 this.onlineServerNumber = onlineServerNumber;
// }
 }
