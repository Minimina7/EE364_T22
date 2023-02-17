import java.util.ArrayList;

public class NuggetsChef extends Chef{
	
	
private int spicyAmount; // instance variable that save the amount of spicy nuggets
private int normalAmount; // instance variable that save the amount of normal nuggets
private int timeNeededToCooke; // 10 minutes needs to cooke nuggets
private int timeStartCookeNormal; // the time that the chef start cooking normal nuggets
private int timeStartCookeSpicy; // the time that the chef start cooking spicy nuggets
private boolean chefIsCookingNormal; // instance variable to check is the chef is cooking or not
private boolean chefIsCookingSpicy; // instance variable to check is the chef is cooking or not
private ArrayList<Food> nuggetsMadeSpicy = new ArrayList<Food>(); // ArrayList that save spicy nuggets made 
private ArrayList<Food> nuggetsMadeNormal = new ArrayList<Food>(); // ArrayList that save normal nuggets made 

    // constructor
	public NuggetsChef() {
		Nuggets nuggets = new Nuggets();
		timeNeededToCooke = nuggets.PREPARETIME;
	}

	// Method that add nuggets to the beanch if needed
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
	
	// To cooke spicy nuggets
	public ArrayList<Food> cookeSpicy(int amount) {
		ArrayList<Food> nuggetsMadeSpicy = cookeNormal(amount);
		for(int i=0; i <= (nuggetsMadeSpicy.size())-1;i++) {
			Nuggets singelNuggets = (Nuggets)nuggetsMadeSpicy.get(i);
			singelNuggets.makeSpicy();
		}
		return nuggetsMadeSpicy;
			
	}
	
	// To cooke normal nuggets
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

