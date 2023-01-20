import java.util.Random;
import java.util.ArrayList;

public class Order {
	private ArrayList<Meal> meals = new ArrayList<Meal>(); // arraylist has all the meals
	private ArrayList<Snacks> snacks = new ArrayList<Snacks>(); // arraylist has all the snacks
	private int orderNumber; // instance variable that save the order number
	private int orderAmount = 0; // instance variable that save the order amount
	private boolean isitSpecial; // instance variable to check is it special order
	private	int numberOfBroast = 0; // instance variable that count number of broast
	private	int numberOfNuggets = 0; // instance variable that count number of nugget
	private	int numberOfJumboShrimp = 0; // instance variable that count number of jumboShrimp
	private	int numberOfSandwich = 0; // instance variable that count number of sandwich
	private	int numberOfIcecream = 0; // instance variable that count number of icecream
	private	int numberOfCorn = 0; // instance variable that count number of corn
	private	int numberOfDrinks = 0; // instance variable that count number of drinks
	Random Random = new Random(); // declare random object


	// constructor
	public Order() {
		int amountMeal = Random.nextInt(21); // from 0 to 20
		generateOrderMeal(amountMeal);
		int amountSnacks = Random.nextInt(20 -amountMeal)+ 1; // from 1 to 20-
		generateOrderSnacks(amountSnacks);
		//number of snaks must be rilstc : no 1meal and 12 drinks
	}
	
	
	public void generateOrderMeal(int numberOfMeal) { // method to generate meals

		for(int i = 0 ; i < numberOfMeal ; i++){ // loop to generate meals
			int mealPercentage = Random.nextInt(101); // Generate a random number from 0 to 100
			int sandwichPercentage = Random.nextInt(101); // Generate a random number from 0 to 100
			if( mealPercentage == 0){ // if the condition is true exit the method 
				break;
			}
			else if ( mealPercentage <= 35){ // if the condition is true add broast to the arraylist
				numberOfBroast++;
				if (mealPercentage > 25 && mealPercentage <= 35){ // if the condition is true the broast is spicy
					Meal spicy = new Broast(); // create object from meal
					((Broast) spicy).makeSpicy(); // make the broast spicy
					setMeals(spicy); // add spicy broast to the arraylist
				}
				else
				setMeals(new Broast()); // add normal broast to the arraylist
			}
				else if ( mealPercentage > 35 && mealPercentage <= 70){ // if the condition is true add nuggets to the arraylist
					numberOfNuggets++;
					if (mealPercentage > 60 && mealPercentage <= 70){ // if the condition is true the nuggets is spicy
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
			int snackPercentage = Random.nextInt(101); // Generate a random number from 0 to 100
			if( snackPercentage == 0){ // if the condition is true exit the method 
				break;
			}
			else if (snackPercentage >= 50){ // if the condition is true add iceCream to the arraylist
				numberOfIcecream++;
				setSnacks(new IceCream());
			}
			else if (snackPercentage > 50 && snackPercentage <= 80){ // if the condition is true add corn to the arraylist
				numberOfIcecream++;
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
}
