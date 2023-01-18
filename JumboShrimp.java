
public class JumboShrimp extends Meal {

	public static final String NAME="JumboShrimp";
	public static final int PREPARETIME=10;
	private int TimeOnBeanch;
	
	public void editQuality() {
		TimeOnBeanch+=1;
		if (TimeOnBeanch>5)
			if (super.getQuality()>30)
				setQuality(100-(TimeOnBeanch-5)*4);
	}
}
