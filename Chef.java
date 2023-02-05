import java.util.ArrayList;

public abstract class Chef {

	private int amountMade;
	//private int timeNeedsToCooke;
	private ArrayList<Meal> spicymeals;
	private ArrayList<Meal> normalmeals;
	
	//public abstract void getBeanch(ArrayList<Meal> meals, int time);
		
	
	
	
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


	//public abstract ArrayList<Food> cookeSpicy(int amount);
	public abstract ArrayList<Food> cookeNormal(int amount);
	//public abstract void checkBeanch(Beanch food, int time);

	public int getAmountMade() {
		return amountMade;
	}
	
	public void setSpicyMeals(Meal meals) { // method to add meals in the arraylist
		this.spicymeals.add(meals);
		setAmountMade();
	}
	
	public void setNormalMeals(Meal meals) { // method to add meals in the arraylist
		this.normalmeals.add(meals);
		setAmountMade();
	}
	
	public void setAmountMade() {
		amountMade++;
	}
	
	
	public void setAmountMade(int amountMade) {
	    this.amountMade=amountMade;
	}
	
	//public abstract void addToBeanch(ArrayList<Food> foodBeanch , int time);
	
	public abstract int getTimeNeededToCooke();
}


