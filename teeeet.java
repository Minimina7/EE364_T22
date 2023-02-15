import java.util.ArrayList;

public class teeeet {

	public static void main(String[] args) {
		int normalServerNumber = 1 ; // check
		int  onlineServerNumber = 1000; //check
		int numberofonlinecoustomer=0;
		double totalQualityAverage= 0;
		int totalWaitingTime = 0;
		int totalTimeInMinute=0;
		int coustomernum=0;
		
		// customers array
		ArrayList<Customers> cashierCustomers = new ArrayList<Customers>();
		ArrayList<Customers> serverCustomers = new ArrayList<Customers>();
		ArrayList<Customers> AllCustomer = new ArrayList<Customers>();
		
		Customers cus = new Customers();
		if(cus.isOnlineOrder()) {
			cus.setOrderNumber(1000);
		}else {
			cus.setOrderNumber(1);}
		serverCustomers.add(cus);

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
				
				
				
				

				// array of servers
				ArrayList<Server> servers = new ArrayList<Server>();
				
				
				// Servers Creation
				Server server = new Server(serverCustomers, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
						corn, drinks, iceCream);
				
				
				
				System.out.println("arrraserrrehww = " + serverCustomers);		
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

							// remove customer
							serverCustomers.remove(i);
							System.out.println("ccccccccccccccccccRRRRRRRRRRRRRRRRRRRRRR");

							// gather information
							totalQualityAverage += foodQuality;
							totalWaitingTime += customerWaitingTime;

							// brake the loop
							break;
						}

					}
				}
		
		
		
				System.out.println("avr = " + totalQualityAverage);
				System.out.println("Time = " + totalWaitingTime);
				System.out.println("cus = " + coustomernum++);
				System.out.println("broast = " + broast.getBench());
				System.out.println("spicyBroast = " + spicyBroast.getBench());
				System.out.println("nuggets = " + nuggets.getBench());
				System.out.println("spicyNuggets = " + spicyNuggets.getBench());
				System.out.println("sandwich = " + sandwich.getBench());
				System.out.println("corn = " + corn.getBench());
				System.out.println("drinks = " + drinks.getBench());
				System.out.println("nsn = " + normalServerNumber);
				System.out.println("osn = " + onlineServerNumber);
	}

}
