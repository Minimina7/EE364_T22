import java.util.ArrayList;

public class Order {
	private ArrayList<Meal> meals = new ArrayList<Meal>(); // arraylist has all the meals
	private ArrayList<Spicable> spicable = new ArrayList<Spicable>();// arraylist has only the spicable meals
	private ArrayList<Snacks> snacks = new ArrayList<Snacks>(); // arraylist has all the snacks
	private int orderNumber; // instance variable that save the order number
	private int orderAmount; // instance variable that save the order amount
	private boolean isitSpecial; // instance variable to check is it special order
	private	int numberOfBroast; // instance variable that count number of broast
	private	int numberOfNuggets; // instance variable that count number of nugget
	private	int numberOfJumboShrimp; // instance variable that count number of jumboShrimp
	private	int numberOfSandwich; // instance variable that count number of sandwich
	private	int numberOfIcecream; // instance variable that count number of icecream
	private	int numberOfCorn; // instance variable that count number of corn
	private	int numberOfDrinks; // instance variable that count number of drinks


	// constructor
	public Order() {
		int random = Restaurant.getRandom(0, 101);
		int amountMeal;
		// normal order
		if (random <= 70) {
			amountMeal = Restaurant.getRandom(1, 3); // from 1 to 3
			generateOrderMeal(amountMeal);
		}
		// medium order
		else if (70 < random && random <= 95) {
			amountMeal = Restaurant.getRandom(1, 5); // from 1 to 5
			generateOrderMeal(amountMeal);
		}
		// large order
		else {
			amountMeal = Restaurant.getRandom(1, 20); // from 1 to 20
			generateOrderMeal(amountMeal);
		}
		// snacks order
		int amountSnacks = Restaurant.getRandom(1, amountMeal); // from 1 to amountMeal 
		generateOrderSnacks(amountSnacks);

	}
	
	
	public void generateOrderMeal(int numberOfMeal) { // method to generate meals

		for(int i = 0 ; i < numberOfMeal ; i++){ // loop to generate meals
			int mealPercentage = Restaurant.getRandom(0, 101); // Generate a random number from 0 to 100
			int sandwichPercentage = Restaurant.getRandom(0, 101); // Generate a random number from 0 to 100
			if( mealPercentage == 0){ // if the condition is true exit the method 
				break;
			}
			else if ( mealPercentage <= 35){ // if the condition is true add broast to the arraylist
				numberOfBroast++;
				if (mealPercentage > 18 && mealPercentage <= 35){ // if the condition is true the broast is spicy
					Meal spicy = new Broast(); // create object from meal
					((Broast) spicy).makeSpicy(); // make the broast spicy
					setMeals(spicy); // add spicy broast to the arraylist
				}
				else
				setMeals(new Broast()); // add normal broast to the arraylist
			}
				else if ( mealPercentage > 35 && mealPercentage <= 70){ // if the condition is true add nuggets to the arraylist
					numberOfNuggets++;
					if (mealPercentage > 54 && mealPercentage <= 70){ // if the condition is true the nuggets is spicy
						Meal spicy = new Nuggets(); // create object from meal
						((Nuggets) spicy).makeSpicy(); // make the nugget spicy
						setMeals(spicy); // add spicy nugget to the arraylist
					}
					else
					setMeals(new Nuggets()); // add normal nugget to the arraylist
			}
					else if ( mealPercentage > 70 && mealPercentage <= 75){ // if the condition is true add jumboShrimp to the arraylist
						numberOfJumboShrimp++;
						setMeals(new JumboShrimp()); // add jumboShrimp to the arraylist
					}
						else if ( mealPercentage > 75 && mealPercentage <= 100){ // if the condition is true add sandwich to the arraylist
							numberOfSandwich++;
							if (mealPercentage > 75 && mealPercentage <= 90){ // if the condition is true add chicken sandwich to the arraylist
								if ( sandwichPercentage <= 50){ // if the condition is true add normal chicken sandwich with pickle and garlic to the arraylist
									setMeals(new Sandwich());
								}
								else if (sandwichPercentage > 50 && sandwichPercentage <= 60){ // if the condition is true add spicy chicken sandwich with pickle and garlic to the arraylist
									Meal spicy = new Sandwich(); // create object from meal
									((Sandwich) spicy).makeSpicy(); // make the sandwich spicy
									setMeals(spicy);
								}
								else if (sandwichPercentage > 60 && sandwichPercentage <= 70){ // if the condition is true add normal chicken sandwich without pickle and with garlic to the arraylist
									Meal noPickle = new Sandwich(); // create object from meal
									((Sandwich) noPickle).withoutPickles(); // make the sandwich without pickle
									makeItSpecial(); // change the variable to true
									setMeals(noPickle);
								}
								else if (sandwichPercentage > 70 && sandwichPercentage <= 80){ // if the condition is true add normal chicken sandwich without garlic and with pickle to the arraylist
									Meal noGarlic = new Sandwich(); // create object from meal
									((Sandwich) noGarlic).withoutGarlic(); // make the sandwich without garlic
									makeItSpecial(); // change the variable to true
									setMeals(noGarlic);
								}
								else if (sandwichPercentage > 80  && sandwichPercentage <= 85){ // if the condition is true add normal chicken sandwich without garlic and pickle to the arraylist
									Meal noPG = new Sandwich(); // create object from meal
									((Sandwich) noPG).withoutGarlic(); // make the sandwich without garlic
									((Sandwich) noPG).withoutPickles(); // make the sandwich without pickle
									makeItSpecial();
									setMeals(noPG);
								}
								else if (sandwichPercentage > 85  && sandwichPercentage <= 90){ // if the condition is true add spicy chicken sandwich without garlic and pickle to the arraylist
									Meal noPGSpicy = new Sandwich(); // create object from meal
									((Sandwich) noPGSpicy).makeSpicy(); // make the sandwich spicy
									((Sandwich) noPGSpicy).withoutGarlic(); // make the sandwich without garlic
									((Sandwich) noPGSpicy).withoutPickles(); // make the sandwich without pickle
									makeItSpecial(); // change the variable to true
									setMeals(noPGSpicy);
								}
								else if (sandwichPercentage > 90 && sandwichPercentage <= 95){ // if the condition is true add spicy chicken sandwich without pickle and with garlic to the arraylist
									Meal noPSpicy = new Sandwich(); // create object from meal
									((Sandwich) noPSpicy).makeSpicy(); // make the sandwich spicy
									((Sandwich) noPSpicy).withoutPickles(); // make the sandwich without pickle
									makeItSpecial(); // change the variable to true
									setMeals(noPSpicy);
								}
								else if(sandwichPercentage > 95 && sandwichPercentage <= 100){ // if the condition is true add spicy chicken sandwich without garlic and with pickle to the arraylist
									Meal noGSpicy = new Sandwich(); // create object from meal
									((Sandwich) noGSpicy).makeSpicy(); // make the sandwich spicy
									((Sandwich) noGSpicy).withoutGarlic(); // make the sandwich without garlic
									makeItSpecial(); // change the variable to true
									setMeals(noGSpicy);
									}
					}
					else{ // if the condition is true add fish sandwich to the arraylist
						if ( sandwichPercentage <= 50){ // if the condition is true add normal fish sandwich with pickle and garlic to the arraylist
							Meal fish = new Sandwich(); // create object from meal
							((Sandwich) fish).makeItFish(); // make it fish sandwich
								setMeals(fish);
						}
						else if (sandwichPercentage > 50 && sandwichPercentage <= 60){ // if the condition is true add spicy fish sandwich with pickle and garlic to the arraylist
							Meal spicy = new Sandwich(); // create object from meal
							((Sandwich) spicy).makeSpicy(); // make the sandwich spicy
							((Sandwich) spicy).makeItFish(); // make it fish sandwich
							setMeals(spicy);
						}
						else if (sandwichPercentage > 60 && sandwichPercentage <= 70){ // if the condition is true add normal fish sandwich pickle garlic and with garlic to the arraylist
							Meal noPickle = new Sandwich(); // create object from meal
							((Sandwich) noPickle).withoutPickles(); // make the sandwich without pickle
							((Sandwich) noPickle).makeItFish(); // make it fish sandwich
							makeItSpecial();
							setMeals(noPickle);
						}
						else if (sandwichPercentage > 70 && sandwichPercentage <= 80){ // if the condition is true add normal fish sandwich without garlic and with pickle to the arraylist
							Meal noGarlic = new Sandwich(); // create object from meal
							((Sandwich) noGarlic).withoutGarlic(); // make the sandwich without garlic
							((Sandwich) noGarlic).makeItFish(); // make it fish sandwich
							makeItSpecial();
							setMeals(noGarlic);
						}
						else if (sandwichPercentage > 80  && sandwichPercentage <= 85){ // if the condition is true add normal fish sandwich without garlic and pickle to the arraylist
							Meal noPGSpicy = new Sandwich(); // create object from meal
							((Sandwich) noPGSpicy).withoutGarlic(); // make the sandwich without garlic
							((Sandwich) noPGSpicy).withoutPickles(); // make the sandwich without pickle
							((Sandwich) noPGSpicy).makeItFish(); // make it fish sandwich
							makeItSpecial();
							setMeals(noPGSpicy);
						}
						else if (sandwichPercentage > 85  && sandwichPercentage <= 90){ // if the condition is true add spicy fish sandwich without garlic and pickle to the arraylist
							Meal noPGSpicy = new Sandwich(); // create object from meal
							((Sandwich) noPGSpicy).makeSpicy(); // make the sandwich spicy
							((Sandwich) noPGSpicy).withoutGarlic(); // make the sandwich without garlic
							((Sandwich) noPGSpicy).withoutPickles(); // make the sandwich without pickle
							((Sandwich) noPGSpicy).makeItFish(); // make it fish sandwich
							makeItSpecial();
							setMeals(noPGSpicy);
						}
						else if (sandwichPercentage > 90 && sandwichPercentage <= 95){ // if the condition is true add spicy fish sandwich without pickle and with garlic to the arraylist
							Meal noPSpicy = new Sandwich(); // create object from meal
							((Sandwich) noPSpicy).makeSpicy(); // make the sandwich spicy
							((Sandwich) noPSpicy).withoutPickles(); // make the sandwich without pickle
							((Sandwich) noPSpicy).makeItFish(); // make it fish sandwich
							makeItSpecial();
							setMeals(noPSpicy);
						}
						else if(sandwichPercentage > 95 && sandwichPercentage <= 100){ // if the condition is true add spicy fish sandwich without garlic and with pickle to the arraylist
							Meal noGSpicy = new Sandwich(); // create object from meal
							((Sandwich) noGSpicy).makeSpicy(); // make the sandwich spicy
							((Sandwich) noGSpicy).withoutGarlic(); // make the sandwich without garlic
							((Sandwich) noGSpicy).makeItFish(); // make it fish sandwich
							makeItSpecial();
							setMeals(noGSpicy);
							}
					}
			}

	}
}
	
	
	public void generateOrderSnacks(int numberOfSnacks) { // method to generate snacks
		for(int i = 0 ; i < numberOfSnacks ; i++){ // loop to generate snacks
			int snackPercentage = Restaurant.getRandom(0, 101); // Generate a random number from 0 to 100
			if( snackPercentage == 0){ // if the condition is true exit the method 
				break; // delete this if
			}
			else if (snackPercentage <= 50){ // if the condition is true add iceCream to the arraylist
				numberOfIcecream++;
				setSnacks(new IceCream());
			}
			else if (snackPercentage > 50 && snackPercentage <= 80){ // if the condition is true add corn to the arraylist
				numberOfCorn++;
				setSnacks(new Corn());
			}
			else{ // if the condition is true add drinks to the arraylist
				numberOfDrinks++;
				setSnacks(new Drinks());
			}

		}
	}
	

