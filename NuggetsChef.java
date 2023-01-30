
public class NuggetsChef extends Chef{
	
	public NuggetsChef(int nofspicy,int nofnormal){
	Meal spicy=new Nuggets();
	((Nuggets) spicy).makeSpicy();
	Meal normal=new Nuggets();
	cookeSpicy(nofspicy,spicy);
	cookeNormal(nofnormal,normal);
	}
	
	
	public void cookeSpicy(int x,Meal y) {
		for (int i=0;i<x;i++) {
		setSpicyMeals(y);
		}
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
		return Nuggets.PREPARETIME;
	}	
}

