import java.util.Random;
import java.util.ArrayList;

public class Order {
	private ArrayList<Meal> meals = new ArrayList<Meal>();
	private ArrayList<Snacks> snacks = new ArrayList<Snacks>();
	private int orderNumber;
	private int orderAmount = 0;
	private boolean isitSpecial;
	Random Random = new Random();


	// constructor
	public Order() {
		int x = Random.nextInt(101);
		generateOrderMeal(5);
		generateOrderSnacks();
		//number of snaks must be rilstc : no 1meal and 12 drinks
		
	}
	
	
	
	
	public void generateOrderMeal(int numberOfmeal) {

		for(int i = 0 ; i < numberOfmeal ; i++){
			int mealPercentage = Random.nextInt(101);
			int sandwichPercentage = Random.nextInt(101);
			if( mealPercentage == 0){
				break;
			}
			else if ( mealPercentage <= 35){
				if (mealPercentage > 25 && mealPercentage <= 35){
					Meal spicy = new Broast();
					((Broast) spicy).makeSpicy();
					setMeals(spicy);
				}
				else
				setMeals(new Broast());
			}
				else if ( mealPercentage > 35 && mealPercentage <= 70){
					if (mealPercentage > 60 && mealPercentage <= 70){
						Meal spicy = new Nuggets();
						((Nuggets) spicy).makeSpicy();
						setMeals(spicy);
					}
					else
					setMeals(new Nuggets());
			}
					else if ( mealPercentage > 70 && mealPercentage <= 75){
						setMeals(new JumboShrimp());
					}
						else if ( mealPercentage > 75 && mealPercentage <= 100){
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
	
	
	// for Talal
	public Snacks generateOrderSnacks() {
		Snacks x = null;
		return x;
	}
	
	
	// check pls
	public ArrayList<Meal> getMeals() {
		return meals;
	}




	public void setMeals(Meal meals) {
		this.meals.add(meals);
		orderAmount ++;
	}



	public ArrayList<Snacks> getSnacks() {
		return snacks;
	}




	public void setSnacks(Snacks snacks) {
		this.snacks.add(snacks);
		orderAmount ++;
	}




	public int getOrderNumber() {
		return orderNumber;
	}




	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}




	public int getOrderAmount() {
		return orderAmount;
	}




	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}



	public boolean getisItSpecial() {
		return isitSpecial;
	}


	// for talal
	public void makeItSpecial() {
			isitSpecial= true;
	}



}
