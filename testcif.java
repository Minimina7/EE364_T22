import java.util.ArrayList;

public class testcif {
	
	
public static void main(String[] args) {
	Bench<Sandwich> sandwich = new Bench<Sandwich>();
	SandwichChef sandwichChef = new SandwichChef();
	NuggetsChef broastChef = new NuggetsChef();
	Bench<Nuggets> broast = new Bench<Nuggets>();
	Bench<Nuggets> spicyBroast = new Bench<Nuggets>();
	
	ArrayList<Food> startingBroast = broastChef.cookeNormal(8);
	for (Food singelBroast : startingBroast) {
		broast.addToBench((Nuggets) singelBroast);
	}
	
	ArrayList<Food> startingBroastSpicy = broastChef.cookeSpicy(8);
	for (Food singelBroast : startingBroastSpicy) {
		spicyBroast.addToBench((Nuggets) singelBroast);
	}
	broast.getBench().remove(0);
	spicyBroast.getBench().remove(0);
for(int i = 0 ; i<20; i++) {
	broastChef.checkBeanch(spicyBroast, broast, i);
//	if(Math.random()>0.5) {
//	broast.getBench().remove(0);}
//	if(Math.random()>0.5) {
//	spicyBroast.getBench().remove(0);}
	System.out.println(broast.getBench().size());
	System.out.println(spicyBroast.getBench().size());
}
//	ArrayList<Food> startingSandwichCN = sandwichChef.cookeChickenSandwichNormal(5);
//	for (Food singelSandwich : startingSandwichCN) {
//		sandwich.addToBench((Sandwich) singelSandwich);
//	}
//	
//	ArrayList<Food> startingSandwichCS = sandwichChef.cookeChickenSandwichSpicy(5);
//	for (Food singelSandwich : startingSandwichCS) {
//		sandwich.addToBench((Sandwich) singelSandwich);
//	}
//	
//	ArrayList<Food> startingSandwichFN = sandwichChef.cookeFishSandwichNormal(5);
//	for (Food singelSandwich : startingSandwichFN) {
//		sandwich.addToBench((Sandwich) singelSandwich);
//	}
//	
//	ArrayList<Food> startingSandwichFS = sandwichChef.cookeFishSandwichSpicy(5);
//	for (Food singelSandwich : startingSandwichFS) {
//		sandwich.addToBench((Sandwich) singelSandwich);
//	}
//	
//	
//	for(int totalTimeInMinute = 0; totalTimeInMinute<100 ; totalTimeInMinute++) {
//		sandwichChef.checkBeanch(sandwich, totalTimeInMinute);
//		System.out.println(sandwich.getBench().size());
//		
//	}
//	
}
}
