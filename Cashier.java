public class Cashier extends Worker{

    private int normalOrderCounter = 1; // instance variable that save the order counter
    private int onlineOrderCounter = 1000; // instance variable that save the order counter for online orders


 public  void serveCustomer(Customers customersAtservice){ // method to get the order from the customer and give it a number
     setCustomerAndCustomerOrder(customersAtservice);
     
     if(customersAtservice.isOnlineOrder()) { // if the order is online set the order number from onlineOrderCounter variable 
         setOrderNumber(onlineOrderCounter);
         onlineOrderCounter++;
     }
     else { // if the order is not online set the order number from normalOrderCounter variable 
         setOrderNumber(normalOrderCounter);
         normalOrderCounter++; 
     }
}
   
/* //outside
  
public  void serveCustomer(Customers customersAtservice,int OrderCounter){
 
  if(customersAtservice.isOnlineOrder()) {
         customersAtservice.setOrderNumber(OrderCounter+1000);
         OrderCounter++;
     }
     else {
         customersAtservice.setOrderNumber(OrderCounter);
         OrderCounter++; 
     }
  
}

*/ 

}