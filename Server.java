import java.util.ArrayList;

public class Server {

	// Data field
	
	// The order that the server serve it right now.
	private Order currentOrder;
	
	//private boolean serverAvailable;
	
	// determine if there special order or not 
	private boolean isThereSpecialOrder;
	// determine if there server take online order or not
	private boolean serverTookOnlineNumber;
	// determine if there server take Normal order or not
	private boolean serverTookNormalNumber;

	// The order that the customer will take from the server.
	private ArrayList<Food> submittedOrder = new ArrayList<Food>();//customers edit 

	// Food bench arrays
	private Bench<Broast> broastArray;
	private Bench<Broast> spicyBroastArray;
	private Bench<Nuggets> nuggetsArray;
	private Bench<Nuggets> spicyNuggetsArray;
	private Bench<JumboShrimp> jumboShrimpArray;
	private Bench<Sandwich> sandwichArray;
	private Bench<Drinks> drinksArray;
	private Bench<Corn> cornArray;
	private Bench<IceCream> iceCreamArray;

	// The number of orders of each type that the customer order.
	private int broast;
	private int spicyBroast;
	private int nuggets;
	private int spicyNuggets;
	private int jumboShrimp;
	private int sandwich;
	private int drinks;
	private int corn;
	private int iceCream;

	// Some array that needed to accomplish the code
	private ArrayList<Customers> customersArray;
	private ArrayList<Sandwich> SandwichOrdered;
	private ArrayList<Sandwich> SpecialSandwich; // goes to the chief to cooking it


	// Constructor
	public Server(ArrayList<Customers> CustomersArray, Bench<Broast> Broast, Bench<Broast> spicyBroast,
			Bench<Nuggets> nuggets, Bench<Nuggets> spicyNuggets, Bench<JumboShrimp> jumboShrimp,
			Bench<Sandwich> sandwich, Bench<Corn> corn, Bench<Drinks> drinks, Bench<IceCream> iceCream) {

		// shallow copy of the customers array that created in the main loop
		this.customersArray = CustomersArray;

		// shallow copy of the bench created in the main loop
		broastArray = Broast;
		spicyBroastArray = spicyBroast;
		nuggetsArray = nuggets;
		spicyNuggetsArray = spicyNuggets;
		jumboShrimpArray = jumboShrimp;
		sandwichArray = sandwich;
		drinksArray = drinks;
		cornArray = corn;
		iceCreamArray = iceCream;
	}
	
	
	// Methods
	
	
	// Called in main method
	// The goal of this method is determine whether the server will take the next order or not 
	// If the sever didn't take the next order that mean the server didn't finish the previous one.
	public void takeNextOrder(int onlineServerNumber, int normalServerNumber) {
		setThereSpecialOrder(false);

		// check if the server finish the previous order or not
		if (isServerAvailable()) {
			
			// the server finish the previous order
			// check for the online order
			for (Customers CustomerOrder : customersArray) {
				if (CustomerOrder.getOrderNumber() == onlineServerNumber) {
					currentOrder = CustomerOrder.getCustomerOrder();// take the customer order
					setServerTookOnlineNumber(true);
					setServerTookNormalNumber(false);
					submittedOrder.clear();
					SpecialSandwich.clear();
					readOrder();
					break;
				}
			}
			
			// there is no online order
			// check normal order
			for (Customers CustomerOrder : customersArray) {
				if (CustomerOrder.getOrderNumber() == normalServerNumber) {
					currentOrder = CustomerOrder.getCustomerOrder();// take the customer order
					setServerTookOnlineNumber(false);
					setServerTookNormalNumber(true);
					submittedOrder.clear();
					SpecialSandwich.clear();
					readOrder();
					break;
				}
			}
		}
		
		// the server didn't finish the previous order
		else {
			setServerTookOnlineNumber(false);
			setServerTookNormalNumber(false);
			readOrder();
		}
	}
	

	// the goal of this method is sorting the order and geting the number order of each food type
	public void readOrder() {
		sortOrder();
		jumboShrimp = currentOrder.getNumberOfJumboShrimp();
		sandwich = currentOrder.getNumberOfSandwich();
		drinks = currentOrder.getNumberOfDrinks();
		corn = currentOrder.getNumberOfCorn();
		iceCream = currentOrder.getNumberOfIcecream();
		prepareOrder();
	}
	
	
	// the goal of this method is doing array of Sandwich Order of the customer
	// orders
	public void sortOrder() {
		for (Meal order : currentOrder.getMeals()) {
			if (order instanceof Sandwich) {
				SandwichOrdered.add((Sandwich) order);
			} else if (order instanceof Broast) {
				if (((Broast) order).isItSpicy()) {
					spicyBroast += 1;
				} else {
					broast += 1;
				}
				
			} else if (order instanceof Nuggets) {
				if (((Nuggets) order).isItSpicy()) {
					spicyNuggets += 1;
				} else {
					nuggets += 1;
				}
			}
		}
	}
	