	public ArrayList<Meal> getMeals() { // method to retrun all the meals
		return meals;
	}


	public void setMeals(Meal meals) { // method to add meals in the arraylist
		this.meals.add(meals);
		setOrderAmount();
	}


	public ArrayList<Snacks> getSnacks() { // method to retrun all the snacks
		return snacks;
	}


	public void setSnacks(Snacks snacks) {// method to add snacks in the arraylist
		this.snacks.add(snacks);
		setOrderAmount();
	}


	public int getOrderNumber() { // method to retrun order number
		return orderNumber;
	}


	public void setOrderNumber(int orderNumber) { // method to enter order number
		this.orderNumber = orderNumber;
	}


	public int getOrderAmount() { // method to retrun order amount
		return orderAmount;
	}


	public void setOrderAmount() { // maybe deleted method to enter order amount
		orderAmount ++;
	}


	public boolean getisItSpecial() { // method to retrun isitSpecial
		return isitSpecial;
	}


	public void makeItSpecial() { // method to change the variable isitSpecial to true
			isitSpecial= true;
	}


	public int getNumberOfBroast() { // method to return number of broast
		return numberOfBroast;
	}


	public int getNumberOfNuggets() { // method to return number of nuggets
		return numberOfNuggets;
	}


	public int getNumberOfJumboShrimp() { // method to return number of jumboShrimp
		return numberOfJumboShrimp;
	}


