import java.util.ArrayList;

public class BroastChef extends Chef{
	
	public BroastChef() {
		Broast broast = new Broast();
		timeNeededToCooke = broast.PREPARETIME;
	}
	
private int spicyAmount;
private int normalAmount;
private int timeNeededToCooke;
private int timeStartCookeNormal;
private int timeStartCookeSpicy;
private boolean chefIsCookingNormal;
private boolean chefIsCookingSpicy;
private ArrayList<Food> broastMadeSpicy = new ArrayList<Food>();
private ArrayList<Food> broastMadeNormal = new ArrayList<Food>();


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
	
	public ArrayList<Food> cookeSpicy(int amount) {
		ArrayList<Food> broastMadeSpicy = cookeNormal(amount);
		for(int i=0; i <= (broastMadeSpicy.size())-1;i++) {
			Broast singelBroast = (Broast)broastMadeSpicy.get(i);
			singelBroast.makeSpicy();
		}
		return broastMadeSpicy;
			
	}
	
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