	// prepare the order for the customer
	public void prepareOrder() {
		broast = mealOrder(broast, broastArray);
		spicyBroast = mealOrder(spicyBroast, spicyBroastArray);
		nuggets = mealOrder(nuggets, nuggetsArray);
		spicyNuggets = mealOrder(spicyNuggets, spicyNuggetsArray);
		jumboShrimp = mealOrder(jumboShrimp, jumboShrimpArray);
		sandwich = sandwichOrder(sandwich, sandwichArray);
		corn = cornOrder(corn, cornArray);
		drinks = drinkOrder(drinks, drinksArray);
		iceCream = iceCreamOrder(iceCream, iceCreamArray);
		updateQuality();

	}

	
	// This method deal with Broasts , Nuggets , jumboShrimp.
	// The goal of this method is to check and take food from the food shelf
	public int mealOrder(int numberOfFood, Bench<?> mealBench) { //check
		while (numberOfFood != 0) {
			if (mealBench.foodAmuont()>=1) {
				submittedOrder.add(mealBench.getFood(0));
				mealBench.removeFromBench(0);
				numberOfFood--;
			} else
				break;
		}
		return numberOfFood;
	}

	
	// this method deal with sandwich order
	public int sandwichOrder(int numberOfSandwich, Bench<Sandwich> SandwichBench) {
		int k = numberOfSandwich;
		for (int i = 0; i <= (SandwichOrdered.size() - 1); i++) {// look at customer sand
			Sandwich orderedSandwich = SandwichOrdered.get(i);
			for (int j = 0; j <= (SandwichBench.foodAmuont() - 1); j++) {// search about the special sandwich
				Sandwich sandwich = SandwichBench.getBenchArray(j);
				if (orderedSandwich.equalTo(sandwich)) {
					submittedOrder.add(sandwich);
					SandwichBench.removeFromBench(j);
					SandwichOrdered.remove(i);
					numberOfSandwich--;
					k = numberOfSandwich;
					break;

				} else {
					k--;
				}
			}
			if (k != numberOfSandwich) { // if the sandwich not exist in the bench 
				if (orderedSandwich.isIsitSpecial()) { // if the sandwich special
					setThereSpecialOrder(true);
					SpecialSandwich.add(orderedSandwich);
				} 
				k = numberOfSandwich;
			}
		}
		return numberOfSandwich;
	}

	
	// this method check the IceCream order and prepare it to the customer
	public int iceCreamOrder(int numberOfIceCream, Bench<IceCream> iceCreamBench) {
		while (numberOfIceCream != 0) {
			iceCreamBench.addToBench(new IceCream());// Make iceCream
			iceCreamBench.removeFromBench(0); // Give the iceCream to the customer
			numberOfIceCream--;
		}
		return 0;
	}

	
	// this method check the drinks order and prepare it to the customer
	public int drinkOrder(int numberOfDrink, Bench<Drinks> drinkBench) {
		while (numberOfDrink != 0) {
			drinkBench.addToBench(new Drinks());// to ensure that there are Drinks
			drinkBench.removeFromBench(0);// Give the drink to the customer
			numberOfDrink--;
		}
		return 0;
	}
	
	
	// this method check the corn order and prepare it to the customer
		public int cornOrder(int numberOfCorn, Bench<Corn> cornBench) {
			while (numberOfCorn != 0) {
				cornBench.addToBench(new Corn());// make corn order
				cornBench.removeFromBench(0);// give the corn to the customer
				numberOfCorn--;
			}
			return 0;
		}
		
		
		// this method is responsible for updating the quality of the food.
		public void updateQuality() {
			for (Food order: submittedOrder) {
				order.editQuality();
			}
		}

		
	// this method return true if the server finish the previous order
	public boolean isServerAvailable() {
		return (broast == 0 && spicyBroast == 0 && nuggets == 0 && spicyNuggets == 0 && jumboShrimp == 0
				&& sandwich == 0 && drinks == 0 && corn == 0 && iceCream == 0);
	}
	
	
	// this method gives the special order to the chief
	public ArrayList<Sandwich> callTheChief(){
		return SpecialSandwich;
	}

	
	// calculate and return the quality average
	public double getQuality() {
		double quality = 0;
		for (Food order : submittedOrder) {
			quality += order.getQuality();
		}
		double qualityAvr = (quality) / (submittedOrder.size());
		return qualityAvr;
	}
	
	
	public boolean isServerTookOnlineNumber() {
		return serverTookOnlineNumber;
	}
	
	
	public void setServerTookOnlineNumber(boolean serverTookOnlineNumber) {
		this.serverTookOnlineNumber = serverTookOnlineNumber;
	}
	
	
	public boolean isServerTookNormalNumber() {
		return serverTookNormalNumber;
	}
	
	
	public void setServerTookNormalNumber(boolean serverTookNormalNumber) {
		this.serverTookNormalNumber = serverTookNormalNumber;
	}
	
	
	public boolean isThereSpecialOrder() {
		return isThereSpecialOrder;
	}
	
	
	public void setThereSpecialOrder(boolean isThereSpecialOrder) {
		this.isThereSpecialOrder = isThereSpecialOrder;
	}
	
	
	// this method pass the submitted order
	public ArrayList<Food> getSubmittedOrder() {
		return submittedOrder;
	}
	
	
	public ArrayList<Sandwich> getSpecialSandwich() {
		return SpecialSandwich;
	}
	
	
}

