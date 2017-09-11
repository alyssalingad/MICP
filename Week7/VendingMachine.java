
public class VendingMachine
{
	double balance; // amount of money inserted for a purchase
	double changeAvailable; 
	int numOfTransactions;
	Inventory inventory;
	
	public VendingMachine(double changeAvailable){
		this.changeAvailable = changeAvailable;
		this.inventory = new Inventory();
	}
	
	public double getBalance(){ return balance; }
	public double getChangeAvailable(){ return changeAvailable; }
	public int getNumOfTransactions(){ return numOfTransactions; }
	
	public void insertMoney(double money){
		balance += money;
	}
	
	public void purchaseItem(int itemId){
		try {
			checkBalance(itemId);
			inventory.deleteItem(itemId);
			double change = getChange(itemId);
			if (change > changeAvailable){
				throw new InsufficientChangeException();
			}
			System.out.println("Here is your change: " + change);
			changeAvailable += inventory.getItemCost(itemId);
			balance = 0;
		} 
		catch (InsufficientBalanceException e){
			double difference = inventory.getItemCost(itemId) - balance;
			System.out.println("Please insert $" + difference);
		}
		catch (SoldOutItemException e){
			System.out.println("Sorry, " + inventory.getItemName(itemId) + " is sold out.");
		}
		catch (InsufficientChangeException e){
			System.out.print("Sorry, there is not enough change. ");
			System.out.println("Please contact the local building administrator");
		}
	}
	
	public double getItemCost(int itemId){
		return inventory.getItemCost(itemId);
	}
		
	public void cancelRequest(){
		balance = 0;
	}
	
	public double getChange(int itemId){
		return balance - inventory.getItemCost(itemId);
	}
	
	private void checkBalance(int itemId) throws InsufficientBalanceException{
		if (balance < inventory.getItemCost(itemId)){
			throw new InsufficientBalanceException();
		}
	}
}
