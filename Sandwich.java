
public class Sandwich extends Meal implements spicable {

	private boolean Spicy;
	private boolean chickenOrFish;
	private boolean pickles = true;
	private boolean garlic = true;
	public static final String NAME = "Sandwich";
	public static final int PREPARETIME = 5;
	private int TimeOnBeanch;

	public void editQuality() {
		TimeOnBeanch += 1;
		if (TimeOnBeanch > 15)
			if (super.getQuality() > 30)
				setQuality(100 - (TimeOnBeanch - 15));
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
		Spicy = true;
	}

	public boolean isItSpicy() {
		if (Spicy == true)
			return true;
		else
			return false;
	}

}