	public int getNumberOfSandwich() { // method to return number of snadwich
		return numberOfSandwich;
	}
	

	public int getNumberOfIcecream() { // method to return number of icecream
		return numberOfIcecream;
	}


	public int getNumberOfCorn() { // method to return number of corn
		return numberOfCorn;
	}


	public int getNumberOfDrinks() { // method to return number of drinks
		return numberOfDrinks;
	}
	public ArrayList<Spicable> getSpicable() {// method to return spicable array content spicable meals
		ArrayList<Spicable> spicableNew = new ArrayList<Spicable>();
		for(int i=0; i<= meals.size()-1;i++) {
			if(meals.get(i) instanceof Spicable) {
				spicableNew.add((Spicable) meals.get(i));}  
        }
		spicable = spicableNew;
		return spicable; 
	}
	
	public int getNumberOfBroastSpicy() { // method to return number of BroastSpicy
		int counterBroastSpicy = 0;
		ArrayList<Spicable> lookingForSpicyBroast = getSpicable();
		
		for(int i=0; i<= (lookingForSpicyBroast.size()-1);i++) {
			
			if(lookingForSpicyBroast.get(i) instanceof Broast) {
				
				Broast singlebroast = (Broast)lookingForSpicyBroast.get(i);
				if(singlebroast.isItSpicy()) {
				counterBroastSpicy++;}
				}
		}
		
		return counterBroastSpicy;
		}
	
