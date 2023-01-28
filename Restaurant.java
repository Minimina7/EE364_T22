import java.security.SecureRandom;
import java.util.ArrayList;
public class Restaurant {
	public static ArrayList<Drinks> Drink = new ArrayList<Drinks>();
	public static ArrayList<Corn> Corn = new ArrayList<Corn>();
	public static ArrayList<IceCream> IceCreams = new ArrayList<IceCream>();
	public static ArrayList<JumboShrimp> JumboShrimp = new ArrayList<JumboShrimp>();
	public static ArrayList<Nuggets> Nuggets = new ArrayList<Nuggets>();
	public static ArrayList<Broast> Broast = new ArrayList<Broast>();
	public static ArrayList<Sandwich> Sandwich = new ArrayList<Sandwich>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}


 public static int getRandom(int firstNumber, int secondNumber) {
	SecureRandom randomNumber = new SecureRandom();
	 int random = randomNumber.nextInt(secondNumber)+ firstNumber;
	 return random;}
 }
