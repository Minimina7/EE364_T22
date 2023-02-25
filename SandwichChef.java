import java.util.ArrayList;

public class SandwichChef extends Chef{

	////////////////////////////////////////////////////////
	public SandwichChef() {
		Sandwich sandwich = new Sandwich();
		timeNeededToCooke = sandwich.PREPARETIME;
	}
	
private int spicyAmountChicken;
private int normalAmountChicken;
private int spicyAmountFish;
private int normalAmountFish;
private int timeNeededToCooke;
private int timeStartCookeChicken;
private boolean chefIsCookingChicken;
private int timeStartCookeFish;
private boolean chefIsCookingFish;
private int timeStartCookeSpecial;
private boolean chefIsCookingSpecial;
private ArrayList<Food> chickenMadeSpicy = new ArrayList<Food>();
private ArrayList<Food> chickenMadeNormal = new ArrayList<Food>();
private ArrayList<Food> fishMadeSpicy = new ArrayList<Food>();
private ArrayList<Food> fishMadeNormal = new ArrayList<Food>();
private ArrayList<Food> specialSandwiches = new ArrayList<Food>();

//Method that add broast to the beanch if needed
public void checkBeanch(Bench sandwich, int time) {
	
	ArrayList<Sandwich>sandwichArray = sandwich.getBench();
	
///////////////////////////////////////////////////////////////////////	chickenMadeNormal:
	for (Sandwich singelSandwich : sandwichArray) {
		if (!(singelSandwich.isItSpicy()) && !(singelSandwich.isItChickenOrFish())) {
			normalAmountChicken++;
		}
	}

	if (!(chefIsCookingChicken)) {
		if (normalAmountChicken <= 2) {
			chickenMadeNormal = cookeChickenSandwichNormal(2);
			timeStartCookeChicken = time;
			chefIsCookingChicken = true;
		}
	}
//////////////////////////////////////////////////////////chickenMadeSpicy:
	for (Sandwich singelSandwich : sandwichArray) {
		if ((singelSandwich.isItSpicy()) && !(singelSandwich.isItChickenOrFish())) {
			spicyAmountChicken++;
		}
	}

	if (!(chefIsCookingChicken)) {
		if (spicyAmountChicken <= 2) {
			chickenMadeSpicy = cookeChickenSandwichSpicy(2);
			timeStartCookeChicken = time;
			chefIsCookingChicken = true;
		}
	}
//////////////////////////////////////////////////////////fishMadeNormal:		
	for (Sandwich singelSandwich : sandwichArray) {
		if (!(singelSandwich.isItSpicy()) && (singelSandwich.isItChickenOrFish())) {
			normalAmountFish++;
		}
	}

	if (!(chefIsCookingFish)) {
		if (normalAmountFish <= 2) {
			fishMadeNormal = cookeFishSandwichNormal(2);
			timeStartCookeFish = time;
			chefIsCookingFish = true;
		}
	}
//////////////////////////////////////////////////////////fishMadeSpicy:	
	for (Sandwich singelSandwich : sandwichArray) {
		if ((singelSandwich.isItSpicy()) && (singelSandwich.isItChickenOrFish())) {
			spicyAmountFish++;
		}
	}

	if (!(chefIsCookingFish)) {
		if (spicyAmountFish <= 2) {
			fishMadeSpicy = cookeFishSandwichSpicy(2);
			timeStartCookeFish = time;
			chefIsCookingFish = true;
		}
	}
//////////////////////////////////////////////////////////
		
	normalAmountChicken=0;
	spicyAmountChicken=0;
	normalAmountFish=0;
	spicyAmountFish=0;
	if (time==(timeNeededToCooke+timeStartCookeChicken)) {
		
	if (!(chickenMadeNormal.isEmpty())) {
		sandwich.addToBench(chickenMadeNormal);
	chickenMadeNormal.clear();
	chefIsCookingChicken = false;}
	
	if (!(chickenMadeSpicy.isEmpty())) {
		sandwich.addToBench(chickenMadeSpicy);
		chickenMadeSpicy.clear();
		chefIsCookingChicken = false;}
	}
	if (time==(timeNeededToCooke+timeStartCookeFish)) {
	if (!(fishMadeNormal.isEmpty())) {
		sandwich.addToBench(fishMadeNormal);
		fishMadeNormal.clear();
		chefIsCookingFish = false;}
	
	if (!(fishMadeSpicy.isEmpty())) {
		sandwich.addToBench(fishMadeSpicy);
		fishMadeSpicy.clear();
		chefIsCookingFish = false;}
	}
	
}
	///////////////////////////////////////////////////
	public int getTimeNeededToCooke() {
		
		return Sandwich.PREPARETIME;
	}

	
	//CH not SP
	public ArrayList<Food> cookeChickenSandwichNormal(int amount) {
		ArrayList<Food> chickenSandwichMadeNormal = new ArrayList<Food>();
		for (int i=0;i<amount;i++) {
			Sandwich singelSandwich = new Sandwich();
			chickenSandwichMadeNormal.add(singelSandwich);
		}
		return chickenSandwichMadeNormal;
	}
	
