import java.util.ArrayList;

public class Bench<E extends Food> {

    // Data Field
	private ArrayList<E> bench = new ArrayList<E>();

	// Methods

	// add by array
	public void addToBeanch(ArrayList<E> addedFood) {
		for (E Food : addedFood) {
			bench.add(Food);
		}
		addedFood.clear();
	}

	// overload : add by element
	public void addToBeanch(E addedFood) {
		bench.add(addedFood);
	}

	// remove by array
	public void removeFromBeanch(ArrayList<E> removedFood) {
		for (E Food : removedFood) {
			bench.remove(Food);
		}
		removedFood.clear();
	}

	// overload: remove by element
	public void removeFromBeanch(int index) {
		bench.remove(index);
	}

	// bring the food from the bench
	public Food getFood(int index) {
		return bench.get(index);
	}

	// bring the array
	public ArrayList<E> getBench() {
		return bench;
	}

	// bring the element in the idex
	public E getBench(int x) {
		return bench.get(x);
	}

	// tell you how many meal in the bench
	public int foodAmuont() {
		return bench.size();
	}
}
