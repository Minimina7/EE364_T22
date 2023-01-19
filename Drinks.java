
public class Drinks extends Snacks {

	public static final String NAME = "Drink";
	public static final int PREPARETIME = 0;
	private int TimeOnBeanch;

	public void editQuality() {
		TimeOnBeanch += 1;
		if (TimeOnBeanch > 1)
			if (super.getQuality() > 30)
				setQuality(100 - (TimeOnBeanch - 1) * 2);
	}

}