	//CH yes SP
	public ArrayList<Food> cookeChickenSandwichSpicy(int amount) {
		ArrayList<Food> chickenSandwichMadeSpicy = cookeChickenSandwichNormal(amount) ;
		for (int i=0;i<=(chickenSandwichMadeSpicy.size())-1;i++) {
			Sandwich singelSandwich = (Sandwich)chickenSandwichMadeSpicy.get(i);
			singelSandwich.makeSpicy();
		}
		return chickenSandwichMadeSpicy;
	}
	//F not SP
	public ArrayList<Food> cookeFishSandwichNormal(int amount) {
		ArrayList<Food> fishSandwichMadeNormal = cookeChickenSandwichNormal(amount) ;
		for (int i=0;i<=(fishSandwichMadeNormal.size())-1;i++) {
			Sandwich singelSandwich = (Sandwich)fishSandwichMadeNormal.get(i);
			singelSandwich.makeItFish();
		}
		return fishSandwichMadeNormal;
	}
	//F yes SP
	public ArrayList<Food> cookeFishSandwichSpicy(int amount) {
		ArrayList<Food> fishSandwichMadeSpicy = cookeChickenSandwichNormal(amount) ;
		for (int i=0;i<=(fishSandwichMadeSpicy.size())-1;i++) {
			Sandwich singelSandwich = (Sandwich)fishSandwichMadeSpicy.get(i);
			singelSandwich.makeItFish();
			singelSandwich.makeSpicy();
		}
		return fishSandwichMadeSpicy;
	}

	public Sandwich cookeSpecialSandwich(Sandwich sandwich) {
		Sandwich specialSandwich = new Sandwich();
		
		if(!(sandwich.checkGarlic())) {
			specialSandwich.withoutGarlic();}
		if(!(sandwich.checkPickles())) {
			specialSandwich.withoutPickles();}
		if(sandwich.isItChickenOrFish()) {
			specialSandwich.makeItFish();}
		if(sandwich.isItSpicy()) {
			specialSandwich.makeSpicy();}
		
		return specialSandwich;
	}
	
	public void cookeCustomersSpecialSandwiches(Bench sandwich, Customers customers) {
		Order order  = customers.getCustomerOrder();
		for(Meal singelSandwich:order.getMeals()) {
			if(singelSandwich instanceof Sandwich) {
				if(((Sandwich)singelSandwich).isIsitSpecial()) {
					Sandwich specialSingelSandwich = cookeSpecialSandwich((Sandwich)singelSandwich);
					sandwich.addToBench(specialSingelSandwich);
				}
			}
		}
		

		}
	
