public class Cashier extends Worker{

    private int OrderCounter = 1;

// inside

 public  void serveCustomer(Customers customersAtservice){
     setCustomerAndCustomerOrder(customersAtservice);
     
     if(customersAtservice.isOnlineOrder()) {
         setOrderNumber(OrderCounter+1000);
         OrderCounter++;
     }
     else {
         setOrderNumber(OrderCounter);
         OrderCounter++; 
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