
public class Item
{
	double cost;
	String name;
	private int itemCount;
	int id;
	
	public Item(double cost, String name, int itemCount, int id){
		this.cost = cost;
		this.name = name;
		this.itemCount = itemCount;
		this.id = id;
	}
	
	public void subtract(){
		itemCount--;
	}
	
	public double getCost(){
		return cost;
	}
	
	public int getItemCount(){
		return itemCount;
	}
	
	public String getName(){
		return name;
	}
	
}
