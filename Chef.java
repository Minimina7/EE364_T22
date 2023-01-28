import java.util.ArrayList;

public abstract class Chef {

	private int amountMade;
	private int timeNeedsToCooke;
	private ArrayList<Meal> spicymeals = new ArrayList<Meal>();
	private ArrayList<Meal> normalmeals = new ArrayList<Meal>();
	
	public abstract void cookeSpicy();
	public abstract void cookeNormal();
	

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
	
	public abstract int checkBench();
	
	public abstract int addToBench();
	
	public abstract int getTimeNeededToCooke();
}


