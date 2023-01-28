
public class ShrimpChef extends Chef{
	
	Meal spicy=new JumboShrimp();
	Meal normal=new JumboShrimp();
	
	public void cookeNormal(int x) {
			for (int i=0;i<x;i++) {
			setNormalMeals(normal);
			}
		}
	
    public int checkBench();
    
	
	public int addToBench();
	
	public int getTimeNeededToCooke() {
		return JumboShrimp.PREPARETIME;
	}
}

