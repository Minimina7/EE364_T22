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
private ArrayList<Food> nuggetsMadeSpicy;
private ArrayList<Food> nuggetsMadeNormal;

	public void checkBeanch(Beanch spicyNuggets,Beanch normalNuggets, int time) {
		
		ArrayList<Nuggets>spicyNuggetsArray = spicyNuggets.getBeanch();
		ArrayList<Nuggets>normalNuggetsArray = normalNuggets.getBeanch();
		
				spicyAmount = spicyNuggetsArray.size();
				if (!(chefIsCooking)) {
				if(spicyAmount<8) {
					nuggetsMadeSpicy = cookeSpicy(8);
					timeStartCooke=time;
					chefIsCooking=true;
				}
				}
		
				normalAmount = normalNuggetsArray.size();
			if (!(chefIsCooking)) {
			if(normalAmount<8) {
				nuggetsMadeNormal = cookeNormal(8);
				timeStartCooke=time;
				chefIsCooking=true;
			}
			}
			
		spicyAmount=0;
		normalAmount=0;
		
		if (time==(timeNeededToCooke+timeStartCooke)) {
		if (!(nuggetsMadeSpicy.isEmpty())) {
			spicyNuggets.addToBeanch(nuggetsMadeSpicy);
			nuggetsMadeSpicy.clear();
			chefIsCooking=false;
			}
		
		if (!(nuggetsMadeNormal.isEmpty())) {
			normalNuggets.addToBeanch(nuggetsMadeNormal);
			nuggetsMadeNormal.clear();
			chefIsCooking=false;
		}
		}
	}
	
	public ArrayList<Food> cookeSpicy(int amount) {
		ArrayList<Food> nuggetsMadeSpicy = cookeNormal(amount);
		for(int i=0; i < (nuggetsMadeSpicy.size())-1;i++) {
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
	
	/*public void addToBeanch(ArrayList<Food> nuggetsBeanch , int time) {
		if (time==(timeNeededToCooke+timeStartCooke)){
			for (int i=0;i<nuggetsMade.size();i++) {
				nuggetsBeanch.add(nuggetsBeanch.size(), nuggetsMade.get(i));
			}
			nuggetsMade.clear();
		}
	}*/
	
	public int getTimeNeededToCooke() {
		return Nuggets.PREPARETIME;
	}
	
}

