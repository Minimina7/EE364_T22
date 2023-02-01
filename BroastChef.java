import java.util.ArrayList;

public class BroastChef extends Chef{
	
	public BroastChef() {
		Broast broast = new Broast();
		timeNeededToCooke = broast.PREPARETIME;
	}
	
private int spicyAmount;
private int normalAmount;
private int timeNeededToCooke;
private int timeStartCookeSpicy;
private int timeStartCookeNormal;


	public void checkBeanch(ArrayList<Food> broast, int time) {
		for(int i=0; i < broast.size();i++) {
			
			Broast singelBroast = (Broast)broast.get(i);
			if(singelBroast.isItSpicy()){
				spicyAmount++;
				
				if(spicyAmount<8) {
					cookeSpicy(8,timeNeededToCooke);
					timeStartCookeSpicy=time;
				}
			}
			else {
				normalAmount++;
				
			if(normalAmount<8) {
				cookeNormal(8,timeNeededToCooke);
				timeStartCookeNormal=time;
			}
			}
			}
		
		spicyAmount=0;
		normalAmount=0;
		
		addToBeanch(time);
	}
	
	public ArrayList<Food> cookeSpicy(int amount , int time) {
		ArrayList<Food> broastMadeSpicy = cookeNormal(amount , time);
		for(int i=0; i < broastMadeSpicy.size();i++) {
			Broast singelBroast = (Broast)broastMadeSpicy.get(i);
			singelBroast.makeSpicy();
		}
		return broastMadeSpicy;
			
	}
	
	public ArrayList<Food> cookeNormal(int amount , int time) {
		ArrayList<Food> broastMadeNormal = null;
			for (int i=0;i<amount;i++) {
				Broast singelBroast = new Broast();
				broastMadeNormal.add(singelBroast);
			}
			return broastMadeNormal;
		}
	
	public void addToBeanch(int time) {
		
	}
	
	public int getTimeNeededToCooke() {
		return Nuggets.PREPARETIME;
	}
	
}

