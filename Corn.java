
public class Corn extends Snacks {

	public static final String NAME = "Corn";
	public static final int PREPARETIME = 3;
	private int timeOnBeanch;

	public void editQuality() {
		timeOnBeanch += 1;
		if (timeOnBeanch > 5)
			if (super.getQuality() > 30)
				setQuality(100 - (timeOnBeanch - 5) * 5);
	}

}
