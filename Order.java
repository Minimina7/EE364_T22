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
	Random Random = new Random(); // declare random object


	// constructor
	public Order() {
		int amountMeal = Random.nextInt(21); // from 0 to 20
		generateOrderMeal(amountMeal);
		int amountSnacks = Random.nextInt(20 -amountMeal)+ 1; // from 1 to 20-
		generateOrderSnacks(amountSnacks);
		//number of snaks must be rilstc : no 1meal and 12 drinks
	}
	
	
	
	
	public void generateOrderMeal(int numberOfMeal) {

		for(int i = 0 ; i < numberOfMeal ; i++){
			int mealPercentage = Random.nextInt(101);
			int sandwichPercentage = Random.nextInt(101);
			if( mealPercentage == 0){
				break;
			}
			else if ( mealPercentage <= 35){
				numberOfBroast++;
				if (mealPercentage > 25 && mealPercentage <= 35){
					Meal spicy = new Broast();
					((Broast) spicy).makeSpicy();
					setMeals(spicy);
				}
				else
				setMeals(new Broast());
			}
				else if ( mealPercentage > 35 && mealPercentage <= 70){
					numberOfNuggets++;
					if (mealPercentage > 60 && mealPercentage <= 70){
						Meal spicy = new Nuggets();
						((Nuggets) spicy).makeSpicy();
						setMeals(spicy);
					}
					else
					setMeals(new Nuggets());
			}
					else if ( mealPercentage > 70 && mealPercentage <= 75){
						numberOfJumboShrimp++;
						setMeals(new JumboShrimp());
					}
						else if ( mealPercentage > 75 && mealPercentage <= 100){
							numberOfSandwich++;
							if (mealPercentage > 75 && mealPercentage <= 90){
								if ( sandwichPercentage <= 50){
									setMeals(new Sandwich());
								}
								else if (sandwichPercentage > 50 && sandwichPercentage <= 60){
									Meal spicy = new Sandwich();
									((Sandwich) spicy).makeSpicy();
									setMeals(spicy);
								}
								else if (sandwichPercentage > 60 && sandwichPercentage <= 70){
									Meal noPickle = new Sandwich();
									((Sandwich) noPickle).withoutPickles();
									makeItSpecial();
									setMeals(noPickle);
								}
								else if (sandwichPercentage > 70 && sandwichPercentage <= 80){
									Meal noGarlic = new Sandwich();
									((Sandwich) noGarlic).withoutGarlic();
									makeItSpecial();
									setMeals(noGarlic);
								}
								else if (sandwichPercentage > 80  && sandwichPercentage <= 90){
									Meal noPGSpicy = new Sandwich();
									((Sandwich) noPGSpicy).makeSpicy();
									((Sandwich) noPGSpicy).withoutGarlic();
									((Sandwich) noPGSpicy).withoutPickles();
									makeItSpecial();
									setMeals(noPGSpicy);
								}
								else if (sandwichPercentage > 90 && sandwichPercentage <= 95){
									Meal noPSpicy = new Sandwich();
									((Sandwich) noPSpicy).makeSpicy();
									((Sandwich) noPSpicy).withoutPickles();
									makeItSpecial();
									setMeals(noPSpicy);
								}
								else if(sandwichPercentage > 95 && sandwichPercentage <= 100){
									Meal noGSpicy = new Sandwich();
									((Sandwich) noGSpicy).makeSpicy();
									((Sandwich) noGSpicy).withoutGarlic();
									makeItSpecial();
									setMeals(noGSpicy);
									}
					}
					else{
						if ( sandwichPercentage <= 50){
							Meal fish = new Sandwich();
							((Sandwich) fish).makeItFish();
								setMeals(fish);
						}
						else if (sandwichPercentage > 50 && sandwichPercentage <= 60){
							Meal spicy = new Sandwich();
							((Sandwich) spicy).makeSpicy();
							((Sandwich) spicy).makeItFish();
							setMeals(spicy);
						}
						else if (sandwichPercentage > 60 && sandwichPercentage <= 70){
							Meal noPickle = new Sandwich();
							((Sandwich) noPickle).withoutPickles();
							((Sandwich) noPickle).makeItFish();
							makeItSpecial();
							setMeals(noPickle);
						}
						else if (sandwichPercentage > 70 && sandwichPercentage <= 80){
							Meal noGarlic = new Sandwich();
							((Sandwich) noGarlic).withoutGarlic();
							((Sandwich) noGarlic).makeItFish();
							makeItSpecial();
							setMeals(noGarlic);
						}
						else if (sandwichPercentage > 80  && sandwichPercentage <= 90){
							Meal noPGSpicy = new Sandwich();
							((Sandwich) noPGSpicy).makeSpicy();
							((Sandwich) noPGSpicy).withoutGarlic();
							((Sandwich) noPGSpicy).withoutPickles();
							((Sandwich) noPGSpicy).makeItFish();
							makeItSpecial();
							setMeals(noPGSpicy);
						}
						else if (sandwichPercentage > 90 && sandwichPercentage <= 95){
							Meal noPSpicy = new Sandwich();
							((Sandwich) noPSpicy).makeSpicy();
							((Sandwich) noPSpicy).withoutPickles();
							((Sandwich) noPSpicy).makeItFish();
							makeItSpecial();
							setMeals(noPSpicy);
						}
						else if(sandwichPercentage > 95 && sandwichPercentage <= 100){
							Meal noGSpicy = new Sandwich();
							((Sandwich) noGSpicy).makeSpicy();
							((Sandwich) noGSpicy).withoutGarlic();
							((Sandwich) noGSpicy).makeItFish();
							makeItSpecial();
							setMeals(noGSpicy);
							}
					}
			}

	}
}
	
	
	
	public void generateOrderSnacks(int numberOfSnacks) {
		for(int i = 0 ; i < numberOfSnacks ; i++){
			int snackPercentage = Random.nextInt(101);
			if( snackPercentage == 0){
				break;
			}
			else if (snackPercentage >= 50){
				numberOfIcecream++;
				setSnacks(new IceCream());
			}
			else{
				numberOfCorn++;
				setSnacks(new Corn());
			}

		}
	}
	
	
	
	public ArrayList<Meal> getMeals() { // method to retrun all the meals
		return meals;
	}




	public void setMeals(Meal meals) { // method to add meals in the arraylist
		this.meals.add(meals);
		orderAmount ++;
	}



	public ArrayList<Snacks> getSnacks() { // method to retrun all the snacks
		return snacks;
	}




	public void setSnacks(Snacks snacks) {// method to add snacks in the arraylist
		this.snacks.add(snacks);
		orderAmount ++;
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




	public void setOrderAmount(int orderAmount) { // method to enter order amount
		this.orderAmount = orderAmount;
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


}
