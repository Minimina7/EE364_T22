
import java.util.ArrayList;

public class NuggetsChef extends Chef{
	//getSpicymeals()= new ArrayList<Meal>();
	public NuggetsChef() {
		Nuggets nuggets = new Nuggets();
		timeNeededToCooke = nuggets.PREPARETIME;
	}
	//Meal spicy=new Nuggets();
	//((Nuggets) spicy).makeSpicy();
	//Meal normal=new Nuggets();
	//cookeSpicy(nofspicy,spicy);
	//cookeNormal(nofnormal,normal);
	
private int spicyAmount;
private int normalAmount;
private int timeNeededToCooke;
private int timeStartCookeSpicy;
private int timeStartCookeNormal;


	public void checkBeanch(ArrayList<Nuggets> nuggets, int time) {
		for(int i=0; i < nuggets.size();i++) {
			
			Nuggets singelNuggets = nuggets.get(i);
			if(singelNuggets.isItSpicy()){
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
	
	public ArrayList<Nuggets> cookeSpicy(int amount , int time) {
		ArrayList<Nuggets> nuggetsMadeSpicy = cookeNormal(amount , time);
		for(int i=0; i < nuggetsMadeSpicy.size();i++) {
			Nuggets singelNuggets = nuggetsMadeSpicy.get(i);
			singelNuggets.makeSpicy();
		}
		return nuggetsMadeSpicy;
			
	}
	
	public ArrayList<Nuggets> cookeNormal(int amount , int time) {
		ArrayList<Nuggets> nuggetsMadeNormal = null;
			for (int i=0;i<amount;i++) {
				Nuggets singelNuggets = new Nuggets();
				nuggetsMadeNormal.add(singelNuggets);
			}
			return nuggetsMadeNormal;
		}
	
   
    
	
	public void addToBeanch(int time) {
		
	}
	
	public int getTimeNeededToCooke() {
		return Nuggets.PREPARETIME;
	}	
}

