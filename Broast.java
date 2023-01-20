
public class Broast extends Meal implements Spicable {

	private boolean spicy;
	public static final String NAME = "Broast";
	public static final int PREPARETIME = 12;
	private int timeOnBeanch;

	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 5)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 5) * 5);
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