	public void cookeSpecialSandwiches(Bench sandwich, ArrayList<Sandwich> specialSandwiches, int time) {
		
		this.specialSandwiches.clear();
		
		for (int i=0;i<=(specialSandwiches.size())-1;i++) {

			Sandwich singelSandwich = specialSandwiches.get(i);
			Sandwich specialSingelSandwich = cookeSpecialSandwich(singelSandwich);
			this.specialSandwiches.add(specialSingelSandwich);
			}
		
		
		if (!(this.specialSandwiches.isEmpty())) {
		if (!(chefIsCookingSpecial)) {
			timeStartCookeSpecial = time;
			chefIsCookingSpecial = true;
		}}
		
		
		if (time==(timeNeededToCooke+timeStartCookeSpecial)) {
			if (!(this.specialSandwiches.isEmpty())) {
				sandwich.addToBench(this.specialSandwiches);
				
				
				
				
				this.specialSandwiches.clear();
			    chefIsCookingSpecial = false;}
		}
		
	}

	//check if the chef is cooking or not
	public boolean isChefCooking() {
		if(chefIsCookingChicken|| chefIsCookingFish ||chefIsCookingSpecial) 
			return true;	
		
		return false;
	}

	@Override
	public ArrayList<Food> cookeNormal(int amount) {
		
		return cookeChickenSandwichNormal(amount);
	}
	
