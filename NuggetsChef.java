import java.util.ArrayList;

public class NuggetsChef extends Chef{
	
	public NuggetsChef() {
		Nuggets nuggets = new Nuggets();
		timeNeededToCooke = nuggets.PREPARETIME;
	}
	
private int spicyAmount;
private int normalAmount;
private int timeNeededToCooke;
private int timeStartCooke;
private boolean chefIsCooking;
private ArrayList<Food> nuggetsMade;

	public void checkBeanch(ArrayList<Food> nuggets, int time) {
		for(int i=0; i < nuggets.size();i++) {
			
			Nuggets singelNuggets = (Nuggets)nuggets.get(i);
			if(singelNuggets.isItSpicy()){
				spicyAmount++;
				if (!(chefIsCooking)) {
				if(spicyAmount<8) {
					nuggetsMade = cookeSpicy(8);
					timeStartCooke=time;
					chefIsCooking=true;
				}
			}
			}
			else {
				normalAmount++;
			if (!(chefIsCooking)) {
			if(normalAmount<8) {
				nuggetsMade = cookeNormal(8);
				timeStartCooke=time;
				chefIsCooking=true;
			}
			}
			}
		}
		
		spicyAmount=0;
		normalAmount=0;
		if (!(nuggetsMade.isEmpty())) {
		addToBeanch(nuggetsMade,nuggets,time);
	}
	}
	
	public ArrayList<Food> cookeSpicy(int amount) {
		ArrayList<Food> nuggetsMadeSpicy = cookeNormal(amount);
		for(int i=0; i < nuggetsMadeSpicy.size();i++) {
			Nuggets singelNuggets = (Nuggets)nuggetsMadeSpicy.get(i);
			singelNuggets.makeSpicy();
		}
		return nuggetsMadeSpicy;
			
	}
	
	public ArrayList<Food> cookeNormal(int amount) {
		ArrayList<Food> nuggetsMadeNormal = null;
			for (int i=0;i<amount;i++) {
				Nuggets singelNuggets = new Nuggets();
				nuggetsMadeNormal.add(singelNuggets);
			}
			return nuggetsMadeNormal;
		}
	
	public void addToBeanch(ArrayList<Food> nuggetsMade , ArrayList<Food> nuggetsBeanch , int time) {
		if (time==(timeNeededToCooke+timeStartCooke)){
			for (int i=0;i<nuggetsMade.size();i++) {
				nuggetsBeanch.add(nuggetsBeanch.size(), nuggetsMade.get(i));
			}
			nuggetsMade.clear();
		}
	}
	
	public int getTimeNeededToCooke() {
		return Nuggets.PREPARETIME;
	}
	
}

