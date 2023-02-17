import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {

////////////////////////////////////////////////////////  before loop  ///////////////////////////////////////////////////////////

		// variables
		int onlinCashier = 1000; // needed
		int totalTimeInMinute=0; // needed
		int normalServerNumber = 1 ; // may need
		int  onlineServerNumber = 1000; // needed 
		int numberOfServedCustomers =0; // needed
		double totalQualityAverage= 0; // needed
		int totalWaitingTime = 0; // needed
		
		
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

		System.out.println("The avrage ia : " + coustomerAvreage); //////////////////////////////////////////////// not
																	//////////////////////////////////////////////// important
		System.out.println("coustommer per H");/////////////////////////////////////////////////////////////////// not
												/////////////////////////////////////////////////////////////////// important

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
			System.out.print(numberOfCustomerPerHour[i] + "  "); /////////////////////////////////////////////////// not
																	/////////////////////////////////////////////////// important
		}

		System.out.println("total : " + totalNumberofCustomers); ///////////////////////////////////////////////// not
																	///////////////////////////////////////////////// important

		int cus = 0; // not important

		// customers array
		ArrayList<Customers> people = new ArrayList<Customers>();
		ArrayList<Customers> cashierCustomers = new ArrayList<Customers>();
		ArrayList<Customers> serverCustomers = new ArrayList<Customers>();

		// create Customers [upper bound]
		for (int i = 1; i <= rangeBounds[1]; i++) {
			Customers customers = new Customers();
			people.add(customers);
		}

		// check the cutomors lenght
		System.out.println(people.size()); ///////////////////////////////////////////////////////////////////// not
											///////////////////////////////////////////////////////////////////// important

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

		// cashier creation
		Cashier cashier = new Cashier();

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

		/////////////////////////////////////////////////////// main loop [Hour]
		/////////////////////////////////////////////////////// ////////////////////////////////////////////////

		// Hour loop
		for (int Hour = 1; Hour <= 17; Hour++) {
			System.out.println("[[[[[[[[[[[[[ Hour: " + (Hour) + " ]]]]]]]]]]]]\n");
			int numberOfCustomersInThisHour =0;
			if (Hour <= 16) {
			numberOfCustomersInThisHour = (numberOfCustomerPerHour[Hour - 1]);
			System.out.println("Hour: " + Hour + "\nnumber of customer: " + numberOfCustomersInThisHour);
			}
			else {
				System.out.println("------------------------------------------------------------------------");
				System.out.println("------------------------------------------------------------------------");
				System.out.println("------------------- THE RESTAURANT IS ABOUT TO CLOSE -------------------");
				System.out.println("---------------- NO CUSTOMERS WILL ENTER THE RESTAURANT ----------------");
				System.out.println("------------------------------------------------------------------------");
				System.out.println("------------------------------------------------------------------------");
				
			}
			
			
			///////////////////////////////////////////////////// inner loop [minute]
			///////////////////////////////////////////////////// //////////////////////////////////////////////

			// minute loop
			for (int min = 0; min < 60; min++) {
				System.out.println("\\\\\\\\\\\\\\\\ min:  " + min + " ////////\n");

				if (Hour <= 16) {
					// random number to determine if customers will come or not
					double randomNumber = getRandom(0, 100);
					System.out.println("((((((((((((((( ramdom: " + randomNumber + "))))))))))))))))))\n");

					// calculate customers enter probability
					double EnterProbability = ((double) numberOfCustomersInThisHour / (60 - min)) * 100;
					System.out.println(EnterProbability);

					if (randomNumber <= EnterProbability) {
						if (randomNumber <= EnterProbability * 0.80) {
							System.out.println("\n--------------probability------------");
							System.out.println(randomNumber);
							System.out.print(0 + " - ");
							System.out.println(EnterProbability * 0.80);
							System.out.println("one custmer entered\n");
							System.out.println("--------------probability------------\n");
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;

						} else if (randomNumber <= EnterProbability * 0.95) {
							System.out.println("\n--------------probability------------");
							System.out.println(randomNumber);
							System.out.print(EnterProbability * 0.80 + " - ");
							System.out.println(EnterProbability * 0.95);
							System.out.println("two custmer entered\n");
							System.out.println("--------------probability------------\n");
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							System.out.println("cus enter" + ++cus);
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
						} else {
							System.out.println("\n--------------probability------------");
							System.out.println(randomNumber);
							System.out.print(EnterProbability * 0.95 + " - ");
							System.out.println(EnterProbability);
							System.out.println("three custmer entered\n");
							System.out.println("--------------probability------------\n");
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
							onlinCashier = sortCustomes(people, serverCustomers, cashierCustomers, onlinCashier);
							numberOfCustomersInThisHour--;
						}
					}
				}
				
				
				System.out.println("\nserveronly number in the resturant "+(serverCustomers.size()));
				System.out.println("cashironly number in the resturant "+(+cashierCustomers.size()));
				System.out.println("total number in the resturant "+(serverCustomers.size()+cashierCustomers.size())+"\n");
				// chef check Bench 
				broastChef.checkBeanch(spicyBroast, broast, totalTimeInMinute);
				nuggetsChef.checkBeanch(spicyNuggets, nuggets, totalTimeInMinute);
				shrimpChef.checkBeanch(jumboShrimp, totalTimeInMinute);
				sandwichChef.checkBeanch(sandwich, totalTimeInMinute);
				
				
				// make the server work
				for (Server server: servers ) {
					System.out.println("\nnormalServerNumber  :"+normalServerNumber);	
					server.takeNextOrder(onlineServerNumber, normalServerNumber);
					if (server.isServerTookOnlineNumber()) {
						onlineServerNumber+=1;
						System.out.println("\n haaaaaahy tra srlha incrment onlyn");	
					}
					if (server.isServerTookNormalNumber()) {
						normalServerNumber+=1;
						System.out.println("\n haaaaaahy tra srlha incrment normal");
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


								// remove customer
								serverCustomers.remove(i);
								System.out.println("Costomerkiked"+i+ "     "+ costomerNumber+"/////////////////////////////////"+ ++numberOfServedCustomers);// not importanyt
	
								// gather information
								totalQualityAverage += foodQuality;
								totalWaitingTime += customerWaitingTime;

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
				
				System.out.println("avr = " + ((numberOfServedCustomers > 0) ? totalQualityAverage/numberOfServedCustomers : 0));
				System.out.println("Time = " + ((numberOfServedCustomers> 0) ? totalWaitingTime/numberOfServedCustomers : 0));
				System.out.println(" ====================Benches===================== ");
				System.out.println("broast = " + broast.foodAmuont());
				System.out.println("spicyBroast = " + spicyBroast.foodAmuont());
				System.out.println("nuggets = " + nuggets.foodAmuont());
				System.out.println("spicyNuggets = " + spicyNuggets.foodAmuont());
				System.out.println("sandwich = " + sandwich.foodAmuont());
				System.out.println("jumboShrimp = " + jumboShrimp.foodAmuont());
				System.out.println(" =============================================== ");
				System.out.println("((((((((((((((((((((((((((((((((((( "+ totalTimeInMinute + " )))))))))))))))))))))))))))))))))))");
				System.out.println("in the rstrunt now"+serverCustomers.size());
			} // end minute loop

			System.out.println("[[[[[[[[[[[[[ cusnum: " + cus + " ]]]]]]]]]]]]\n");

		} // end Hour loop

	} // main method

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
							System.out.println("Unaccepted response");

					}
				}

			}
			// In case the user entered a double or a string, or anything accept integers
			catch (InputMismatchException e) {
				System.out.println("Unrealistic value...!");
				System.out.println("Reenter the expected range of customers");
				return getNumbers();// redo the method
			}
			// In case the user entered a negative integer or break the instructions given
			// to him
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
}