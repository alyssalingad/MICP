import java.util.HashMap;


public class Inventory
{
	HashMap<Integer, Item> items;
	
	public Inventory(){
		Item item1 = new Item(1.25, "Peanuts", 10, 1);
		Item item2 = new Item(1.00, "Granola Bar", 7, 2);
		Item item3 = new Item(1.50, "Cookies", 1, 3);
		
		items = new HashMap<Integer, Item>();
		items.put(1, item1);
		items.put(2, item2);
		items.put(3, item3);
	}
	
	public void deleteItem(int itemId) throws SoldOutItemException{
		if (items.get(itemId).getItemCount() == 0){
			throw new SoldOutItemException();
		}
		else {
			items.get(itemId).subtract();
		}
	}
	
	public double getItemCost(int itemId){
		return items.get(itemId).getCost();
	}
	
	public String getItemName(int itemId){
		return items.get(itemId).getName();
	}
	
}