	// to cook meals on the first hour
	public void firstCookNormal(Bench bench, int amount) {
		
		int nmuberOfSandwichCN =0;
		int nmuberOfSandwichCS =0;
		int nmuberOfSandwichFN =0;
		int nmuberOfSandwichFS =0;
		
		ArrayList<Sandwich> sandwich = bench.getBench();
		
		for(Food oneSandwich:sandwich) {
			if(!((Sandwich)oneSandwich).isIsitSpecial()) {
				
			if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && !(((Sandwich)oneSandwich).isItSpicy())) 
				nmuberOfSandwichCN++;
				
			
			else if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichCS++;
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && !(((Sandwich)oneSandwich).isItSpicy()))
				nmuberOfSandwichFN++; 
				
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichFS++;
			}}
		
		
		if(amount>0) {
		if(nmuberOfSandwichCN<2) {
			ArrayList<Food> startingSandwichCN = cookeChickenSandwichNormal(1);
			bench.addToBench(startingSandwichCN);
			}
		
		if(nmuberOfSandwichCS<2) {
			ArrayList<Food> startingSandwichCS = cookeChickenSandwichSpicy(1);
			bench.addToBench(startingSandwichCS);}
		
		if(nmuberOfSandwichFN<2) {
			ArrayList<Food> startingSandwichFN = cookeFishSandwichNormal(1);
			bench.addToBench(startingSandwichFN);}
		
		if(nmuberOfSandwichFS<2) {
			ArrayList<Food> startingSandwichFS = cookeFishSandwichSpicy(1);
			bench.addToBench(startingSandwichFS);}
			
		}}
	
	// to cook meals from hour 2 to hour 16
	public void secondCookNormal(Bench bench, int amount) {
		int nmuberOfSandwichCN =0;
		int nmuberOfSandwichCS =0;
		int nmuberOfSandwichFN =0;
		int nmuberOfSandwichFS =0;
		
		ArrayList<Sandwich> sandwich = bench.getBench();
		
		for(Food oneSandwich:sandwich) {
			if(!((Sandwich)oneSandwich).isIsitSpecial()) {
				
			if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && !(((Sandwich)oneSandwich).isItSpicy())) 
				nmuberOfSandwichCN++;
				
			
			else if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichCS++;
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && !(((Sandwich)oneSandwich).isItSpicy()))
				nmuberOfSandwichFN++; 
				
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichFS++;
			}}
		
		
		
		if(nmuberOfSandwichCN<3) {
			ArrayList<Food> startingSandwichCN = cookeChickenSandwichNormal(amount);
			bench.addToBench(startingSandwichCN);
			}
		
		if(nmuberOfSandwichCS<3) {
			ArrayList<Food> startingSandwichCS = cookeChickenSandwichSpicy(amount);
			bench.addToBench(startingSandwichCS);}
		
		if(nmuberOfSandwichFN<3) {
			ArrayList<Food> startingSandwichFN = cookeFishSandwichNormal(amount);
			bench.addToBench(startingSandwichFN);}
		
		if(nmuberOfSandwichFS<3) {
			ArrayList<Food> startingSandwichFS = cookeFishSandwichSpicy(amount);
			bench.addToBench(startingSandwichFS);}
		
		}
	
	// to cook meals on the last hour and it takes beanch and arraylist of customer
	public void LastCookNormal(Bench bench, ArrayList<Customers> customers) {
		int nmuberOfSandwichCNOnBench =0;
		int nmuberOfSandwichCSOnBench =0;
		int nmuberOfSandwichFNOnBench =0;
		int nmuberOfSandwichFSOnBench =0;
		
		int nmuberOfSandwichCN =0;
		int nmuberOfSandwichCS =0;
		int nmuberOfSandwichFN =0;
		int nmuberOfSandwichFS =0;
		
		ArrayList<Sandwich> sandwich = bench.getBench();
		
		for(Food oneSandwich:sandwich) {
			if(oneSandwich instanceof Sandwich ) {
			if(!((Sandwich)oneSandwich).isIsitSpecial()) {
				
			if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && !(((Sandwich)oneSandwich).isItSpicy())) 
				nmuberOfSandwichCNOnBench++;
				
			
			else if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichCSOnBench++;
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && !(((Sandwich)oneSandwich).isItSpicy()))
				nmuberOfSandwichFNOnBench++; 
				
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichFSOnBench++;
			}}}
		
		for(Customers onecustomers:customers) {
			Order order = onecustomers.getCustomerOrder();
			ArrayList<Meal> meal = order.getMeals();
			for(Meal oneSandwich:meal) {
				if(oneSandwich instanceof Sandwich ) {
				if(!((Sandwich)oneSandwich).isIsitSpecial()) {
					
					if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && !(((Sandwich)oneSandwich).isItSpicy())) 
						nmuberOfSandwichCN++;
						
					
					else if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && ((Sandwich)oneSandwich).isItSpicy())
						nmuberOfSandwichCS++;
					
					else if(((Sandwich)oneSandwich).isItChickenOrFish() && !(((Sandwich)oneSandwich).isItSpicy()))
						nmuberOfSandwichFN++; 
						
					
					else if(((Sandwich)oneSandwich).isItChickenOrFish() && ((Sandwich)oneSandwich).isItSpicy())
						nmuberOfSandwichFS++;
					}	
				
			}
			}
		}
		
		
		
		if(nmuberOfSandwichCN-nmuberOfSandwichCNOnBench>0) {
			ArrayList<Food> startingSandwichCN = cookeChickenSandwichNormal(nmuberOfSandwichCN-nmuberOfSandwichCNOnBench);
			bench.addToBench(startingSandwichCN);
			}
		
		if(nmuberOfSandwichCS-nmuberOfSandwichCSOnBench>0) {
			ArrayList<Food> startingSandwichCS = cookeChickenSandwichSpicy(nmuberOfSandwichCS-nmuberOfSandwichCSOnBench);
			bench.addToBench(startingSandwichCS);}
		
		if(nmuberOfSandwichFN-nmuberOfSandwichFNOnBench>0) {
			ArrayList<Food> startingSandwichFN = cookeFishSandwichNormal(nmuberOfSandwichFN-nmuberOfSandwichFNOnBench);
			bench.addToBench(startingSandwichFN);}
		
		if(nmuberOfSandwichFS-nmuberOfSandwichFSOnBench>0) {
			ArrayList<Food> startingSandwichFS = cookeFishSandwichSpicy(nmuberOfSandwichFS-nmuberOfSandwichFSOnBench);
			bench.addToBench(startingSandwichFS);}
		
		}
		
	// to cook meals on the last hour and it takes beanch and customer
	public void LastCookNormal(Bench bench, Customers customers) {
		int nmuberOfSandwichCNOnBench =0;
		int nmuberOfSandwichCSOnBench =0;
		int nmuberOfSandwichFNOnBench =0;
		int nmuberOfSandwichFSOnBench =0;
		
		int nmuberOfSandwichCN =0;
		int nmuberOfSandwichCS =0;
		int nmuberOfSandwichFN =0;
		int nmuberOfSandwichFS =0;
		
		ArrayList<Sandwich> sandwich = bench.getBench();
		
		for(Food oneSandwich:sandwich) {
			if(oneSandwich instanceof Sandwich ) {
			if(!((Sandwich)oneSandwich).isIsitSpecial()) {
				
			if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && !(((Sandwich)oneSandwich).isItSpicy())) 
				nmuberOfSandwichCNOnBench++;
				
			
			else if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichCSOnBench++;
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && !(((Sandwich)oneSandwich).isItSpicy()))
				nmuberOfSandwichFNOnBench++; 
				
			
			else if(((Sandwich)oneSandwich).isItChickenOrFish() && ((Sandwich)oneSandwich).isItSpicy())
				nmuberOfSandwichFSOnBench++;
			}}}
		
		
			Order order = customers.getCustomerOrder();
			ArrayList<Meal> meal = order.getMeals();
			for(Meal oneSandwich:meal) {
				if(oneSandwich instanceof Sandwich ) {
				if(!((Sandwich)oneSandwich).isIsitSpecial()) {
					
					if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && !(((Sandwich)oneSandwich).isItSpicy())) 
						nmuberOfSandwichCN++;
						
					
					else if(!(((Sandwich)oneSandwich).isItChickenOrFish()) && ((Sandwich)oneSandwich).isItSpicy())
						nmuberOfSandwichCS++;
					
					else if(((Sandwich)oneSandwich).isItChickenOrFish() && !(((Sandwich)oneSandwich).isItSpicy()))
						nmuberOfSandwichFN++; 
						
					
					else if(((Sandwich)oneSandwich).isItChickenOrFish() && ((Sandwich)oneSandwich).isItSpicy())
						nmuberOfSandwichFS++;
					}	
				
			}
			
		}
		
		if(nmuberOfSandwichCN-nmuberOfSandwichCNOnBench>0 && nmuberOfSandwichCNOnBench<5) {
			ArrayList<Food> startingSandwichCN = cookeChickenSandwichNormal(nmuberOfSandwichCN-nmuberOfSandwichCNOnBench);
			bench.addToBench(startingSandwichCN);
			}
		
		if(nmuberOfSandwichCS-nmuberOfSandwichCSOnBench>0 && nmuberOfSandwichCSOnBench<5) {
			ArrayList<Food> startingSandwichCS = cookeChickenSandwichSpicy(nmuberOfSandwichCS-nmuberOfSandwichCSOnBench);
			bench.addToBench(startingSandwichCS);}
		
		if(nmuberOfSandwichFN-nmuberOfSandwichFNOnBench>0 && nmuberOfSandwichFNOnBench<5) {
			ArrayList<Food> startingSandwichFN = cookeFishSandwichNormal(nmuberOfSandwichFN-nmuberOfSandwichFNOnBench);
			bench.addToBench(startingSandwichFN);}
		
		if(nmuberOfSandwichFS-nmuberOfSandwichFSOnBench>0 &&  nmuberOfSandwichFSOnBench<5) {
			ArrayList<Food> startingSandwichFS = cookeFishSandwichSpicy(nmuberOfSandwichFS-nmuberOfSandwichFSOnBench);
			bench.addToBench(startingSandwichFS);}
			
		
	}
	
}
