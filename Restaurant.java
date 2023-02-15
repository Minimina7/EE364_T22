import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Restaurant {
	


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int normalServerNumber = 1 ; // check
		int  onlineServerNumber = 1000; //check
		int onlinecashie = 1000;
		int normalcashie = 1;
		int numberofonlinecoustomer=0;
		double totalQualityAverage= 0;
		int totalWaitingTime = 0;
		int totalTimeInMinute=0;
		int coustomernum=0;
		int numberofcicks=1;
		int min = 0;
		
		// customers array
		ArrayList<Customers> cashierCustomers = new ArrayList<Customers>();
		ArrayList<Customers> serverCustomers = new ArrayList<Customers>();
		ArrayList<Customers> AllCustomer = new ArrayList<Customers>();
		
		System.out.println("entre cusAmu:  ");
		int cusAmu = input.nextInt();
		System.out.println("entre totmin:  ");
		int totmin = input.nextInt();
		
		for (int kk=0; kk<cusAmu;kk++) {
			Customers customers = new Customers();
			AllCustomer.add(customers);
			
		}
		//System.out.println(AllCustomer.size());
		for(int mm=0 ; mm<=(AllCustomer.size()-1);mm++) {
			Customers customer = AllCustomer.get(mm);
			//System.out.println(customer.getCustomerOrder().getisItSpecial());
		
			if (customer.isOnlineOrder()) {
				
				customer.setOrderNumber(onlinecashie);
			//System.out.println(customer.getCustomerOrder().getisItSpecial());
				serverCustomers.add(customer);
				//AllCustomer.remove(0);
				onlinecashie++;
			}
			else {
				//System.out.println("norm is added");
				   cashierCustomers.add(customer);
//                   customer.setOrderNumber(normalcashie);
					//System.out.println(customer.getCustomerOrder().getisItSpecial());
					//serverCustomers.add(customer);
					//AllCustomer.remove(mm);
					//normalcashie++;
				
				
			//	System.out.println(customer.getCustomerOrder().getisItSpecial());
//				cashierCustomers.add(customer);
//				AllCustomer.remove(mm);
				
		}
		}	
		//System.out.println(cashierCustomers.size());
		
		//////////////////////////////////////////////// befor looops//////////////////////////////////////////////////// 
	

		
        
		
		
		
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
		Server server1 = new Server("sserver1  ",serverCustomers, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server1);// add the server to the array
		Server server2 = new Server("sserver2  ",serverCustomers, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server2);// add the server to the array
		Server server3 = new Server("sserver3  ",serverCustomers, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server3);// add the server to the array
	
		// chefs creation
		BroastChef broastChef = new BroastChef();
		NuggetsChef nuggetsChef = new NuggetsChef();
		SandwichChef sandwichChef = new SandwichChef();
		ShrimpChef shrimpChef = new ShrimpChef();
		
		
		// bench initialization
		ArrayList<Food> startingBroast = broastChef.cookeNormal(8);
		for (Food singelBroast : startingBroast) {
			broast.addToBench((Broast) singelBroast);
		}
		
		ArrayList<Food> startingBroastSpicy = broastChef.cookeSpicy(8);
		for (Food singelBroast : startingBroastSpicy) {
			spicyBroast.addToBench((Broast) singelBroast);
		}
		
		ArrayList<Food> startingNuggets = nuggetsChef.cookeNormal(8);
		for (Food singelNuggets : startingNuggets) {
			nuggets.addToBench((Nuggets) singelNuggets);
		}
		
		ArrayList<Food> startingNuggetsSpicy = nuggetsChef.cookeSpicy(8);
		for (Food singelNuggets : startingNuggetsSpicy) {
			spicyNuggets.addToBench((Nuggets) singelNuggets);
		}
		
		ArrayList<Food> startingJumboShrimp = shrimpChef.cookeNormal(8);
		for (Food singelJumboShrimp : startingJumboShrimp) {
			jumboShrimp.addToBench((JumboShrimp) singelJumboShrimp);
		}
		
		ArrayList<Food> startingSandwichCN = sandwichChef.cookeChickenSandwichNormal(5);
		for (Food singelSandwich : startingSandwichCN) {
			sandwich.addToBench((Sandwich) singelSandwich);
		}
		
		ArrayList<Food> startingSandwichCS = sandwichChef.cookeChickenSandwichSpicy(5);
		for (Food singelSandwich : startingSandwichCS) {
			sandwich.addToBench((Sandwich) singelSandwich);
		}
		
		ArrayList<Food> startingSandwichFN = sandwichChef.cookeFishSandwichNormal(5);
		for (Food singelSandwich : startingSandwichFN) {
			sandwich.addToBench((Sandwich) singelSandwich);
		}
		
		ArrayList<Food> startingSandwichFS = sandwichChef.cookeFishSandwichSpicy(5);
		for (Food singelSandwich : startingSandwichFS) {
			sandwich.addToBench((Sandwich) singelSandwich);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		/////////////////////////////////////////////////// first loop /////////////////////////////////////////////////////////
		
		Cashier cashier = new Cashier();
		
		
		for(int H=0 ; H <= cashierCustomers.size()-1 ; H++) {
			Customers x = cashierCustomers.get(H);
			cashier.serveCustomer(x);
			serverCustomers.add(x);
			
		}
		
		for(Customers customers:serverCustomers ) {
			System.out.println("All cus"+ customers.getOrderNumber());
		}
		
		for(int z=totmin;z>0;z--) {
		//chefs Cashier
        
		
		
		
		
		
		
		
		
		
		
		///////////////////////////////////////////////////// second loop /////////////////////////////////////////////////////////

		// checkBeanch
		broastChef.checkBeanch(spicyBroast, broast, totalTimeInMinute);
		nuggetsChef.checkBeanch(spicyNuggets, nuggets, totalTimeInMinute);
		shrimpChef.checkBeanch(jumboShrimp, totalTimeInMinute);
		sandwichChef.checkBeanch(sandwich, totalTimeInMinute);
		
		
		
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
				sandwichChef.cookeSpecialSandwiches(sandwich,sandwiches, totalTimeInMinute); // ask the chef to make the sandwich
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
						//.out.println("time waite per cus: " + customerWaitingTime);
						//System.out.println("q avr per cus: " + foodQuality);
					//	System.out.println(customer.isOnlineOrder());

						// remove customer
					//	System.out.println(serverCustomers);
						serverCustomers.remove(i);
						System.out.println("Costomerkiked "+ costomerNumber+" total kikes "+numberofcicks++);
					//	System.out.println("cus = " + coustomernum++);
					//	System.out.println(serverCustomers);
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
		for (Broast meal : spicyBroast.getBench()) {
			meal.editQuality();
		}
		
		for (Nuggets meal : nuggets.getBench()) {
			meal.editQuality();
		}
		
		for (Nuggets meal : spicyNuggets.getBench()) {
			meal.editQuality();
		}
		
		for (Sandwich meal : sandwich.getBench()) {
			meal.editQuality();
		}
		
		for (JumboShrimp meal : jumboShrimp.getBench()) {
			meal.editQuality();
		}
		
		for (IceCream snacks : iceCream.getBench()) {
			snacks.editQuality();
		}
		
		for (Drinks Snacks : drinks.getBench()) {
			Snacks.editQuality();
		}
		
		for (Corn Snacks : corn.getBench()) {
			Snacks.editQuality();
		}
		
		//H++;
		totalTimeInMinute++;

		System.out.println("avr = " + totalQualityAverage/cusAmu);
		System.out.println("Time = " + totalWaitingTime);
//		System.out.println("cus = " + coustomernum++);
		System.out.println(" ====================Benches===================== ");
		System.out.println("broast = " + broast.foodAmuont());
		System.out.println("spicyBroast = " + spicyBroast.foodAmuont());
		System.out.println("nuggets = " + nuggets.foodAmuont());
		System.out.println("spicyNuggets = " + spicyNuggets.foodAmuont());
		System.out.println("sandwich = " + sandwich.foodAmuont());
		System.out.println("jumboShrimp = " + jumboShrimp.foodAmuont());
		System.out.println(" =============================================== ");
		System.out.println("((((((((((((((((((((((((((((((((((( "+ totalTimeInMinute + " )))))))))))))))))))))))))))))))))))");
//		System.out.println("corn = " + corn.foodAmuont());
//		System.out.println("drinks = " + drinks.foodAmuont());
//		System.out.println("nsn = " + normalServerNumber);
//		System.out.println("osn = " + onlineServerNumber);
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
// s
// public void setOnlineServerNumber(int onlineServerNumber) {
//	 this.onlineServerNumber = onlineServerNumber;
// }
 }
