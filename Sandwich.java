
public class Sandwich extends Meal implements Spicable {

	private boolean spicy;
	private boolean chickenOrFish;
	private boolean pickles = true;
	private boolean garlic = true;
	public static final String NAME = "Sandwich";
	public static final int PREPARETIME = 5;
	private int timeOnBeanch;

	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 15)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 15));
	}

	public Sandwich() {
	}

	// ChickenOrFish
	public void makeItFish() {
		chickenOrFish = true;
	}

	public boolean isItChickenOrFish() {
		return chickenOrFish;
	}

	// Pickles
	public void withoutPickles() {
		pickles = false;
	}

	public boolean checkPickles() {
		return pickles;
	}

	// Garlic
	public void withoutGarlic() {
		garlic = false;
	}

	public boolean checkGarlic() {
		return garlic;
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
