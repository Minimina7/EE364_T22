public class Cashier extends Worker{

    private int normalOrderCounter = 1;
    private int onlineOrderCounter = 1000;

// inside

 public  void serveCustomer(Customers customersAtservice){
     setCustomerAndCustomerOrder(customersAtservice);
     
     if(customersAtservice.isOnlineOrder()) {
         setOrderNumber(onlineOrderCounter);
         onlineOrderCounter++;
     }
     else {
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