import java.util.Random;
import java.util.ArrayList;

public class Order {
	private ArrayList<Meal> meals = new ArrayList<Meal>();
	private ArrayList<Snacks> snacks = new ArrayList<Snacks>();
	private int orderNumber;
	private int orderAmount = 0;
	private boolean isitSpecial;
	
	// to generate an Order
	// we can use random seed
	Random Random = new Random();
	// constructor
	public Order() {
		generateOrderMeal();
		generateOrderSnacks();
		//number of snaks must be rilstc : no 1meal and 12 drinks
		
	}
	
	
	
	// for Talal
	// make it static to use in constrvter?
	public void generateOrderMeal() {

		for(int i = 0 ; i < 4 ; i++){
			int x = Random.nextInt(101);
			int y = Random.nextInt(101);
			if( x == 0){
				break;
			}
			else if ( x <= 35){
				if (x > 25 && x <= 35){
					Meal spicy = new Broast();
					((Broast) spicy).makeSpicy();
					setMeals(spicy);
				}
				else
				setMeals(new Broast());
			}
				else if ( x > 35 && x <= 70){
					if (x > 60 && x <= 70){
						Meal spicy = new Nuggets();
						((Nuggets) spicy).makeSpicy();
						setMeals(spicy);
					}
					else
					setMeals(new Nuggets());
			}
					else if ( x > 70 && x <= 75){
						setMeals(new JumboShrimp());
					}
						else if ( x > 75 && x <= 100){
							if (x > 75 && x <= 90){
								if ( y <= 50){
									setMeals(new Sandwich());
								}
								else if (y > 50 && y <= 60){
									Meal spicy = new Sandwich();
									((Sandwich) spicy).makeSpicy();
									setMeals(spicy);
								}
								else if (y > 60 && y <= 70){
									Meal noPickle = new Sandwich();
									((Sandwich) noPickle).withoutPickles();
									setMeals(noPickle);
								}
								else if (y > 70 && y <= 80){
									Meal noGarlic = new Sandwich();
									((Sandwich) noGarlic).withoutGarlic();
									setMeals(noGarlic);
								}
								else if (y > 80  && y <= 90){
									Meal noPGSpicy = new Sandwich();
									((Sandwich) noPGSpicy).makeSpicy();
									((Sandwich) noPGSpicy).withoutGarlic();
									((Sandwich) noPGSpicy).withoutPickles();
									setMeals(noPGSpicy);
								}
								else if (y > 90 && y <= 95){
									Meal noPSpicy = new Sandwich();
									((Sandwich) noPSpicy).makeSpicy();
									((Sandwich) noPSpicy).withoutPickles();
									setMeals(noPSpicy);
								}
								else if(y > 95 && y <= 100){
									Meal noGSpicy = new Sandwich();
									((Sandwich) noGSpicy).makeSpicy();
									((Sandwich) noGSpicy).withoutGarlic();
									setMeals(noGSpicy);
									}
					}
					else{
						if ( y <= 50){
							Meal fish = new Sandwich();
							((Sandwich) fish).makeItFish();
								setMeals(fish);
						}
						else if (y > 50 && y <= 60){
							Meal spicy = new Sandwich();
							((Sandwich) spicy).makeSpicy();
							((Sandwich) spicy).makeItFish();
							setMeals(spicy);
						}
						else if (y > 60 && y <= 70){
							Meal noPickle = new Sandwich();
							((Sandwich) noPickle).withoutPickles();
							((Sandwich) noPickle).makeItFish();
							setMeals(noPickle);
						}
						else if (y > 70 && y <= 80){
							Meal noGarlic = new Sandwich();
							((Sandwich) noGarlic).withoutGarlic();
							((Sandwich) noGarlic).makeItFish();
							setMeals(noGarlic);
						}
						else if (y > 80  && y <= 90){
							Meal noPGSpicy = new Sandwich();
							((Sandwich) noPGSpicy).makeSpicy();
							((Sandwich) noPGSpicy).withoutGarlic();
							((Sandwich) noPGSpicy).withoutPickles();
							((Sandwich) noPGSpicy).makeItFish();
							setMeals(noPGSpicy);
						}
						else if (y > 90 && y <= 95){
							Meal noPSpicy = new Sandwich();
							((Sandwich) noPSpicy).makeSpicy();
							((Sandwich) noPSpicy).withoutPickles();
							((Sandwich) noPSpicy).makeItFish();
							setMeals(noPSpicy);
						}
						else if(y > 95 && y <= 100){
							Meal noGSpicy = new Sandwich();
							((Sandwich) noGSpicy).makeSpicy();
							((Sandwich) noGSpicy).withoutGarlic();
							((Sandwich) noGSpicy).makeItFish();
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
	public boolean setisitSpecial() {
		Sandwich checkSandwich = new Sandwich();
		if(!checkSandwich.checkGarlic() || !checkSandwich.checkPickles()){
			return true;
		}
		else
		return false;
	}



}
