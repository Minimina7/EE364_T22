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
	double Random1 = Math.random();
	Random Random2 = new Random();
	// constructor
	public Order() {
	}
	
	
	
	// for Talal
	public Meal generateOrderMeal() {
		
		Meal x = null;
		return x;
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
