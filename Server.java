import java.util.ArrayList;

// array of meal
// array of snacks 
//  order number 

// data field
//avalibale false
//brost = order.brost

/* check Snacks
 *  
 *  {


/*
/* check number of the order
 * if n >1000 online
 * else normal
 * */

/* check meal
 * need avaliable variable 
 * while loop bench emty
 * remover order
 * 
 * need method take from bench void
 * */

/* check Snacks
 * 
 * */

/* check sandwitch
 * array sand 
 * 
 * */





public class Server {

	private Order customerOrder;
	private Customers customerSarve;
	private ArrayList<Meal> meals = new ArrayList<Meal>();
	private ArrayList<Snacks> snacks = new ArrayList<Snacks>();
	private ArrayList<IceCream> icecream = new ArrayList<IceCream>();
	private ArrayList<Drinks> drinks = new ArrayList<Drinks>();
	private boolean avaliable;
 
	

	public void preaperorder(int order, ArrayList<Food> foodArray ) {
		while (order !=0) {
			if (foodArray.size() >= 1) {
				foodArray.remove(0);
				order--;}
		}
		
	}
	
	public void makeIceCream(IceCream icecream) {
		this.icecream.add(icecream);
	}
	
	public void makeDrinks(Drinks drinks) {
		this.drinks.add(drinks);
}

	public Order getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(Order customerOrder) {
		this.customerOrder = customerOrder;
	}

	public Customers getCustomerSarve() {
		return customerSarve;
	}

	public void setCustomerSarve(Customers customerSarve) {
		this.customerSarve = customerSarve;
	}
}






