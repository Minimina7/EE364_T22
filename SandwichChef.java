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

public void checkBeanch(Bench sandwich, int time) {
	
	ArrayList<Sandwich>sandwichArray = sandwich.getBench();
	
///////////////////////////////////////////////////////////////////////	chickenMadeNormal:
	for (Sandwich singelSandwich : sandwichArray) {
		if (!(singelSandwich.isItSpicy()) && !(singelSandwich.isItChickenOrFish())) {
			normalAmountChicken++;
		}
	}

	if (!(chefIsCookingChicken)) {
		if (normalAmountChicken <= 1) {
			chickenMadeNormal = cookeChickenSandwichNormal(5);
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
		if (spicyAmountChicken <= 1) {
			chickenMadeSpicy = cookeChickenSandwichSpicy(5);
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
		if (normalAmountFish <= 1) {
			fishMadeNormal = cookeFishSandwichNormal(5);
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
		if (spicyAmountFish <= 1) {
			fishMadeSpicy = cookeFishSandwichSpicy(5);
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

	public void cookeSpecialSandwiches(Bench sandwich, ArrayList<Sandwich> specialSandwiches, int time) {
		
		this.specialSandwiches.clear();
		
		for (int i=0;i<=(specialSandwiches.size())-1;i++) {

			Sandwich singelSandwich = specialSandwiches.get(i);
			Sandwich specialSingelSandwich = cookeSpecialSandwich(singelSandwich);
			this.specialSandwiches.add(specialSingelSandwich);
			}
//		System.out.println(this.specialSandwiches.size()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//		System.out.println(this.specialSandwiches+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//		System.out.println(specialSandwiches.size()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		System.out.println(specialSandwiches+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			//System.out.println("chi "+" moha "+"this sandwich with garlic"+specialSandwiches.get(i).checkGarlic()+"this sandwich with picels"+specialSandwiches.get(i).checkPickles() );
//			if(specialSandwiches.size()>1) {
//			if(!(singelSandwich.equalTo(specialSandwiches.get(i)))) {
//			Sandwich specialSingelSandwich = cookeSpecialSandwich(singelSandwich);
//			this.specialSandwiches.add(specialSingelSandwich);}
			//System.out.println("chi "+"tala"+"this sandwich with garlic"+specialSingelSandwich.checkGarlic()+"this sandwich with picels"+specialSingelSandwich.checkPickles() );
//			}
//			else
		
		
		if (!(this.specialSandwiches.isEmpty())) {
		if (!(chefIsCookingSpecial)) {
			timeStartCookeSpecial = time;
			chefIsCookingSpecial = true;
		}}
		
		
		if (time==(timeNeededToCooke+timeStartCookeSpecial)) {
			if (!(this.specialSandwiches.isEmpty())) {
				sandwich.addToBench(this.specialSandwiches);
				
				
				System.out.println("\\\\\\\\\\\\special done///////////");
				
				this.specialSandwiches.clear();
			    chefIsCookingSpecial = false;}
		}
		
	}



	@Override
	public ArrayList<Food> cookeNormal(int amount) {
		
		return cookeChickenSandwichNormal(amount);
	}
}
