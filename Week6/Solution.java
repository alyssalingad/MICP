/*
 * Alyssa Lingad
 * 
 * MICP: Week 6
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;



public class Solution
{
	public static class Node {
		int val;
		Node left;
		Node right;
		public Node (int val, Node left, Node right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public String toString(){
			return "Node{value:" + this.val + " left:" + this.left + " right:" + this.right + "}";
		}
	}
	
	public static boolean isSubtree(Node s, Node t){
		// must check if t is null first
		if (t == null){
			return true;
		}
		if (s == null){
			return false;
		}
		// check for equality
		if (isSame(s,t)){
			return true;
		}
		// continue traversing s
		else {
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
	}
	
	public static boolean isSame(Node s, Node t){
		if (s == null && t == null){
			return true;
		}
		if (s == null || t == null){
			return false;
		}
		return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
	}
	
	@Test
	public void testSIsNull(){
		Node s = null;
		Node t = new Node(1, null, null);
		assertFalse(isSubtree(s, t));
	}
	
	@Test
	public void testTIsNull(){
		Node s = new Node(1, null, null);
		Node t = null;
		assertTrue(isSubtree(s, t));
	}
	
	@Test
	public void testBothInputsAreNull(){
		Node s = null;
		Node t = null;
		assertTrue(isSubtree(s, t));
	}
	
	@Test
	public void testSameTree(){
		Node s = new Node(1, null, new Node(2, null, null));
		Node t = new Node(1, null, new Node(2, null, null));
		assertTrue(isSubtree(s, t));
	}
	
	@Test
	public void testSameValuesDifferentStructure(){
		Node a = new Node(1, null, null);
		Node b = new Node(2, null, a);
		Node c = new Node(1, null, null);
		Node d = new Node(1, null, null);
		
		Node s = new Node(1, null, b);
		Node t = new Node(2, c, d);
		
		assertEquals(false, isSubtree(s, t));
	}
	
	@Test
	public void testSameStructureDifferentValues(){
		Node a = new Node(11, null, null);
		Node b = new Node(4, null, null);
		
		Node c = new Node(10, null, null);
		Node d = new Node(9, null, null);
		
		Node s = new Node(5, a, b);
		Node t = new Node (8, c, d);
	}
}
