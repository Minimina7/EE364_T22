
public class IceCream extends Snacks{

	public static final String NAME="Ice Cream";
	public static final int PREPARETIME=0;
	private int TimeOnBeanch;
	
	public void editQuality() {
		TimeOnBeanch+=1;
		if (TimeOnBeanch>1)
			if (super.getQuality()>30)
				setQuality(100-(TimeOnBeanch-1)*10);
	}
	
}
