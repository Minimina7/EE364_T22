
public class Nuggets extends Meal implements spicable {

	private boolean spicy;
	public static final String NAME = "Nuggets";
	public static final int PREPARETIME = 10;
	private int timeOnBeanch;

	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 5)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 5) * 4);
	}

	public void makeSpicy() {
		spicy = true;
	}

	public boolean isItSpicy() {
		if (spicy == true)
			return true;
		else
			return false;
	}

}
