
public class BroastChef extends Chef{
	
	public BroastChef(int x,int y){
		Meal spicy=new Broast();
		((Broast) spicy).makeSpicy();
		Meal normal=new Broast();
		cookeSpicy(x,spicy);
		cookeNormal(y,normal);
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
		
	    public int checkBench();
	    
		
		public int addToBench();
		
		public int getTimeNeededToCooke() {
			return Nuggets.PREPARETIME;
		}	
	}

