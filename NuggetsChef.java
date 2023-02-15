import java.util.ArrayList;

public class NuggetsChef extends Chef{
	
	public NuggetsChef() {
		Nuggets nuggets = new Nuggets();
		timeNeededToCooke = nuggets.PREPARETIME;
	}
	
private int spicyAmount;
private int normalAmount;
private int timeNeededToCooke;
private int timeStartCookeNormal;
private boolean chefIsCookingNormal;
private int timeStartCookeSpicy;
private boolean chefIsCookingSpicy;
private ArrayList<Food> nuggetsMadeSpicy = new ArrayList<Food>();
private ArrayList<Food> nuggetsMadeNormal = new ArrayList<Food>();

	public void checkBeanch(Bench spicyNuggets,Bench normalNuggets, int time) {
		
		ArrayList<Nuggets>spicyNuggetsArray = spicyNuggets.getBench();
		ArrayList<Nuggets>normalNuggetsArray = normalNuggets.getBench();
		
				spicyAmount = spicyNuggetsArray.size();
				if (!(chefIsCookingSpicy)) {
				if(spicyAmount<8) {
					nuggetsMadeSpicy = cookeSpicy(8);
					timeStartCookeSpicy=time;
					chefIsCookingSpicy=true;
				}
				}
		
				normalAmount = normalNuggetsArray.size();
			if (!(chefIsCookingNormal)) {
			if(normalAmount<8) {
				nuggetsMadeNormal = cookeNormal(8);
				timeStartCookeNormal=time;
				chefIsCookingNormal=true;
			}
			}
			
		spicyAmount=0;
		normalAmount=0;
		
		if (time==(timeNeededToCooke+timeStartCookeSpicy)) {
		if (!(nuggetsMadeSpicy.isEmpty())) {
			spicyNuggets.addToBench(nuggetsMadeSpicy);
			nuggetsMadeSpicy.clear();
			chefIsCookingSpicy=false;
			}}
		if (time==(timeNeededToCooke+timeStartCookeNormal)) {
		if (!(nuggetsMadeNormal.isEmpty())) {
			normalNuggets.addToBench(nuggetsMadeNormal);
			nuggetsMadeNormal.clear();
			chefIsCookingNormal=false;
		}
		}
	}
	
	public ArrayList<Food> cookeSpicy(int amount) {
		ArrayList<Food> nuggetsMadeSpicy = cookeNormal(amount);
		for(int i=0; i <= (nuggetsMadeSpicy.size())-1;i++) {
			Nuggets singelNuggets = (Nuggets)nuggetsMadeSpicy.get(i);
			singelNuggets.makeSpicy();
		}
		return nuggetsMadeSpicy;
			
	}
	
	public ArrayList<Food> cookeNormal(int amount) {
		ArrayList<Food> nuggetsMadeNormal = new ArrayList<Food>();
			for (int i=0;i<amount;i++) {
				Nuggets singelNuggets = new Nuggets();
				nuggetsMadeNormal.add(singelNuggets);
			}
			return nuggetsMadeNormal;
		}
	
	
	public int getTimeNeededToCooke() {
		return Nuggets.PREPARETIME;
	}
	
}

