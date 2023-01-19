
public class IceCream extends Snacks {

	public static final String NAME = "Ice Cream";
	public static final int PREPARETIME = 0;
	private int timeOnBeanch;

	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 1)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 1) * 10);
	}

}
