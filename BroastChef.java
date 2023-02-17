import java.util.ArrayList;

public class BroastChef extends Chef{
	
private int spicyAmount; // instance variable that save the amount of spicy broast
private int normalAmount; // instance variable that save the amount of normal broast
private int timeNeededToCooke; // 12 minutes needs to cooke broast
private int timeStartCookeNormal; // the time that the chef start cooking normal broast
private int timeStartCookeSpicy; // the time that the chef start cooking spicy broast
private boolean chefIsCookingNormal; // instance variable to check is the chef is cooking or not
private boolean chefIsCookingSpicy; // instance variable to check is the chef is cooking or not
private ArrayList<Food> broastMadeSpicy = new ArrayList<Food>(); // ArrayList that save spicy broast made 
private ArrayList<Food> broastMadeNormal = new ArrayList<Food>(); // ArrayList that save normal broast made 

    // constructor
	public BroastChef() {
		Broast broast = new Broast();
		timeNeededToCooke = broast.PREPARETIME;
	}

// Method that add broast to the beanch if needed
public void checkBeanch(Bench spicyBroast,Bench normalBroast, int time) {
	
	ArrayList<Broast>spicyBroastArray = spicyBroast.getBench();
	ArrayList<Broast>normalBroastArray = normalBroast.getBench();
	
			spicyAmount = spicyBroastArray.size();
			if (!(chefIsCookingSpicy)) {
			if(spicyAmount<8) {
				broastMadeSpicy = cookeSpicy(8);
				timeStartCookeSpicy=time;
				chefIsCookingSpicy=true;
			}
			}
		
			normalAmount = normalBroastArray.size();
		if (!(chefIsCookingNormal)) {
		if(normalAmount<8) {
			broastMadeNormal = cookeNormal(8);
			timeStartCookeNormal=time;
			chefIsCookingNormal=true;
		}
		}
		
	spicyAmount=0;
	normalAmount=0;
	if (time==(timeNeededToCooke+timeStartCookeSpicy)) {
	if (!(broastMadeSpicy.isEmpty())) {
		spicyBroast.addToBench(broastMadeSpicy);
		broastMadeSpicy.clear();
		chefIsCookingSpicy=false;
	}}
	if (time==(timeNeededToCooke+timeStartCookeNormal)) {
	if (!(broastMadeNormal.isEmpty())) {
		normalBroast.addToBench(broastMadeNormal);
		broastMadeNormal.clear();
		chefIsCookingNormal=false;
	}
	}
}
	
    // To cooke spicy broast
	public ArrayList<Food> cookeSpicy(int amount) {
		ArrayList<Food> broastMadeSpicy = cookeNormal(amount);
		for(int i=0; i <= (broastMadeSpicy.size())-1;i++) {
			Broast singelBroast = (Broast)broastMadeSpicy.get(i);
			singelBroast.makeSpicy();
		}
		return broastMadeSpicy;
			
	}
	
	// To cooke normal broast
	public ArrayList<Food> cookeNormal(int amount) {
		ArrayList<Food> broastMadeNormal = new ArrayList<Food>();
			for (int i=0;i<amount;i++) {
				Broast singelBroast = new Broast();
				broastMadeNormal.add(singelBroast);
			}
			return broastMadeNormal;
		}
	
	public int getTimeNeededToCooke() {
		return Broast.PREPARETIME;
	}
	
}

