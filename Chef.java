import java.util.ArrayList;

public abstract class Chef {

	private int amountMade; // instance variable that save the amount made 
	private ArrayList<Meal> spicymeals; // ArrayList has all the spicy meals
	private ArrayList<Meal> normalmeals; // ArrayList has all the normal meals

	public ArrayList<Meal> getSpicymeals() {
		return spicymeals;
	}


	public void setSpicymeals(ArrayList<Meal> spicymeals) {
		this.spicymeals = spicymeals;
	}


	public ArrayList<Meal> getNormalmeals() {
		return normalmeals;
	}


	public void setNormalmeals(ArrayList<Meal> normalmeals) {
		this.normalmeals = normalmeals;
	}

	public abstract ArrayList<Food> cookeNormal(int amount);

	public int getAmountMade() {
		return amountMade;
	}
	
	 // method to add meals in the ArrayList
	public void setSpicyMeals(Meal meals) {
		this.spicymeals.add(meals);
		setAmountMade();
	}
	
	// method to add meals in the ArrayList
	public void setNormalMeals(Meal meals) { 
		this.normalmeals.add(meals);
		setAmountMade();
	}
	
	public void setAmountMade() {
		amountMade++;
	}
	
	
	public void setAmountMade(int amountMade) {
	    this.amountMade=amountMade;
	}
	
	public abstract int getTimeNeededToCooke();
	public abstract boolean isChefCooking();
	public abstract void firstCookNormal(Bench bench, int amount);
	
}


