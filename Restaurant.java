import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Restaurant {
	
	//Data field
	//These arrays are going to be used in the GUI
	public static ArrayList<Integer> customersHourlyWaitingTimeAverage = new ArrayList<Integer>();
	public static ArrayList<Double> customersHourlyQualityAverag = new ArrayList<Double>();
	public static ArrayList<Customers> allCustomersServed = new ArrayList<Customers>();
	
	public static void main(String[] args) {
		boolean flag0 = true;//manage the run
		//to repeat every day
		while (flag0) {
			
////////////////////////////////////////////////////////  before loop  ///////////////////////////////////////////////////////////

		// variables
			int onlinCashier = 1000;// Customers counter 
			int normalServerNumber = 1;// Customers counter 
			int  onlineServerNumber = 1000;// Customers counter 
			int existingCustomers = 0;// Customers counter 
			int numberOfServedCustomers =0;// Customers counter  
			int numberOfCustomersInThisMinute =0;// Customers counter 
			int totalTimeInMinute=0;// time
			int totalWaitingTime = 0;// time
			int hourlyWaitingTimeAverage=0;// time
			double totalQualityAverage= 0;//Quality
			double hourlyQualityAverage=0;//Quality
			int serverWorking = 0;//worker counter
			int numberOfBenchRefreshes = 0;//benches refills
			int hourlyNumberOfBenchRefreshes = 0;//benches refills
			int spicyBroastAmount = 0;//food counter
			int broastAmount = 0;//food counter
			int spicyNuggetsAmount = 0;//food counter
			int nuggetsAmount = 0;//food counter
			int jumboShrimAmount = 0;//food counter
			int sandwichAmount = 0;//food counter
			int orderedBroast = 0;//food counter
			int orderedBroastSpicy = 0;//food counter
			int orderedNuggets = 0;//food counter
			int orderedNuggetsSpicy = 0;//food counter
			int orderedJumboShrim = 0;//food counter
			int orderedSandwich = 0;//food counter
			boolean slowRunHours= false;//manage the run
			boolean slowRunMinutes= false;//manage the run
			boolean flag1 = true;//manage the run
			boolean flag2 = true;//manage the run
			boolean flag3 = true;//manage the run
			boolean flag4 = true;//manage the run
			boolean flagCooking = true;//manage the cooking
			int cashierServed = 0;//worker counter
			int hourlyBroast = 0; //food counter
			int hourlyNuggets = 0; //food counter
			int hourlyShrimp = 0; //food counter
			int hourlySandwich = 0; //food counter
			int hourlyDrinks = 0; //food counter
			int hourlyCorn = 0; //food counter
			int hourlyIceCream= 0; //food counter
			int hourlyOnlineCustomer = 0; //worker counter
			int hourlyNormalCustomer = 0; //worker counter
			int hourlyLargeCustomer = 0; //worker counter
			int hourlySpecialCustomer = 0; //worker counter
			int[] arrayOfAmount = {0,0,0,0,0,0,0};//food counter	
		
		Scanner input = new Scanner(System.in); //to take inputs
		
		

		
		
		
		System.out.println("Note:\nThe restaurant is not designed to handle more than 650 customers");
		System.out.println("For more accuracy, we recommend the difference to be at least 50");
		System.out.println("Enter the expected range of customers\n");

		// bring the sum of range bounds
		int[] rangeBounds = getNumbers();
		int sumOfRangeBound = rangeBounds[0] + rangeBounds[1]; // lower bound [0], upper bound [1]

		// determine the total number of customers that will enter the Restaurant [not accurate]
		int totalNumberofCustomers = 0;

		// divided by 2 to get the average, 16 to get the average per Hour
		double coustomerAvreage = (((double) sumOfRangeBound) / (2 * 16));

		// determine weight of rush hour
		double[] timeprobability = { 0.4, 0.6, 0.8, 1.3, 1.7, 1.0, 1.1, 1.4, 0.8, 0.7, 0.7, 0.9, 1.1, 1.7, 1.0, 0.8 };

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
		ArrayList<Customers> people = new ArrayList<Customers>();// all Customers
		ArrayList<Customers> cashierCustomers = new ArrayList<Customers>();// customers who don't have an online order
		ArrayList<Customers> serverCustomers = new ArrayList<Customers>();// Server queue
		ArrayList<Customers> customersWhoOrdered = new ArrayList<Customers>();//they are used in order to know should the Chef cook or not
		ArrayList<Customers> servedCustomers = new ArrayList<Customers>(); // it is an array containing all the customers who have been served until now, and it is used to compute and display customers data. 
		ArrayList<Customers> servedCustomersThisHour = new ArrayList<Customers>(); // similar to servedCustomers but it contains the customer who have been served at this hour only
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
		
		// array of servers
		ArrayList<Server> servers = new ArrayList<Server>();
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
		
		
		
		//Question 0 to determine how fast the code will run in terms of hours
				System.out.println("would you like me to print everything without asking questions?");
				while (flag3) {
				System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
				String answer = input.next();
				if(answer.equals("Yes") || answer.equals("yes")) {
					
					flag1 = false;
					flag2 = false;
					flag3 = false;
				}
				else if (answer.equals("No")|| answer.equals("no")) {
					
					flag3 = false;
					flag4 = false;
				}
				else
					System.out.println("Unaccepted response!!!");

				}
		//Question 1 to determine how fast the code will run in terms of hours
		System.out.println("Do you want to be asked questions after each hour?");
		while (flag1) {
		System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
		String answer = input.next();
		if(answer.equals("Yes")|| answer.equals("yes")) {
			slowRunHours =true;
			flag1 = false;
		}
		else if (answer.equals("No")|| answer.equals("no")) {
			slowRunHours =false;
			flag1 = false;	
		}
		else
			System.out.println("Unaccepted response!!!");

		}
		
		//question 2 to determine how fast the code will run in terms of minutes
		System.out.println("Do you want to see everything happening in each minute?");
		while (flag2) {
		System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
		String answer = input.next();
		if(answer.equals("Yes")|| answer.equals("yes")) {
			slowRunMinutes =true;
			flag2 = false;
		}
		else if (answer.equals("No")|| answer.equals("no")) {
			slowRunMinutes =false;
			flag2 = false;	
		}
		else
			System.out.println("Unaccepted response!!!");

		}
		
		if(slowRunHours && !(slowRunMinutes)){
			System.out.println("WELCOME TO THE RESTAURANT");
		}
		
		/////////////////////////////////////////////////////  start Hours loop  /////////////////////////////////////////////////////
		
		// Hour loop
		for (int Hour = 1; Hour <= 17; Hour++) {
			
			//reset the values
			 hourlyQualityAverage=0;
			 hourlyWaitingTimeAverage=0;
			int numberOfCustomersInThisHour =0;
			
			//to print the closing announcement
			if (Hour <= 16) {
			numberOfCustomersInThisHour = (numberOfCustomerPerHour[Hour - 1]);
			}
			
			else {
				if((!(slowRunHours) && !(slowRunMinutes))||flag4) {
					
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
			
			//the headline of the minutes' table 
			if(slowRunMinutes||flag4) {
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
			
			/////////////////////////////////////////////////////  start minutes loop  ///////////////////////////////////////////////////// 
			

			// minute loop
			for (int min = 0; min < 60; min++) {

				if (Hour <= 16) {
					// random number to determine if customers will come or not
					double randomNumber = getRandom(0, 100);

					// calculate customers enter probability
					double EnterProbability = ((double) numberOfCustomersInThisHour / (60 - min)) * 100;
					
					//reset the value
					numberOfCustomersInThisMinute = 0;
					
					//determine how many customers will enter the restaurant
					if (randomNumber <= EnterProbability) {						
						if (randomNumber <= EnterProbability * 0.80) {
							//one customer
							onlinCashier = sortCustomers(people, serverCustomers, cashierCustomers, customersWhoOrdered,onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;

						} else if (randomNumber <= EnterProbability * 0.95) {
							//two customer
							onlinCashier = sortCustomers(people, serverCustomers, cashierCustomers, customersWhoOrdered,onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
							onlinCashier = sortCustomers(people, serverCustomers, cashierCustomers,customersWhoOrdered, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
						} else {
							//three customer
							onlinCashier = sortCustomers(people, serverCustomers, cashierCustomers, customersWhoOrdered,onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
							onlinCashier = sortCustomers(people, serverCustomers, cashierCustomers, customersWhoOrdered,onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
							onlinCashier = sortCustomers(people, serverCustomers, cashierCustomers,customersWhoOrdered, onlinCashier);
							numberOfCustomersInThisHour--;
							numberOfCustomersInThisMinute++;
						}
					}
				}
				
				
				// make cashier work
				cashierServed = 0;
				if (!(cashierCustomers.isEmpty())) {
					cashierServed++;
					Customers cachierCustomer = cashierCustomers.get(0);
					cashier.serveCustomer(cachierCustomer);
					serverCustomers.add(cachierCustomer);
					customersWhoOrdered.add(cachierCustomer);
					cashierCustomers.remove(0);
				}
				
				
				
				
				 /**********************   chef  is Working    **********************/
				
				int chefsWorking = 0; //reset the value				
				
				// first hour using firstCook methods
				
				if(Hour == 1) {
					boolean isItTimeToCook = ((min+1)%5 == 0 );
					if(isItTimeToCook) {
				 int[] chefTriggers = cashier.chefTrigger(customersWhoOrdered);	//{broast,spicyBroast,nuggets,spicyNuggets,jumboShrimp,sandwich}
				 
				 //broast
				 spicyBroastAmount = spicyBroast.foodAmuont();
				 broastAmount = broast.foodAmuont();
				 broastChef.firstCookNormal(broast, chefTriggers[0]);
				 broastChef.firstCookSpicy(spicyBroast, chefTriggers[1]);
				 if(chefTriggers[0]+chefTriggers[1]>0)
					 chefsWorking++;
				 
				 //nuggets
				 spicyNuggetsAmount = spicyNuggets.foodAmuont();
					nuggetsAmount = nuggets.foodAmuont();
				 nuggetsChef.firstCookNormal(nuggets, chefTriggers[2]);
				 nuggetsChef.firstCookSpicy(spicyNuggets, chefTriggers[3]);
				 if(chefTriggers[2]+chefTriggers[3]>0)
					 chefsWorking++;
				 
				 //shrimp
				 jumboShrimAmount = jumboShrimp.foodAmuont();
				 shrimpChef.firstCookNormal(jumboShrimp, chefTriggers[4]);
				 if(chefTriggers[4]>0)
					 chefsWorking++;
				 
				 //sandwich
				 
				 if(chefTriggers[5]>3)
					 chefTriggers[5]=3;
				 sandwichAmount = sandwich.foodAmuont();
				 sandwichChef.firstCookNormal(sandwich, chefTriggers[5]);
				 if(chefTriggers[5]>0)
					 chefsWorking++;
				 for(Customers customers:customersWhoOrdered) {
					 if(customers.isSpecialOrder()) {
						 sandwichChef.cookeCustomersSpecialSandwiches(sandwich,customers);
					 }
				 }
					// to determine how many Chefs are working now
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
					
				 customersWhoOrdered.clear();
					}}// first hour
				
					
					

				
				
				
				
				
				
				// Hours from 2 to 16 using secondCook methods
				
				if((Hour > 1 && Hour <= 16) ) {     
				
				 	
				 	
				  int[] chefTriggers = cashier.chefTrigger(customersWhoOrdered);	//{broast,spicyBroast,nuggets,spicyNuggets,jumboShrimp,sandwich}
				 
				 //broast
				 orderedBroast+=chefTriggers[0];
				 if(orderedBroast>10)
					 orderedBroast=10;
				 orderedBroastSpicy+=chefTriggers[1];
				 if(orderedBroastSpicy>10)
					 orderedBroastSpicy=10;
				 boolean isItTimeToCookBroast = ((min+1)%broastChef.getTimeNeededToCooke() == 0 );
				 if(isItTimeToCookBroast) {
				 spicyBroastAmount = spicyBroast.foodAmuont();
				 broastAmount = broast.foodAmuont();
				 broastChef.secondCookNormal(broast, orderedBroast);
				 broastChef.secondCookSpicy(spicyBroast, orderedBroastSpicy);
				 if(chefTriggers[0]+chefTriggers[1]>0)
					 chefsWorking++;
				 orderedBroast = 0;
				 orderedBroastSpicy = 0;
				 }
				 //nuggets
				 orderedNuggets+=chefTriggers[2];
				 if(orderedNuggets>10)
					 orderedNuggets=10;
				 orderedNuggetsSpicy+=chefTriggers[3];
				 if(orderedNuggetsSpicy>10)
					 orderedNuggetsSpicy=10;
				 boolean isItTimeToCookNuggets = ((min+1)%nuggetsChef.getTimeNeededToCooke() == 0 );
				 if(isItTimeToCookNuggets) {
				 spicyNuggetsAmount = spicyNuggets.foodAmuont();
					nuggetsAmount = nuggets.foodAmuont();
				 nuggetsChef.secondCookNormal(nuggets, orderedNuggets);
				 nuggetsChef.secondCookSpicy(spicyNuggets, orderedNuggetsSpicy);
				 if(chefTriggers[2]+chefTriggers[3]>0)
					 chefsWorking++;
				 orderedNuggets = 0;
				 orderedNuggetsSpicy = 0;
				 }
				 //shrimp
				 orderedJumboShrim+=chefTriggers[4];
				 if(orderedJumboShrim>10)
					 orderedJumboShrim=10;
				 boolean isItTimeToCookJumboShrimp = ((min+1)%shrimpChef.getTimeNeededToCooke() == 0 );
				 if(isItTimeToCookJumboShrimp) {
				 jumboShrimAmount = jumboShrimp.foodAmuont();
				 shrimpChef.secondCookNormal(jumboShrimp, orderedJumboShrim);
				 if(chefTriggers[4]>0)
					 chefsWorking++;
				 orderedJumboShrim = 0;
				 }
				 //sandwich
				 orderedSandwich+=chefTriggers[5];
				 if(orderedSandwich>5)
					 orderedSandwich=5;
				 boolean isItTimeToCookSandwich = ((min+1)%sandwichChef.getTimeNeededToCooke() == 0 );
				 if(isItTimeToCookSandwich) {
				 sandwichAmount = sandwich.foodAmuont();
				 sandwichChef.secondCookNormal(sandwich, orderedSandwich);
				 if(chefTriggers[5]>0)
					 chefsWorking++;
				 orderedSandwich = 0;
				 }
				 
				 for(Customers customers:customersWhoOrdered) {
					 if(customers.isSpecialOrder()) {
						 sandwichChef.cookeCustomersSpecialSandwiches(sandwich,customers);
					 }
				 }
				 
				 
					// to determine how many Chefs are working now
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
					
				
				customersWhoOrdered.clear();//clearing orders
					}
				

				
				
				// Last hour using LastCook methods
				if(Hour == 17 && serverCustomers.size()>0 && (min+1)%5 == 0)  {
					
					chefsWorking++;
					
					spicyBroastAmount = spicyBroast.foodAmuont();
					 broastAmount = broast.foodAmuont();
					 spicyBroastAmount = spicyBroast.foodAmuont();
					 broastAmount = broast.foodAmuont();
					 jumboShrimAmount = jumboShrimp.foodAmuont();
					 sandwichChef.secondCookNormal(sandwich, orderedSandwich);
					for(int i=0;i<=serverCustomers.size()-1;i++) {
					 broastChef.LastCookNormal(broast, serverCustomers.get(i));
					 broastChef.LastCookSpicy(spicyBroast, serverCustomers.get(i));
					 
					 nuggetsChef.LastCookNormal(nuggets, serverCustomers.get(i));
					 nuggetsChef.LastCookSpicy(spicyNuggets, serverCustomers.get(i));
					 
					 shrimpChef.LastCookNormal(jumboShrimp, serverCustomers.get(i));
					 
					 sandwichChef.LastCookNormal(sandwich, serverCustomers.get(i));

					 
					 if(flagCooking) {
					 sandwichChef.cookeCustomersSpecialSandwiches(sandwich, serverCustomers.get(i));		
					 flagCooking = false; }
				}
				
					if(spicyBroast.foodAmuont()>spicyBroastAmount || broast.foodAmuont()>broastAmount)
						chefsWorking++;
					
					if(spicyNuggets.foodAmuont()>spicyNuggetsAmount || nuggets.foodAmuont()>nuggetsAmount)
						chefsWorking++;
				
					if(jumboShrimp.foodAmuont()>jumboShrimAmount)
						chefsWorking++;
					
					if(sandwich.foodAmuont()>sandwichAmount)
						chefsWorking++;
				}
				if(servedCustomersThisHour.size()!=0) {
				if((hourlyWaitingTimeAverage/servedCustomersThisHour.size())>20) {
					
					broastChef.checkBeanch(spicyBroast, broast, totalTimeInMinute);
					nuggetsChef.checkBeanch(spicyNuggets, nuggets, totalTimeInMinute);
					shrimpChef.checkBeanch(jumboShrimp, totalTimeInMinute);
					sandwichChef.checkBeanch(sandwich, totalTimeInMinute);
				}}
				
				//reset the value
				existingCustomers =0;

				// make the server work
				for (Server server: servers ) {	
					server.takeNextOrder(onlineServerNumber, normalServerNumber);
					
					//taking online order
					if (server.isServerTookOnlineNumber()) {
						serverWorking++;
						onlineServerNumber+=1;	
					}
					
					//taking normal order
					if (server.isServerTookNormalNumber()) {
						serverWorking++;
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
				

				
				// time effect:

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
				
				//sum of the meals on the benches
				int totalMeals = broast.foodAmuont() +spicyBroast.foodAmuont()+nuggets.foodAmuont()+spicyNuggets.foodAmuont()+sandwich.foodAmuont()+jumboShrimp.foodAmuont();				
				
				

				//in case the user asked for the data of the minutes
				if (slowRunMinutes ||flag4) {
					System.out.printf(
							"|%-4s%2d%4s%s" + "%-8s%1d%8s%s%" + "-7s%3d%7s%s%" + "-8s%1d%s%8s%s" + "%-6s%3d%6s%s"
									+ "%-8s%1d%s%8s%s" + "%-7s%3d%7s%s" + "%-9s%1d%9s%s%n",
							"", (min + 1), "", "|", "", numberOfCustomersInThisMinute, "", "|", "",
							(cashierCustomers.size()+cashierServed), "", "|", "", chefsWorking, "/4", "", "|", "", totalMeals, "", "|",
							"", (serverWorking + existingCustomers), "/3", "", "|", "", serverCustomers.size(), "", "|",
							"", existingCustomers, "", "|");
				}		
				
				
			} // end minute loop

// 	Amount of served customers
int numberOfCustomersServedAtThisHour = servedCustomersThisHour.size();
int totalNumberOfCustomersServed = servedCustomers.size();


hourlyBroast = arrayOfAmount[0];
hourlyNuggets = arrayOfAmount[1];
hourlyShrimp = arrayOfAmount[2];
hourlySandwich = arrayOfAmount[3];
hourlyDrinks = arrayOfAmount[4];
hourlyCorn = arrayOfAmount[5];
hourlyIceCream = arrayOfAmount[6];
arrayOfAmount = readOrder(servedCustomers); //{broast,nuggets,jumboShrimp,sandwich,drinks,corn,iceCream}
int[] orderTypes = divideTheOrder(servedCustomers);//{normal ,special ,large,online}

//getting customers types data for each hour
hourlyOnlineCustomer = orderTypes[3] -hourlyOnlineCustomer;
hourlyNormalCustomer = orderTypes[0] - hourlyNormalCustomer;
hourlyLargeCustomer = orderTypes[2] -hourlyLargeCustomer;
hourlySpecialCustomer = orderTypes[1] - hourlySpecialCustomer;

//getting food statistics data for each hour
hourlyNumberOfBenchRefreshes = numberOfBenchRefreshes -hourlyNumberOfBenchRefreshes;


// for the GUI 1
if(numberOfCustomersServedAtThisHour!=0) {
customersHourlyWaitingTimeAverage.add(hourlyWaitingTimeAverage/numberOfCustomersServedAtThisHour);
customersHourlyQualityAverag.add(hourlyQualityAverage/numberOfCustomersServedAtThisHour);
}

//for the GUI 2
//deep copy to keep the data save and prevent unwanted changes
allCustomersServed.clear();
for(Customers customers: servedCustomers) {
	allCustomersServed.add(customers);
}

System.out.print("\n");

//Question 1 Do you want hours summary?
if(slowRunHours||flag4){

	if(!flag4) {
if(Hour == 1)
System.out.println("Do you want "+Hour+" hour summary?");	
else
	System.out.println("Do you want "+Hour+" hours summary?");
	}
while (true) {
	

String answer;
if(flag4)
	answer = "Yes";
else {
	System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
 answer = input.next();}
if(answer.equals("Yes")|| answer.equals("yes")) {

// main block

	System.out.println(
			"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
	System.out.println("--------------------------------------------------------------- HOUR-|"+Hour+ "|-SUMMARY --------------------------------------------------------------");
	
	System.out.println(
			"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");
	System.out.println("                                                                FOOD STATISTICS                                                                ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.printf("%27s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%n","", "|  Broasts  ", "|", "  Nuggets  ",
			"|", "  Jumbo Shrimps  ", "|", "  Sandwichs  ", "|", "   Drinks  ", "|",
			"  Corns  ","|", "  Ice Cream  ","|");
	

	
	System.out.printf(
			 "%27s%s" + "%-4s%3d%4s%s%" + "-4s%3d%4s%s%" + "-7s%3d%7s%s" + "%-5s%3d%5s%s"
					+ "%-4s%3d%4s%s" + "%-3s%3d%3s%s" + "%-5s%3d%5s%s%n",
			"",  "|", "", (arrayOfAmount[0]-hourlyBroast), "", "|", "",(arrayOfAmount[1] - hourlyNuggets) , "", "|", "", (arrayOfAmount[2] - hourlyShrimp), "", "|", "",(arrayOfAmount[3] - hourlySandwich) , "", "|", "",(arrayOfAmount[4] - hourlyDrinks),
			"", "|", "", (arrayOfAmount[5] - hourlyCorn), "", "|", "", (arrayOfAmount[6] - hourlyIceCream), "", "|");
	

	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------\n");

	System.out.println("                                                           CUSTOMERS TYPES STATISTICS                                                          ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.printf("%39s%s%s%s%s%s%s%s%s%n","", "|   Served Customers  ", "|  Online   ", "|  Normal   ", "|", "  Large  ",
			"|", "  Special  ", "|");
	
	System.out.printf(
			 "%39s|%-9s%3d%9s"+ "|%-4s%3d%4s%s" + "%-4s%3d%4s%s%" + "-3s%3d%3s%s%" + "-4s%3d%4s%s%n" ,
			 "","", numberOfCustomersServedAtThisHour,"","", hourlyOnlineCustomer, "", "|", "", hourlyNormalCustomer, "", "|", "",hourlyLargeCustomer , "", "|", "", hourlySpecialCustomer, "", "|");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------\n");

	//to protect the code if there are no customers in the restaurant
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
		System.out.printf("%48s%s%s%s%s%n","", "|  Waiting Time Average   ", "|", "  Quality Average  ",
				"|");
		System.out.printf("%48s%s" + "%-11s%3d%11s%s%" + ((hourlyQualityAverage/numberOfCustomersServedAtThisHour == 100.00) ? "-7s%3.2f%6s%s%n":"-7s%3.2f%7s%s%n"), "",
				"|", "", hourlyWaitingTimeAverage/numberOfCustomersServedAtThisHour, "", "|", "", hourlyQualityAverage/numberOfCustomersServedAtThisHour, "", "|");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------\n");
		
	}
System.out.println(
		"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

System.out.println(
		"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");

//to protect the code if there are no customers in the restaurant
if(totalNumberOfCustomersServed==0) {
	System.out.println(
			"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
	System.out.println("-------------------------------------------------------------- CUMULATIVE-SUMMARY -------------------------------------------------------------");
	
	System.out.println(
			"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");
	System.out.printf("%55s%s%n","","No customesr Served until now");

}
else {
	System.out.println(
			"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
	System.out.println("-------------------------------------------------------------- CUMULATIVE-SUMMARY -------------------------------------------------------------");
	
	System.out.println(
			"-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-‾-\n");
	System.out.println("                                                                FOOD STATISTICS                                                                ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.printf("%27s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%n","", "|  Broasts  ", "|", "  Nuggets  ",
			"|", "  Jumbo Shrimps  ", "|", "  Sandwichs  ", "|", "   Drinks  ", "|",
			"  Corns  ","|", "  Ice Cream  ","|");
	
	System.out.printf(
			 "%27s%s" + "%-4s%3d%4s%s%" + "-4s%3d%4s%s%" + "-7s%3d%7s%s" + "%-5s%3d%5s%s"
					+ "%-4s%3d%4s%s" + "%-3s%3d%3s%s" + "%-5s%3d%5s%s%n",
			"", "|", "", arrayOfAmount[0], "", "|", "",arrayOfAmount[1] , "", "|", "", arrayOfAmount[2], "", "|", "",arrayOfAmount[3] , "", "|", "",arrayOfAmount[4],
			"", "|", "", arrayOfAmount[5], "", "|", "", arrayOfAmount[6], "", "|");


	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------\n");
	System.out.println("                                                           CUSTOMERS TYPES STATISTICS                                                          ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	
	System.out.printf("%39s%s%s%s%s%s%s%s%s%n","", "|   Served Customers  ", "|  Online   ", "|  Normal   ", "|", "  Large  ",
			"|", "  Special  ", "|");
	
	System.out.printf(
			 "%39s|%-9s%3d%9s"+ "|%-4s%3d%4s%s" + "%-4s%3d%4s%s%" + "-3s%3d%3s%s%" + "-4s%3d%4s%s%n" ,
			 "","", servedCustomers.size(),"","", orderTypes[3], "", "|", "", orderTypes[0], "", "|", "",orderTypes[2] , "", "|", "", orderTypes[1], "", "|");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------\n");
	System.out.println("                                                               GENERAL STATISTICS                                                              ");
	System.out.println(
			"-----------------------------------------------------------------------------------------------------------------------------------------------");
	System.out.printf("%48s%s%s%s%s%n","", "|  Waiting Time Average   ", "|", "  Quality Average  ",
			"|");
	System.out.printf("%48s%s" + "%-11s%3d%11s%s%" + ((totalQualityAverage/totalNumberOfCustomersServed == 100.00) ? "-7s%3.2f%6s%s%n":"-7s%3.2f%7s%s%n"), "",
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
else if (answer.equals("No")|| answer.equals("no")) {
	break;	
}
else 
	System.out.println("Unaccepted response!!!");

}

if(!flag4) {
//Question 2 Do you want to check on one of the customers?
if(numberOfCustomersServedAtThisHour!=0) {
System.out.println("Do you want to check on one of the customers that left the restaurant at this hour?");
while (true) {
System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
String answer = input.next();
if(answer.equals("Yes")|| answer.equals("yes")) {

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
			 
			 //Type
			 String Type = "Normal " ;
			 String special = "No ";
			 String large = "No " ;
			 
			 if(customers.isSpecialOrder())
				 special = "Yes";
			 else
				 special = "No ";; 
			 
			 if(customers.isLargeOrder())
				 large = "Yes";
			 
			 if(customers.isOnlineOrder())
				 Type = "Online ";
			 
			 System.out.println("\n|_-_-_-_-_-_-_-_-_-_-_-_-|");
				System.out.println("|                        |");
				System.out.println("|  CUSTOMER INFORMATION  |");
				System.out.println("| ---------------------- |");
				System.out.println("|                        |");
				System.out.printf("|%-2s%s%s%9s%s","","Type: ",Type,"","|\n");
				System.out.printf("|%-2s%s%s%10s%s","","Special: ",special,"","|\n");
				System.out.printf("|%-2s%s%s%12s%s","","Large: ",large,"","|\n");
				System.out.printf("|%-2s%s%2d%6s%s","","Waiting time: ",customers.getWaitingTime(),"","|\n");
				System.out.printf("|%-2s%s%3.2f"+((customers.getCustomerRating() == 100.00) ? "%1s%s" : "%2s%s"),"","order quality: ",customers.getCustomerRating(),"","|\n");
				System.out.println("|                        |");
				System.out.println("| ---------------------- |");
				System.out.println("|  CUSTOMER INFORMATION  |");
				System.out.println("|                        |");
				System.out.println("|_-_-_-_-_-_-_-_-_-_-_-_-|\n");
			 

			 
			 System.out.print("\n");
			 
			 
			 	//order
				System.out.println("Would you like to see his order?");
				while (true) {
				System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
				String answer2 = input.next();
				if(answer2.equals("Yes")|| answer2.equals("yes")) {
					
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
				else if (answer2.equals("No")|| answer2.equals("no")) {
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
else if (answer.equals("No")|| answer.equals("no")) {
	break;	
}
else
	System.out.println("Unaccepted response!!!");
}
}

//Question 3 Do you want to check on one of the customers?
System.out.println("Do you want to check on one of the customers who visited the restaurant?");
while (true) {
System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
String answer = input.next();
if(answer.equals("Yes")|| answer.equals("yes")) {

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
			 
			 //Type
			 String Type = "Normal " ;
			 String special = "No ";
			 String large = "No " ;
			 
			 if(customers.isSpecialOrder())
				 special = "Yes";
			 else
				 special = "No ";; 
			 
			 if(customers.isLargeOrder())
				 large = "Yes";
			 
			 if(customers.isOnlineOrder())
				 Type = "Online ";
			 
			 System.out.println("\n|_-_-_-_-_-_-_-_-_-_-_-_-|");
				System.out.println("|                        |");
				System.out.println("|  CUSTOMER INFORMATION  |");
				System.out.println("| ---------------------- |");
				System.out.println("|                        |");
				System.out.printf("|%-2s%s%s%9s%s","","Type: ",Type,"","|\n");
				System.out.printf("|%-2s%s%s%10s%s","","Special: ",special,"","|\n");
				System.out.printf("|%-2s%s%s%12s%s","","Large: ",large,"","|\n");
				System.out.printf("|%-2s%s%2d%6s%s","","Waiting time: ",customers.getWaitingTime(),"","|\n");
				System.out.printf("|%-2s%s%3.2f"+((customers.getCustomerRating() == 100.00) ? "%1s%s" : "%2s%s"),"","order quality: ",customers.getCustomerRating(),"","|\n");
				System.out.println("|                        |");
				System.out.println("| ---------------------- |");
				System.out.println("|  CUSTOMER INFORMATION  |");
				System.out.println("|                        |");
				System.out.println("|_-_-_-_-_-_-_-_-_-_-_-_-|\n");
			 

			 
			 System.out.print("\n");
			 
				//order
				System.out.println("Would you like to see his order?");
				while (true) {
				System.out.print("Enter "+ "\"Yes\""+" or " + "\"No\": ");
				String answer3 = input.next();
				if(answer3.equals("Yes")|| answer3.equals("yes")) {
					
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
				else if (answer3.equals("No")|| answer3.equals("no")) {
					break;	
				}
				else
					System.out.println("Unaccepted response!!!");

				}
			 
			//	will not be executed if no questions are asked
			// Last Question to delay the next output until the user has finished reading the first output
			 System.out.println("Are you done?");
			 while (true) {
			 System.out.println("Enter "+ "\"Yes\""+" to continue: ");
			 String answer2 = input.next();
			 if(answer2.equals("Yes")|| answer2.equals("yes")) {
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
else if (answer.equals("No")|| answer.equals("no")) {
	break;	
}
else
	System.out.println("Unaccepted response!!!");

}

		} }

servedCustomersThisHour.clear();



		} //end Hour loop
		
		// final summary
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
			if(answer.equals("Yes")|| answer.equals("yes")) {
				System.out.println("------------------Starting A New Day-----------------------");
				break;
			}   
			else if (answer.equals("No")|| answer.equals("no")) {
				System.out.println("Exiting the program");
				flag0 = false;
			}
			else
				System.out.println("Unaccepted response!!!");

			}

	  }//end bigWhileLoop
	} //end main method

	// sort one customer to its destination inside the Restaurant
	public static int sortCustomers(ArrayList<Customers> people, ArrayList<Customers> serverCustomers,
			ArrayList<Customers> cashierCustomers,ArrayList<Customers> customersWhoOrdered, int onlinCashier) {
		if (!(people.isEmpty())) {
			Customers customer = people.get(0);
			if (customer.isOnlineOrder()) {
				customer.setOrderNumber(onlinCashier);
				serverCustomers.add(customer);
				customersWhoOrdered.add(customer);
				people.remove(0);
				onlinCashier++;
			} else {
				cashierCustomers.add(customer);
				//customersWhoOrdered.add(customer);
				people.remove(0);
			}
		}
		return onlinCashier;
	}
	
	

	// making sure the user entered valid numbers.
	private static int[] getNumbers() {
		boolean flag1 = true;
		boolean flag2 = true;
		Scanner input = new Scanner(System.in);
		int numberOfEntered1 = 0;
		int numberOfEntered2 = 0;
		// to keep asking the user to enter numbers until a valid number is entered
		while (flag1) {
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
					while (flag2) {
						System.out.print("Do you want to continue? ");
						String chek = input.next();

						if (chek.equals("0"))
							throw new Exception("OK, enter the expected range of customers");

						else if (chek.equals("1")) {
							System.out.println("OK, your values is accepted");
							flag2 = false;
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
			flag1 = false;

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
	  
        if(customer.isLargeOrder())
        	orderTypes[2] ++;
        
        if(customer.isOnlineOrder())
        	orderTypes[3] ++;
  	  else
		  orderTypes[0] ++;
        
        }
		return orderTypes; //{normal ,special ,large,online}
	}
    
}