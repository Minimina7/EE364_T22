
public class Nuggets extends Meal implements Spicable {

	private boolean spicy; // instance variable to check is it spicy or not
	public static final String NAME = "Nuggets";
	public static final int PREPARETIME = 10;
	private int timeOnBeanch; // instance variable that count time of order on beanch

	//to set quality
	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 5)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 5) * 4);
	}

	//to make the meal spicy
	public void makeSpicy() {
		spicy = true;
	}

	//check is it spicy or not
	public boolean isItSpicy() {
		if (spicy == true)
			return true;
		else
			return false;
	}

}
