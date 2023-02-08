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
private int timeStartCooke;
private boolean chefIsCooking;
private ArrayList<Food> chickenMadeSpicy = new ArrayList<Food>();
private ArrayList<Food> chickenMadeNormal = new ArrayList<Food>();
private ArrayList<Food> fishMadeSpicy = new ArrayList<Food>();
private ArrayList<Food> fishMadeNormal = new ArrayList<Food>();
private ArrayList<Food> specialSandwiches = new ArrayList<Food>();

public void checkBeanch(Bench sandwich, int time) {
	
	ArrayList<Sandwich>sandwichArray = sandwich.getBench();
	
///////////////////////////////////////////////////////////////////////	chickenMadeNormal:
	for (Sandwich singelSandwich : sandwichArray) {
		if (!(singelSandwich.isItSpicy()) && !(singelSandwich.isItChickenOrFish())) {
			normalAmountChicken++;
		}
	}

	if (!(chefIsCooking)) {
		if (normalAmountChicken < 5) {
			chickenMadeNormal = cookeChickenSandwichNormal(5);
			timeStartCooke = time;
			chefIsCooking = true;
		}
	}
//////////////////////////////////////////////////////////chickenMadeSpicy:
	for (Sandwich singelSandwich : sandwichArray) {
		if ((singelSandwich.isItSpicy()) && !(singelSandwich.isItChickenOrFish())) {
			spicyAmountChicken++;
		}
	}

	if (!(chefIsCooking)) {
		if (spicyAmountChicken < 5) {
			chickenMadeSpicy = cookeChickenSandwichSpicy(5);
			timeStartCooke = time;
			chefIsCooking = true;
		}
	}
//////////////////////////////////////////////////////////fishMadeNormal:		
	for (Sandwich singelSandwich : sandwichArray) {
		if (!(singelSandwich.isItSpicy()) && (singelSandwich.isItChickenOrFish())) {
			normalAmountFish++;
		}
	}

	if (!(chefIsCooking)) {
		if (normalAmountFish < 5) {
			fishMadeNormal = cookeFishSandwichNormal(5);
			timeStartCooke = time;
			chefIsCooking = true;
		}
	}
//////////////////////////////////////////////////////////fishMadeSpicy:	
	for (Sandwich singelSandwich : sandwichArray) {
		if ((singelSandwich.isItSpicy()) && (singelSandwich.isItChickenOrFish())) {
			spicyAmountFish++;
		}
	}

	if (!(chefIsCooking)) {
		if (spicyAmountFish < 5) {
			fishMadeSpicy = cookeFishSandwichSpicy(5);
			timeStartCooke = time;
			chefIsCooking = true;
		}
	}
//////////////////////////////////////////////////////////
		
	normalAmountChicken=0;
	spicyAmountChicken=0;
	normalAmountFish=0;
	spicyAmountFish=0;
	if (time==(timeNeededToCooke+timeStartCooke)) {
		
	if (!(chickenMadeNormal.isEmpty())) {
		sandwich.addToBench(chickenMadeNormal);
	chickenMadeNormal.clear();
	chefIsCooking = false;}
	
	if (!(chickenMadeSpicy.isEmpty())) {
		sandwich.addToBench(chickenMadeSpicy);
		chickenMadeSpicy.clear();
		chefIsCooking = false;}
	
	if (!(fishMadeNormal.isEmpty())) {
		sandwich.addToBench(fishMadeNormal);
		fishMadeNormal.clear();
		chefIsCooking = false;}
	
	if (!(fishMadeSpicy.isEmpty())) {
		sandwich.addToBench(fishMadeSpicy);
		fishMadeSpicy.clear();
		chefIsCooking = false;}
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
		for (int i=0;i<(chickenSandwichMadeSpicy.size())-1;i++) {
			Sandwich singelSandwich = (Sandwich)chickenSandwichMadeSpicy.get(i);
			singelSandwich.makeSpicy();
		}
		return chickenSandwichMadeSpicy;
	}
	//F not SP
	public ArrayList<Food> cookeFishSandwichNormal(int amount) {
		ArrayList<Food> fishSandwichMadeNormal = cookeChickenSandwichNormal(amount) ;
		for (int i=0;i<(fishSandwichMadeNormal.size())-1;i++) {
			Sandwich singelSandwich = (Sandwich)fishSandwichMadeNormal.get(i);
			singelSandwich.makeItFish();
		}
		return fishSandwichMadeNormal;
	}
	//F yes SP
	public ArrayList<Food> cookeFishSandwichSpicy(int amount) {
		ArrayList<Food> fishSandwichMadeSpicy = cookeChickenSandwichNormal(amount) ;
		for (int i=0;i<(fishSandwichMadeSpicy.size())-1;i++) {
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

	public void cookeSpecialSandwiches(Bench sandwich, ArrayList<Food> specialSandwiches, int time) {
		
		this.specialSandwiches.clear();
		
		for (int i=0;i<(specialSandwiches.size())-1;i++) {
			Sandwich singelSandwich = (Sandwich)specialSandwiches.get(i);
			Sandwich specialSingelSandwich = cookeSpecialSandwich(singelSandwich);
			this.specialSandwiches.add(specialSingelSandwich);
		}
		
		if (!(chefIsCooking)) {
			timeStartCooke = time;
			chefIsCooking = true;
		}
		
		
		if (time==(timeNeededToCooke+timeStartCooke)) {
			if (!(specialSandwiches.isEmpty())) {
				sandwich.addToBench(specialSandwiches);
				specialSandwiches.clear();
			    chefIsCooking = false;}
		}
		
	}



	@Override
	public ArrayList<Food> cookeNormal(int amount) {
		
		return cookeChickenSandwichNormal(amount);
	}
}