import java.util.Random;
public class Restaurant {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}


 public static int getRandom(int firstNumber, int secondNumber) {
	 Random randomNumber = new Random();
	 int random = randomNumber.nextInt(secondNumber)+ firstNumber;
	 return random;}
 }