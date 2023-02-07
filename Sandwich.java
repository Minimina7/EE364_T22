
public class Sandwich extends Meal implements Spicable {

	// Data Field
	private boolean spicy;
	private boolean chickenOrFish;
	private boolean pickles = true;
	private boolean garlic = true;
	private boolean isitSpecial;
	public static final String NAME = "Sandwich";
	public static final int PREPARETIME = 5;
	private int timeOnBeanch;

	// methods

	// update the quality of the sandwich
	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 15)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 15));
	}

	// ChickenOrFish
	public void makeItFish() {
		chickenOrFish = true;
	}

	// this method check if the sandwich equal or not.
	public boolean equalTo(Sandwich comparedSandwich) {
		if (spicy == comparedSandwich.isItSpicy() && chickenOrFish == comparedSandwich.isItChickenOrFish()
				&& pickles == comparedSandwich.checkPickles() && garlic == comparedSandwich.checkGarlic()) {
			return true;
		} else
			return false;
	}

	// Pickles and special
	public void withoutPickles() {
		pickles = false;
		setIsitSpecial();
	}

	// Garlic and special
	public void withoutGarlic() {
		garlic = false;
		setIsitSpecial();
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

	public boolean isIsitSpecial() {
		return isitSpecial;
	}

	public void setIsitSpecial() {
		this.isitSpecial = true;
	}

	public boolean isItChickenOrFish() {
		return chickenOrFish;
	}

	public boolean checkPickles() {
		return pickles;
	}

}
