
public class Nuggets extends Meal implements spicable {

	private boolean Spicy;
	public static final String NAME = "Nuggets";
	public static final int PREPARETIME = 10;
	private int TimeOnBeanch;

	public void editQuality() {
		TimeOnBeanch += 1;
		if (TimeOnBeanch > 5)
			if (super.getQuality() > 30)
				setQuality(100 - (TimeOnBeanch - 5) * 4);
	}

	public void makeSpicy() {
		Spicy = true;
	}

	public boolean isItSpicy() {
		if (Spicy == true)
			return true;
		else
			return false;
	}

}