	public int getNumberOfBroastNormal() { // method to return number of BroastNormal
		int counterForBroast = 0;
		ArrayList<Spicable> lookingForBroast = getSpicable();
		for(int i=0; i<= lookingForBroast.size()-1;i++) {
			if((lookingForBroast.get(i) instanceof Broast)) {
			Broast singlebroast = (Broast)lookingForBroast.get(i);
			if(!(singlebroast.isItSpicy())) {
			counterForBroast++;}
			}
		}
		
		
		return counterForBroast;
	}
	
	public int getNumberOfNuggetsSpicy() { // method to return number of NuggetsSpicy
		int counterNuggetsSpicy = 0;
		ArrayList<Spicable> lookingForNuggetsSpicy = getSpicable();
		for(int i=0; i<= lookingForNuggetsSpicy.size()-1;i++) {
			if((lookingForNuggetsSpicy.get(i) instanceof Nuggets)) {
				Nuggets singleNuggets = (Nuggets)lookingForNuggetsSpicy.get(i);
			if(singleNuggets.isItSpicy()) {
			counterNuggetsSpicy++;}
			}
		}
		
		
		return counterNuggetsSpicy;
	}
	public int getNumberOfNuggetsNormal() { // method to return number of NuggetsNormal
		int counterNuggets = 0;
		ArrayList<Spicable> lookingForNuggets = getSpicable();
		for(int i=0; i<= lookingForNuggets.size()-1;i++) {
			if((lookingForNuggets.get(i) instanceof Nuggets)) {
				Nuggets singleNuggets = (Nuggets)lookingForNuggets.get(i);
			if(!(singleNuggets.isItSpicy())) {
				counterNuggets++;}
			}
		}
		
		
		return counterNuggets;
	}
}
