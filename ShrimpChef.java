
public class ShrimpChef extends Chef{
	
	Meal normal=new JumboShrimp();
	
	
	public void cookeSpicy(int x,Meal y) {
		
	}
	
	public void cookeNormal(int x,Meal y) {
			for (int i=0;i<x;i++) {
			setNormalMeals(y);
			}
		}
	
	
    public int checkBench() {
    	return;
    }
    
	public int addToBench() {
		return;
	}
	
	public int getTimeNeededToCooke() {
		return JumboShrimp.PREPARETIME;
	}
}

