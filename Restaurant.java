import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Restaurant {
	public static ArrayList<Integer> customersHourlyWaitingTimeAverage = new ArrayList<Integer>();
	public static ArrayList<Double> customersHourlyQualityAverag = new ArrayList<Double>();
	public static ArrayList<Customers> allCustomersServed = new ArrayList<Customers>();
	public static void main(String[] args) {
		while (true) {
////////////////////////////////////////////////////////  before loop  ///////////////////////////////////////////////////////////

		// variables
		int onlinCashier = 1000;
		int totalTimeInMinute=0;
		int normalServerNumber = 1 ;
		int  onlineServerNumber = 1000; 
		int numberOfServedCustomers =0; 
		double totalQualityAverage= 0;
		int totalWaitingTime = 0;
		int numberOfCustomersInThisMinute =0;
		int existingCustomers = 0;
		int serverWorking = 0;
		int numberOfBenchRefreshes = 0;
		double hourlyQualityAverage=0;
		int hourlyWaitingTimeAverage=0;
		int spicyBroastAmount = 0;
		int broastAmount = 0;
		int spicyNuggetsAmount = 0;
		int nuggetsAmount = 0;
		int jumboShrimAmount = 0;
		int sandwichAmount = 0;
		boolean slowRunHours;
		boolean slowRunMinutes;
		Scanner input = new Scanner(System.in); 
		
		

		
		
		
		System.out.println("Note:\nThe restaurant is not designed to handle more than 650 customers");
		System.out.println("For more accuracy, we recommend the difference to be at least 50");
		System.out.println("Enter the expected range of customers\n");

		// bring the sum of range bounds
		int[] rangeBounds = getNumbers();
		int sumOfRangeBound = rangeBounds[0] + rangeBounds[1]; // lower bound [0], upper bound [1]

		// determine the total number of customers that will enter the Restaurant [not
		// accurate]
		int totalNumberofCustomers = 0;

		// divided by 2 to get the average, 16 to get the average per Hour
		double coustomerAvreage = (((double) sumOfRangeBound) / (2 * 16));

		// determine weight of rush hour
		double[] timeprobability = { 0.3, 0.6, 0.8, 1.3, 1.7, 1.0, 1.1, 1.4, 0.8, 0.5, 0.6, 0.9, 1.1, 1.7, 1.2, 1.0 };

		// determine number of customers in every Hour for all the 16 hour.
		int[] numberOfCustomerPerHour = new int[16];

		// sorting number of customers inside numberOfCustomerPerHour array
		for (int i = 0; i <= timeprobability.length - 1; i++) {
			double timeProprobability = timeprobability[i];
			int customersNumber = (int) Math.round((coustomerAvreage * timeProprobability));
			totalNumberofCustomers += customersNumber; // for test
			numberOfCustomerPerHour[i] = customersNumber;

		}

		// customers array
		ArrayList<Customers> people = new ArrayList<Customers>();
		ArrayList<Customers> cashierCustomers = new ArrayList<Customers>();
		ArrayList<Customers> serverCustomers = new ArrayList<Customers>();
		ArrayList<Customers> servedCustomers = new ArrayList<Customers>();
		ArrayList<Customers> servedCustomersThisHour = new ArrayList<Customers>();
		// create Customers [upper bound]
		for (int i = 1; i <= rangeBounds[1]; i++) {
			Customers customers = new Customers();
			people.add(customers);
		}

		// cashier creation
		Cashier cashier = new Cashier();
		
		// chefs creation
		BroastChef broastChef = new BroastChef();
		NuggetsChef nuggetsChef = new NuggetsChef();
		SandwichChef sandwichChef = new SandwichChef();
		ShrimpChef shrimpChef = new ShrimpChef();
		
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
		Server server1 = new Server("sserver1  ", serverCustomers, broast, spicyBroast, nuggets, spicyNuggets,
				jumboShrimp, sandwich, corn, drinks, iceCream);
		servers.add(server1);// add the server to the array
		Server server2 = new Server("sserver2  ", serverCustomers, broast, spicyBroast, nuggets, spicyNuggets,
				jumboShrimp, sandwich, corn, drinks, iceCream);
		servers.add(server2);// add the server to the array
		Server server3 = new Server("sserver3  ", serverCustomers, broast, spicyBroast, nuggets, spicyNuggets,
				jumboShrimp, sandwich, corn, drinks, iceCream);
		servers.add(server3);// add the server to the array



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

		/////////////////////////////////////////////////////// main loop [Hour]
		/////////////////////////////////////////////////////// ////////////////////////////////////////////////

		
		//question 1 to determine how fast the code will run
		System.out.println("Do you want to be asked questions after each hour?");
		while (true) {
		System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
		String answer = input.next();
		if(answer.equals("Yes")) {
			slowRunHours =true;
			break;
		}
		else if (answer.equals("No")) {
			slowRunHours =false;
			break;	
		}
		else
			System.out.println("Unaccepted response!!!");

		}
		
		//question 2 to determine how fast the code will run
		System.out.println("Do you want to see everything happening in each minute?");
		while (true) {
		System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
		String answer = input.next();
		if(answer.equals("Yes")) {
			slowRunMinutes =true;
			break;
		}
		else if (answer.equals("No")) {
			slowRunMinutes =false;
			break;	
		}
		else
			System.out.println("Unaccepted response!!!");

		}
		
		if(slowRunHours && !(slowRunMinutes)){
			System.out.println("WELCOME TO THE RESTAURANT");
		}
		
		// Hour loop
		for (int Hour = 1; Hour <= 17; Hour++) {
//			System.out.println("[[[[[[[[[[[[[ Hour: " + (Hour) + " ]]]]]]]]]]]]\n");
			 hourlyQualityAverage=0;
			 hourlyWaitingTimeAverage=0;
			int numberOfCustomersInThisHour =0;
			if (Hour <= 16) {
			numberOfCustomersInThisHour = (numberOfCustomerPerHour[Hour - 1]);
//			System.out.println("Hour: " + Hour + "\nnumber of customer: " + numberOfCustomersInThisHour);
			}
			else {
				if(!(slowRunHours) && !(slowRunMinutes)) {
					
				}
				else {
					
					System.out.println(
							"\n-----------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("------------------------------------------------------- THE RESTAURANT IS ABOUT TO CLOSE ------------------------------------------------------");
					System.out.println("---------------------------------------------------- NO CUSTOMERS WILL ENTER THE RESTAURANT ---------------------------------------------------");
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------------");
					
				}
					
			}
			
			if(slowRunMinutes) {
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("                                                              Hour [" + Hour
						+ "]                                                              ");
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");

				System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%n", "|  Minute ", " |  New Customers  ", "|", "  Cashier Queue  ",
						"|", "   Working Chiefs  ", "|", "  Ready Meals  ", "|", "  Working servers  ", "|",
						"   Server Queue  ","|", "  Served Customers ","|");

				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				
			}
			
			///////////////////////////////////////////////////// inner loop [minute]
			///////////////////////////////////////////////////// //////////////////////////////////////////////

			// minute loop
			for (int min = 0; min < 60; min++) {
//				System.out.println("\\\\\\\\\\\\\\\\ min:  " + min + " ////////\n");

				if (Hour <= 16) {
					// random number to determine if customers will come or not
					double randomNumber = getRandom(0, 100);
//					System.out.println("((((((((((((((( ramdom: " + randomNumber + "))))))))))))))))))\n");

					// calculate customers enter probability
					double EnterProbability = ((double) numberOfCustomersInThisHour / (60 - min)) * 100;
//					System.out.println(EnterProbability);
					numberOfCustomersInThisMinute = 0;
					
					if (randomNumber <= EnterProbability) {						
						if (randomNumber <= EnterProbability * 0.80) {
//							System.out.println("\n--------------probability------------");
//							System.out.println(randomNumber);
//							System.out.print(0 + " - ");
//							System.out.println(EnterProbability * 0.80);
//							System.out.println("one custmer entered\n");
//							System.out.println("--------------probability------------\n");
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;

						} else if (randomNumber <= EnterProbability * 0.95) {
//							System.out.println("\n--------------probability------------");
//							System.out.println(randomNumber);
//							System.out.print(EnterProbability * 0.80 + " - ");
//							System.out.println(EnterProbability * 0.95);
//							System.out.println("two custmer entered\n");
//							System.out.println("--------------probability------------\n");
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
//							System.out.println("cus enter" + ++cus);
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
						} else {
//							System.out.println("\n--------------probability------------");
//							System.out.println(randomNumber);
//							System.out.print(EnterProbability * 0.95 + " - ");
//							System.out.println(EnterProbability);
//							System.out.println("three custmer entered\n");
//							System.out.println("--------------probability------------\n");
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
						}
					}
				}
				
				
//				System.out.println("\nserveronly number in the resturant "+(serverCustomers.size()));
//				System.out.println("cashironly number in the resturant "+(+cashierCustomers.size()));
//				System.out.println("total number in the resturant "+(serverCustomers.size()+cashierCustomers.size())+"\n");
				
				// chef check Bench 
				
				//counters
				
				
				int chefsWorking = 0;
				
				spicyBroastAmount = spicyBroast.foodAmuont();
				 broastAmount = broast.foodAmuont();
				broastChef.checkBeanch(spicyBroast, broast, totalTimeInMinute);
				if(broastChef.isChefCooking()) {
					chefsWorking++;}
				 
				spicyNuggetsAmount = spicyNuggets.foodAmuont();
				nuggetsAmount = nuggets.foodAmuont();
				nuggetsChef.checkBeanch(spicyNuggets, nuggets, totalTimeInMinute);
				if(nuggetsChef.isChefCooking()) {
					chefsWorking++;}
				
				jumboShrimAmount = jumboShrimp.foodAmuont();
				shrimpChef.checkBeanch(jumboShrimp, totalTimeInMinute);
				if(shrimpChef.isChefCooking()) {
					chefsWorking++;}
				
				sandwichAmount = sandwich.foodAmuont();
				sandwichChef.checkBeanch(sandwich, totalTimeInMinute);
				if(sandwichChef.isChefCooking()) {
					chefsWorking++;}
				
				if(spicyBroast.foodAmuont()>spicyBroastAmount)
					numberOfBenchRefreshes++;
				if(broast.foodAmuont()>broastAmount)
					numberOfBenchRefreshes++;
				if(spicyNuggets.foodAmuont()>spicyNuggetsAmount)
					numberOfBenchRefreshes++;
				if(nuggets.foodAmuont()>nuggetsAmount)
					numberOfBenchRefreshes++;
				if(jumboShrimp.foodAmuont()>jumboShrimAmount)
					numberOfBenchRefreshes++;
				if(sandwich.foodAmuont()>sandwichAmount)
					numberOfBenchRefreshes++;
				
				
				
				
				
				existingCustomers =0;
//				serverWorking = 0;
				// make the server work
				for (Server server: servers ) {
//					System.out.println("\nnormalServerNumber  :"+normalServerNumber);	
					server.takeNextOrder(onlineServerNumber, normalServerNumber);
					if (server.isServerTookOnlineNumber()) {
						serverWorking++;
						onlineServerNumber+=1;
//						System.out.println("\n haaaaaahy tra srlha incrment onlyn");	
					}
					if (server.isServerTookNormalNumber()) {
						serverWorking++;
						normalServerNumber+=1;
//						System.out.println("\n haaaaaahy tra srlha incrment normal");
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
						int currentServedcustomer = numberOfServedCustomers;
						
						
						// deal with customer
						for (int i = 0; i <= (serverCustomers.size() - 1); i++) {
							Customers customer = serverCustomers.get(i);
							if (customer.getOrderNumber() == costomerNumber) {
								customer.setWaitingTime();
								customer.setReceivedOrder(costumerOrder);
								customer.setCustomerRating(foodQuality);
								customerWaitingTime = customer.getWaitingTime();


								// remove customer
								servedCustomers.add(customer);
								servedCustomersThisHour.add(customer);
								serverCustomers.remove(i);								
								serverWorking--;
								existingCustomers = existingCustomers+1;
								
								//System.out.println("Costomerkiked"+i+ "     "+ costomerNumber+"/////////////////////////////////"+ ++numberOfServedCustomers);// not importanyt
								
								// gather information
								totalQualityAverage += foodQuality;
								totalWaitingTime += customerWaitingTime;
								 hourlyQualityAverage+=foodQuality;
								 hourlyWaitingTimeAverage+=customerWaitingTime;

								// brake the loop
								break;
							}

						}
						
					}

				}
				
				// make cashier work
				if (!(cashierCustomers.isEmpty())) {
					Customers cachierCustomer = cashierCustomers.get(0);
					cashier.serveCustomer(cachierCustomer);
					serverCustomers.add(cachierCustomer);
					cashierCustomers.remove(0);
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
				
				totalTimeInMinute++;
				
//				System.out.println("avr = " + ((numberOfServedCustomers > 0) ? totalQualityAverage/numberOfServedCustomers : 0));
//				System.out.println("Time = " + ((numberOfServedCustomers> 0) ? totalWaitingTime/numberOfServedCustomers : 0));
//				System.out.println(" ====================Benches===================== ");
//				System.out.println("broast = " + broast.foodAmuont());
//				System.out.println("spicyBroast = " + spicyBroast.foodAmuont());
//				System.out.println("nuggets = " + nuggets.foodAmuont());
//				System.out.println("spicyNuggets = " + spicyNuggets.foodAmuont());
//				System.out.println("sandwich = " + sandwich.foodAmuont());
//				System.out.println("jumboShrimp = " + jumboShrimp.foodAmuont());
//				System.out.println(" =============================================== ");
//				System.out.println("((((((((((((((((((((((((((((((((((( "+ totalTimeInMinute + " )))))))))))))))))))))))))))))))))))");
//				System.out.println("in the rstrunt now"+serverCustomers.size());
				int totalMeals = broast.foodAmuont() +spicyBroast.foodAmuont()+nuggets.foodAmuont()+spicyNuggets.foodAmuont()+sandwich.foodAmuont()+jumboShrimp.foodAmuont();				
				
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				

				//System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			 if(slowRunMinutes) {
				 System.out.printf(
						 "|%-4s%2d%4s%s" + "%-8s%1d%8s%s%" + "-7s%3d%7s%s%" + "-8s%1d%s%8s%s" + "%-6s%3d%6s%s"
								+ "%-8s%1d%s%8s%s" + "%-7s%3d%7s%s" + "%-9s%1d%9s%s%n",
						"", (min+1), "", "|", "", numberOfCustomersInThisMinute, "", "|", "", cashierCustomers.size(), "", "|", "", chefsWorking, "/4", "", "|", "", totalMeals, "", "|", "",(serverWorking+existingCustomers), "/3",
						"", "|", "", serverCustomers.size(), "", "|", "", existingCustomers, "", "|");
			
			
}					
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				
				
			} // end minute loop
			
	//servedCustomers		
	//servedCustomersThisHour		
int[] arrayOfAmount = readOrder(servedCustomers); //{broast,nuggets,jumboShrimp,sandwich,drinks,corn,iceCream}
int[] orderTypes = divideTheOrder(servedCustomers);//{normal ,special ,large,online}

int numberOfCustomersServedAtThisHour = servedCustomersThisHour.size();
int totalNumberOfCustomersServed = servedCustomers.size();
if(numberOfCustomersServedAtThisHour!=0) {
customersHourlyWaitingTimeAverage.add(hourlyWaitingTimeAverage/numberOfCustomersServedAtThisHour);
customersHourlyQualityAverag.add(hourlyQualityAverage/numberOfCustomersServedAtThisHour);
}
// deep copy
allCustomersServed.clear();
for(Customers customers: servedCustomers) {
	allCustomersServed.add(customers);
}

/*
 * 
 * hourlyQualityAverage
 * hourlyWaitingTimeAverage
 * totalQualityAverage 
 * totalWaitingTime 
 * 
 */

// qualti this and qualty all
//time this and time all
System.out.print("\n");

if(slowRunHours){
//Q1
if(Hour == 1)
System.out.println("Do you want "+Hour+" hour summary");	
else
	System.out.println("Do you want "+Hour+" hours summary");

while (true) {
System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
String answer = input.next();
if(answer.equals("Yes")) {

// main block
	System.out.println(
			"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
	System.out.println("--------------------------------------------------------------- HOUR-|"+Hour+ "|-SUMMARY --------------------------------------------------------------");
	
	System.out.println(
			"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");
	System.out.println("                                                                FOOD STATISTICS                                                                ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.printf("%18s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%n","", "|  Bench Refills  ", "|  Broasts  ", "|", "  Nuggets  ",
			"|", "  Jumbo Shrimps  ", "|", "  Sandwichs  ", "|", "   Drinks  ", "|",
			"  Corns  ","|", "  Ice Cream  ","|");
	
	System.out.printf(
			 "%18s|%-7s%3d%7s%s" + "%-4s%3d%4s%s%" + "-4s%3d%4s%s%" + "-7s%3d%7s%s" + "%-5s%3d%5s%s"
					+ "%-4s%3d%4s%s" + "%-3s%3d%3s%s" + "%-5s%3d%5s%s%n",
			"","", numberOfBenchRefreshes, "", "|", "", arrayOfAmount[0], "", "|", "",arrayOfAmount[1] , "", "|", "", arrayOfAmount[2], "", "|", "",arrayOfAmount[3] , "", "|", "",arrayOfAmount[4],
			"", "|", "", arrayOfAmount[5], "", "|", "", arrayOfAmount[6], "", "|");

	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------\n");

	System.out.println("                                                           CUSTOMERS TYPES STATISTICS                                                          ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.printf("%49s%s%s%s%s%s%s%s%n","", "|  Online   ", "|  Normal   ", "|", "  Large  ",
			"|", "  Special  ", "|");
	
	System.out.printf(
			 "%49s|%-4s%3d%4s%s" + "%-4s%3d%4s%s%" + "-3s%3d%3s%s%" + "-4s%3d%4s%s%n" ,
			"","", orderTypes[3], "", "|", "", orderTypes[0], "", "|", "",orderTypes[2] , "", "|", "", orderTypes[1], "", "|");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------\n");


if(numberOfCustomersServedAtThisHour==0) {
		
		System.out.println("                                                               GENERAL STATISTICS                                                              ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.printf("%55s%s%n","","No customesr Served in this Hour");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------\n");
		
	
	}
	else {
		System.out.println("                                                               GENERAL STATISTICS                                                              ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%38s%s%s%s%s%s%n","", "|   Served Customers  ", "|  Waiting Time Average   ", "|", "  Quality Average  ",
				"|");
		System.out.printf("%38s|%-9s%3d%9s%s" + "%-11s%3d%11s%s%" + "-7s%3.2f%7s%s%n", "", "", numberOfCustomersServedAtThisHour, "",
				"|", "", hourlyWaitingTimeAverage/numberOfCustomersServedAtThisHour, "", "|", "", hourlyQualityAverage/numberOfCustomersServedAtThisHour, "", "|");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------\n");

	}

if(totalNumberOfCustomersServed==0) {
	
	System.out.println("                                                             CUMULATIVE STATISTICS                                                             ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.printf("%55s%s%n","","No customesr Served in this Hour");

}
else {
	System.out.println("                                                             CUMULATIVE STATISTICS                                                             ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	System.out.printf("%38s%s%s%s%s%s%n","", "|   Served Customers  ", "|  Waiting Time Average   ", "|", "  Quality Average  ",
			"|");
	System.out.printf("%38s|%-9s%3d%9s%s" + "%-11s%3d%11s%s%" + "-7s%3.2f%7s%s%n", "", "", totalNumberOfCustomersServed, "",
			"|", "", totalWaitingTime/totalNumberOfCustomersServed, "", "|", "", totalQualityAverage/totalNumberOfCustomersServed, "", "|");

}
	
	
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------\n");
	
	System.out.println(
			"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.println(
			"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");

	break;
}
else if (answer.equals("No")) {
	break;	
}
else 
	System.out.println("Unaccepted response!!!");

}


//Q2
if(numberOfCustomersServedAtThisHour!=0) {
System.out.println("Do you want to check on one of the customers that left the restaurant at this hour?");
while (true) {
System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
String answer = input.next();
if(answer.equals("Yes")) {

// main block introduction
	boolean checkIfTheCustomerIsTaken = false;
	while (true) {	
	for(int i=0;i<=servedCustomersThisHour.size()-1;i++) {
		Customers customers = servedCustomersThisHour.get(i);
		System.out.print("("+customers.getOrderNumber()+") ");
	}
	System.out.println("\n");
	
	System.out.print("Choose one of the customers: ");
	String customerNumberEntered = input.next();
	
	for(int i=0;i<=servedCustomersThisHour.size()-1;i++) {
		Customers customers = servedCustomersThisHour.get(i);
		int servedCustomerNumber =customers.getOrderNumber();
		String integerIntoString = String.valueOf(servedCustomerNumber);
		if(integerIntoString.equals(customerNumberEntered)) {
			 checkIfTheCustomerIsTaken = true;
			// main block:
			 
			 Order order = customers.getCustomerOrder();
			 System.out.print("\n");
			 System.out.println("Customers number: "+customers.getOrderNumber());
			 
			 
			 System.out.print("Type: ");
			 if(customers.isSpecialOrder())
				 System.out.print("Special ");
			 else
				 System.out.print("Normal "); 
			 
			 if(customers.isLargeOrder())
				 System.out.print("Large ");
			 
			 if(customers.isOnlineOrder())
				 System.out.print("Online ");
			 
			 System.out.print("\n");
			 
			 
			 //////////////////////////////////////
			 System.out.println("Waiting time: "+customers.getWaitingTime());//???????????
			 System.out.println("order quality: "+customers.getCustomerRating());//??????????
			 //////////////////////////////////////
			 System.out.print("\n");
			 
			 
				System.out.println("Would you like to see his order?");
				while (true) {
				System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
				String answer2 = input.next();
				if(answer2.equals("Yes")) {
					
					System.out.println("\n|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|");
					System.out.println("|                                           |");
					System.out.println("|            - CUSTOMER ORDER -             |");
					System.out.println("|       -----------------------------       |");
					System.out.println("|                                           |");
					System.out.printf("|%-9s%s%3d%11s%n",""," Broast         :    ",order.getNumberOfBroast(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Broast Normal  :    ",order.getNumberOfBroastNormal(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Broast Spicy   :    ",order.getNumberOfBroastSpicy(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Nuggets        :    ",order.getNumberOfNuggets(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Nuggets Normal :    ",order.getNumberOfNuggetsNormal(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Nuggets Spicy  :    ",order.getNumberOfNuggetsSpicy(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Jumbo Shrimps  :    ",order.getNumberOfJumboShrimp(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Sandwichs      :    ",order.getNumberOfSandwich(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Corns          :    ",order.getNumberOfCorn(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Drinks         :    ",order.getNumberOfDrinks(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Ice Cream      :    ",order.getNumberOfIcecream(),"|");
					System.out.println("|                                           |");
					System.out.println("|       -----------------------------       |");
					System.out.println("|            - CUSTOMER ORDER -             |");
					System.out.println("|                                           |");
					System.out.println("|-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-|\n");
				 
					
				 break;
				}
				else if (answer2.equals("No")) {
					break;	
				}
				else
					System.out.println("Unaccepted response!!!");

				}

			 
			break;	
		}
	}
	if(checkIfTheCustomerIsTaken)
	break;
	System.out.println("Unaccepted response!!!");
	}
break;}
else if (answer.equals("No")) {
	break;	
}
else
	System.out.println("Unaccepted response!!!");
}
}

//Q3
System.out.println("do you want to check on one of the customers who visited the restaurant?");
while (true) {
System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
String answer = input.next();
if(answer.equals("Yes")) {

// main block introduction
	boolean checkIfTheCustomerIsTaken = false;
	while (true) {	
		System.out.println("These are the customers who lifts the restaurant recently");	
	for(int i=0;i<=servedCustomersThisHour.size()-1;i++) {
		Customers customers = servedCustomersThisHour.get(i);
		System.out.print("("+customers.getOrderNumber()+") ");
	}
	System.out.println("\n");
	System.out.println("The number you will choose must be equal to one of them or less");
	System.out.print("Choose one of the customers: ");
	String customerNumberEntered = input.next();
	
	for(int i=0;i<=servedCustomers.size()-1;i++) {
		Customers customers = servedCustomers.get(i);
		int servedCustomerNumber =customers.getOrderNumber();
		String integerIntoString = String.valueOf(servedCustomerNumber);
		if(integerIntoString.equals(customerNumberEntered)) {
			 checkIfTheCustomerIsTaken = true;
			// main block:
			 Order order = customers.getCustomerOrder();
			 System.out.println("Customers number: "+customers.getOrderNumber());
			 
			 
			 System.out.print("Type: ");
			 if(customers.isSpecialOrder())
				 System.out.print("Special ");
			 else
				 System.out.print("Normal "); 
			 
			 if(customers.isLargeOrder())
				 System.out.print("Large ");
			 
			 if(customers.isOnlineOrder())
				 System.out.print("Online ");
			 
			 System.out.println("\n");
			 
                 //////////////////////////////////////
				System.out.println("Waiting time: " + customers.getWaitingTime());// ???????????
				System.out.println("order quality: " + customers.getCustomerRating());// ??????????
                 //////////////////////////////////////

				System.out.println("Would you like to see his order?");
				while (true) {
				System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
				String answer3 = input.next();
				if(answer3.equals("Yes")) {
					
					System.out.println("\n|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|");
					System.out.println("|                                           |");
					System.out.println("|            - CUSTOMER ORDER -             |");
					System.out.println("|       -----------------------------       |");
					System.out.println("|                                           |");
					System.out.printf("|%-9s%s%3d%11s%n",""," Broast         :    ",order.getNumberOfBroast(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Broast Normal  :    ",order.getNumberOfBroastNormal(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Broast Spicy   :    ",order.getNumberOfBroastSpicy(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Nuggets        :    ",order.getNumberOfNuggets(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Nuggets Normal :    ",order.getNumberOfNuggetsNormal(),"|");
			        System.out.printf("|%-9s%s%3d%11s%n",""," Nuggets Spicy  :    ",order.getNumberOfNuggetsSpicy(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Jumbo Shrimps  :    ",order.getNumberOfJumboShrimp(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Sandwichs      :    ",order.getNumberOfSandwich(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Corns          :    ",order.getNumberOfCorn(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Drinks         :    ",order.getNumberOfDrinks(),"|");
					System.out.printf("|%-9s%s%3d%11s%n",""," Ice Cream      :    ",order.getNumberOfIcecream(),"|");
					System.out.println("|                                           |");
					System.out.println("|       -----------------------------       |");
					System.out.println("|            - CUSTOMER ORDER -             |");
					System.out.println("|                                           |");
					System.out.println("|-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-|\n");
			 					
				 break;
				}
				else if (answer3.equals("No")) {
					break;	
				}
				else
					System.out.println("Unaccepted response!!!");

				}
			 
			// LastQ
			 System.out.println("Are you done?");
			 while (true) {
			 System.out.println("Enter "+ "\"Yes\""+" to continue: ");
			 String answer2 = input.next();
			 if(answer2.equals("Yes")) {
			 	break;
			 }
			 else
			 	System.out.println("Unaccepted response!!!");

			 }
			 ///////////////////////////////////////////////
			break;	
		}
	}
	if(checkIfTheCustomerIsTaken)
	break;
	System.out.println("Unaccepted response!!!");
	}
break;}
else if (answer.equals("No")) {
	break;	
}
else
	System.out.println("Unaccepted response!!!");

}

		}

servedCustomersThisHour.clear();



		} //end Hour loop
		// last qualty lasttime good or bad
		System.out.println(
				"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("----------------------------------------------------------------- FINAL SUMMARY ---------------------------------------------------------------");
		System.out.println(
				"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");
		System.out.println("                                                             CUMULATIVE STATISTICS                                                             ");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.printf("%38s%s%s%s%s%s%n","", "|   Served Customers  ", "|  Waiting Time Average   ", "|", "  Quality Average  ",
				"|");

		System.out.printf("%38s|%-9s%3d%9s%s" + "%-11s%3d%11s%s%" + "-7s%3.2f%7s%s%n", "", "", servedCustomers.size(), "",
				"|", "", totalWaitingTime/servedCustomers.size(), "", "|", "", totalQualityAverage/servedCustomers.size(), "", "|");

		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------\n");
		
		System.out.println(
				"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println(
				"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");
		System.out.println("Do you want to start another day?");
		while (true) {
			System.out.println("Enter "+ "\"Yes\""+" or " + "\"No\": ");
			String answer = input.next();
			if(answer.equals("Yes")) {
				System.out.println("------------------Starting A New Day-----------------------");
				break;
			}   
			else if (answer.equals("No")) {
				System.out.println("Exiting the program");
				while (true) {}	
			}
			else
				System.out.println("Unaccepted response!!!");

			}

	  }//end bigWhileLoop
	} //end main method

	// sort one customer to its destination inside the Restaurant
	public static int sortCustomes(ArrayList<Customers> people, ArrayList<Customers> serverCustomers,
			ArrayList<Customers> cashierCustomers, int onlinCashier) {
		if (!(people.isEmpty())) {
			Customers customer = people.get(0);
			if (customer.isOnlineOrder()) {
				customer.setOrderNumber(onlinCashier);
				serverCustomers.add(customer);
				people.remove(0);
				onlinCashier++;
			} else {
				cashierCustomers.add(customer);
				people.remove(0);
			}
		}
		return onlinCashier;
	}

	// making sure the user entered valid numbers.
	private static int[] getNumbers() {

		Scanner input = new Scanner(System.in);
		int numberOfEntered1 = 0;
		int numberOfEntered2 = 0;
		// to keep asking the user to enter numbers until a valid number is entered
		while (true) {
			// in order to export an exception
			try {

				// Initialize the first number
				System.out.print("Enter the lowest number you anticipate receiving:  ");
				numberOfEntered1 = input.nextInt();
				if (numberOfEntered1 < 0)
					throw new Exception("Unrealistic value...!\nvalue must be greater than zero");
				if (650 < numberOfEntered1)
					throw new Exception("650 is the maximum");

				// Initialize the second number
				System.out.print("Enter the highest number you anticipate receiving: ");
				numberOfEntered2 = input.nextInt();
				if (numberOfEntered2 <= 0)
					throw new Exception(
							"Unrealistic value...!\nvalue must be greater than zero\nReenter the expected range of customers");
				if (650 < numberOfEntered2)
					throw new Exception("650 is the maximum\nReenter the expected range of customers");

				if (numberOfEntered1 > numberOfEntered2)
					throw new Exception(
							"Unrealistic value...!\nThe first number must be smaller than the secand one, in order to make a positive rang");

				if (numberOfEntered2 - numberOfEntered1 < 50) {
					System.out.println("\nWarning the difference is less than 50, this may cause inaccuracy");
					System.out.println("0: No, change the range\n1: Yes, I take the responsibility ");
					// to keep asking the user in case entering an invalid number
					while (true) {
						System.out.print("Do you want to continue? ");
						String chek = input.next();

						if (chek.equals("0"))
							throw new Exception("OK, enter the expected range of customers");

						else if (chek.equals("1")) {
							System.out.println("OK, your values is accepted");
							break;
						}

						else
							System.out.println("Unaccepted response!!!");

					}
				}

			}
			// In case the user entered a double or a string, or anything accept integers
			catch (InputMismatchException e) {
				System.out.println("Unrealistic value...!");
				System.out.println("Reenter the expected range of customers");
				return getNumbers();// redo the method
			}
			// In case the user entered a negative integer or break the instructions given to him
			 
			catch (Exception e) {
				System.out.println(e.getMessage());
				return getNumbers();// redo the method
			}
			break;

		}
		int[] values = { numberOfEntered1, numberOfEntered2 };
		return values;
	}
	
	public static int getRandom(int firstNumber, int secondNumber) {
		 Random randomNumber = new Random();
		 int random = randomNumber.nextInt(secondNumber)+ firstNumber;
		 return random;}
	//this method takes an array of customers then check their orders and counts their food
	public static int[] readOrder(ArrayList<Customers> servedCustomers) {
		int[] arrayOfAmount = new int[7];
		for(int i=0; i<= servedCustomers.size()-1;i++) {
			Customers customer = servedCustomers.get(i);
		Order order = customer.getCustomerOrder();
	   int broast = order.getNumberOfBroast();
	   int nuggets = order.getNumberOfNuggets();
       int jumboShrimp = order.getNumberOfJumboShrimp();
       int sandwich = order.getNumberOfSandwich();
       int drinks = order.getNumberOfDrinks();
       int corn = order.getNumberOfCorn();
       int iceCream = order.getNumberOfIcecream();
       
        arrayOfAmount[0] +=broast;
        arrayOfAmount[1] +=nuggets;
        arrayOfAmount[2] +=jumboShrimp;
        arrayOfAmount[3] +=sandwich;
        arrayOfAmount[4] +=drinks;
        arrayOfAmount[5] +=corn;
        arrayOfAmount[6] +=iceCream; 
       
        
        }
		
		return arrayOfAmount; //{broast,nuggets,jumboShrimp,sandwich,drinks,corn,iceCream}
	} 
	//this method takes an array of customers then check their orders and counts how many of them are special,  large, or online
	public static int[] divideTheOrder(ArrayList<Customers> servedCustomers) {
		int[] orderTypes = new int[4];
		for(int i=0; i<= servedCustomers.size()-1;i++) {
			Customers customer = servedCustomers.get(i);
		
		
	  if(customer.isSpecialOrder())
		  orderTypes[1] ++;
	  else
		  orderTypes[0] ++;
	  
	  
        if(customer.isLargeOrder())
        	orderTypes[2] ++;
        
        if(customer.isOnlineOrder())
        	orderTypes[3] ++;
        
        }
		return orderTypes; //{normal ,special ,large,online}
	}
    
}