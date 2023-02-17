import java.util.ArrayList;

public class ShrimpChef extends Chef{
	
private int normalAmount; // instance variable that save the amount of normal shrimp
private int timeNeededToCooke; // 10 minutes needs to cooke shrimp
private int timeStartCooke; // the time that the chef start cooking shrimp
private boolean chefIsCooking; // instance variable to check is the chef is cooking or not
private ArrayList<Food> shrimpMade = new ArrayList<Food>(); // ArrayList that save shrimp made 

    // constructor
	public ShrimpChef() {
		JumboShrimp shrimp = new JumboShrimp();
		timeNeededToCooke = shrimp.PREPARETIME;
	}

	// Method that add shrimp to the beanch if needed
	public void checkBeanch(Bench shrimp, int time) {
		
		ArrayList<JumboShrimp>shrimpArray = shrimp.getBench();
	
				normalAmount = shrimpArray.size();
			if (!(chefIsCooking)) {
			if(normalAmount<8) {
				shrimpMade = cookeNormal(8);
				timeStartCooke=time;
				chefIsCooking=true;
			}
			}
		
		normalAmount=0;
		if (time==(timeNeededToCooke+timeStartCooke)) {
		if (!(shrimpMade.isEmpty())) {
		shrimp.addToBench(shrimpMade);
		shrimpMade.clear();
		chefIsCooking = false;
		}
		}
	}
	
	// To cooke normal shrimp
	public ArrayList<Food> cookeNormal(int amount) {
		ArrayList<Food> shrimpMadeNormal = new ArrayList<Food>();
			for (int i=0;i<amount;i++) {
				JumboShrimp singelShrimp = new JumboShrimp();
				shrimpMadeNormal.add(singelShrimp);
			}
			return shrimpMadeNormal;
		}
	
	public int getTimeNeededToCooke() {
		return JumboShrimp.PREPARETIME;
	}
	
}

