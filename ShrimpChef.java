import java.util.ArrayList;

public class ShrimpChef extends Chef{
	
	public ShrimpChef() {
		JumboShrimp shrimp = new JumboShrimp();
		timeNeededToCooke = shrimp.PREPARETIME;
	}
	
private int normalAmount;
private int timeNeededToCooke;
private int timeStartCookeNormal;


	public void checkBeanch(ArrayList<Food> shrimp, int time) {
		for(int i=0; i < shrimp.size();i++) {
			
			JumboShrimp singelshrimp = (JumboShrimp)shrimp.get(i);
			
				normalAmount++;
				
			if(normalAmount<8) {
				cookeNormal(8,timeNeededToCooke);
				timeStartCookeNormal=time;
			}
			}

		normalAmount=0;
		
		addToBeanch(time);
	}
	
	public ArrayList<Food> cookeSpicy(int amount , int time){
		return null;
	}
	
	public ArrayList<Food> cookeNormal(int amount , int time) {
		ArrayList<Food> shrimpMadeNormal = null;
			for (int i=0;i<amount;i++) {
				JumboShrimp singelShrimp = new JumboShrimp();
				shrimpMadeNormal.add(singelShrimp);
			}
			return shrimpMadeNormal;
		}
	
	public void addToBeanch(int time) {
		
	}
	
	public int getTimeNeededToCooke() {
		return Nuggets.PREPARETIME;
	}
	
}

