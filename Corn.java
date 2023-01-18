
public class Corn extends Snacks {

	public static final String NAME="Corn";
	public static final int PREPARETIME=3;
	private int TimeOnBeanch;

	public void editQuality() {
		TimeOnBeanch+=1;
		if (TimeOnBeanch>5)
			if (super.getQuality()>30)
				setQuality(100-(TimeOnBeanch-5)*5);
	}
	
}
