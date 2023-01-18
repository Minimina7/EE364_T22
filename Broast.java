
public class Broast extends Meal implements spicable {
	
	private boolean Spicy;
	public static final String NAME="Broast";
	public static final int PREPARETIME=12;
	private int TimeOnBeanch;
	
	public void editQuality() {
		TimeOnBeanch+=1;
		if (TimeOnBeanch>5)
			if (super.getQuality()>30)
				setQuality(100-(TimeOnBeanch-5)*5);
	}
	
	public void makeSpicy() {
		Spicy=true;
	}
	 
	 public boolean isItSpicy() {
		 if (Spicy==true)
			 return true;
		 else
			 return false;
	 }
	 
}

