import java.util.ArrayList;

public class ShrimpChef extends Chef{
	
	public ShrimpChef() {
		JumboShrimp shrimp = new JumboShrimp();
		timeNeededToCooke = shrimp.PREPARETIME;
	}
	
private int normalAmount;
private int timeNeededToCooke;
private int timeStartCooke;
private boolean chefIsCooking;
private ArrayList<Food> shrimpMade = new ArrayList<Food>();

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
	
	public ArrayList<Food> cookeNormal(int amount) {
		ArrayList<Food> shrimpMadeNormal = new ArrayList<Food>();
			for (int i=0;i<amount;i++) {
				JumboShrimp singelShrimp = new JumboShrimp();
				shrimpMadeNormal.add(singelShrimp);
			}
			return shrimpMadeNormal;
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
		return JumboShrimp.PREPARETIME;
	}
	
}

