import java.util.ArrayList;
import java.util.Random;
public class Restaurant {
	


	public static void main(String[] args) {

		
		int normalServerNumber = 0 ; // check
		int  onlineServerNumber = 1000; //check
		
		// customers array
		ArrayList<Customers> Customersorder = new ArrayList<Customers>();

		// bench creation
		Bench<Broast> broast = new Bench<Broast>();
		Bench<Broast> spicyBroast = new Bench<Broast>();
		Bench<Nuggets> nuggets = new Bench<Nuggets>();
		Bench<Nuggets> spicyNuggets = new Bench<Nuggets>();
		Bench<JumboShrimp> jumboShrimp = new Bench<JumboShrimp>();
		Bench<Sandwich> sandwich = new Bench<Sandwich>();
		Bench<Corn> corn = new Bench<Corn>();
		Bench<Drinks> drinks = new Bench<Drinks>();
		Bench<IceCream> iceCream = new Bench<IceCream>();

		// array of servers
		ArrayList<Server> servers = new ArrayList<Server>();
		
		// Servers Creation
		Server server1 = new Server(Customersorder, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server1);// add the server to the array
		Server server2 = new Server(Customersorder, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server2);// add the server to the array
		Server server3 = new Server(Customersorder, broast, spicyBroast, nuggets, spicyNuggets, jumboShrimp, sandwich,
				corn, drinks, iceCream);
		servers.add(server3);// add the server to the array
		
		// make the server work
		for (Server server: servers ) {
			
					
			server.takeNextOrder(onlineServerNumber, normalServerNumber);
			if (server.isServerTookOnlineNumber()) {
				onlineServerNumber+=1;
			}
			if (server.isServerTookNormalNumber()) {
				normalServerNumber+=1;
			}
			if (server.isThereSpecialOrder()) {
			}
			
			
		}
		
		

	}


 public static int getRandom(int firstNumber, int secondNumber) {
	 Random randomNumber = new Random();
	 int random = randomNumber.nextInt(secondNumber)+ firstNumber;
	 return random;}
 
// public int getOnlineorder() {
//	 return onlineorder;
// }
// 
// 
// public void setOnlineorder(int onlineorder) {
//	 this.onlineorder = onlineorder;
// }
// 
// 
// public int getCashierorder() {
//	 return cashierorder;
// }
// 
// 
// public void setCashierorder(int cashierorder) {
//	 this.cashierorder = cashierorder;
// }
// 
// 
// public int getServerNumber() {
//	 return serverNumber;
// }
// 
// 
// public void setServerNumber(int serverNumber) {
//	 this.serverNumber = serverNumber;
// }
// 
// 
// public int getOnlineServerNumber() {
//	 return onlineServerNumber;
// }
// 
// 
// public void setOnlineServerNumber(int onlineServerNumber) {
//	 this.onlineServerNumber = onlineServerNumber;
// }
 }
