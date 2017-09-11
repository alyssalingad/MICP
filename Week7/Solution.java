/*
 * Alyssa Lingad
 * 
 * MICP: Week 7
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;



public class Solution
{
	/*	Initial inventory:
	 *  Item(double cost, String name, int itemCount, int id)
	 * 	Item item1 = new Item(1.25, "Peanuts", 10, 1);
		Item item2 = new Item(1.00, "Granola Bar", 7, 2);
		Item item3 = new Item(1.50, "Cookies", 1, 3);
	 */
	
	@Test
	public void testGetItemCost(){
		VendingMachine v = new VendingMachine(100);
		assertEquals(1.25, v.getItemCost(1), 0);
		assertEquals(1.00, v.getItemCost(2), 0);
		assertEquals(1.50, v.getItemCost(3), 0);
	}
	
	@Test
	public void testGetBalance(){
		VendingMachine v = new VendingMachine(100);
		v.insertMoney(5.00);
		assertEquals(5.00, v.getBalance(), 0);
		v.insertMoney(0.25);
		assertEquals(5.25, v.getBalance(), 0);
	}
	
	
	@Test
	public void testPurchaseWithInsufficientBalance(){
		VendingMachine v = new VendingMachine(100);
		v.purchaseItem(3);
	}
	
	@Test
	public void testPurchaseItemWithExactMoney(){
		VendingMachine v = new VendingMachine(100);
		v.purchaseItem(1);
		v.insertMoney(1.25);
		v.purchaseItem(1);
	}
	
	@Test
	public void testPurchaseItemWithChangeLeftover(){
		VendingMachine v = new VendingMachine(100);
		v.purchaseItem(2);
		v.insertMoney(1.25);
		v.purchaseItem(2);
	}
	
	@Test
	public void testRefund(){
		VendingMachine v = new VendingMachine(100);
		v.insertMoney(1.00);
		v.cancelRequest();
		assertEquals(0, v.getBalance(), 0);
	}
	
	@Test
	public void testSoldOut(){
		VendingMachine v = new VendingMachine(100);
		v.insertMoney(1.50);
		v.purchaseItem(3);
		v.insertMoney(1.50);
		v.purchaseItem(3);
	}
	
	@Test
	public void testNoChangeAvailable(){
		VendingMachine v = new VendingMachine(1);
		v.insertMoney(5);
		v.purchaseItem(2);
	}
}
