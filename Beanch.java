import java.util.ArrayList;
public class Beanch<E extends Food> {

	private ArrayList< E > beanch = new ArrayList< E >();
	
	
	public void addToBeanch(ArrayList< E > addedFood){
		for (E Food:addedFood) {
			beanch.add(Food);
		}
		addedFood.clear();
	}
	
	public void removeFromBeanch(ArrayList< E > addedFood){
		for (E Food:addedFood) {
			beanch.remove(Food);
		}
		addedFood.clear();
	}
	
	public int foodAmuont(){
		return beanch.size();
	}
}