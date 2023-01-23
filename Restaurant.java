import java.security.SecureRandom;
;
public class Restaurant {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}


 public static int getRandom(int firstNumber, int secondNumber) {
	SecureRandom randomNumber = new SecureRandom();
	 int random = randomNumber.nextInt(secondNumber)+ firstNumber;
	 return random;}
 }
