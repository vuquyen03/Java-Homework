package lab2;
import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<DigitalVideoDisc> itemsOrdered = 
			new ArrayList<>();
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(itemsOrdered.size() > 20) {
			System.out.println("The cart is almost full");
		}
		else {
			itemsOrdered.add(disc);	
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		itemsOrdered.remove(disc);
	}
	
	public float totalCost() {
		float ans = 0;
		for(DigitalVideoDisc DVD : itemsOrdered) {
			ans += DVD.getCost();
		}
		return ans;
	}
		
}
