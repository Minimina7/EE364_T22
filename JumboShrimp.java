
public class JumboShrimp extends Meal {

	public static final String NAME = "JumboShrimp";
	public static final int PREPARETIME = 10;
	private int timeOnBeanch; // instance variable that count time of order on beanch// instance variable that count time of order on beanch

	//to set quality
	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 5)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 5) * 4);
	}
}
