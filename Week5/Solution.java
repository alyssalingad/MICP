/*
 * Alyssa Lingad
 * 
 * MICP: Week 4
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;



public class Solution
{
	public static boolean isPalindrome(Node head) throws Exception{
		if (head == null){
			throw new Exception();
		}
		Node copy = copyLL(head);
		int nodeCount = 0;
		
		Node prev = null;
		Node curr = copy;
		Node next = null;
		while (curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			nodeCount++;
		}
		copy = prev;
		
		int stoppingPoint = nodeCount / 2;

		while (stoppingPoint > 0){
			if (copy.value != head.value){
				return false;
			}
			copy = copy.next;
			head = head.next;
			stoppingPoint--;
		}
		return true;
	}
	
	public static Node copyLL(Node head){
		if (head == null){
			return null;
		}
		else{
			return new Node(head.value, copyLL(head.next));
		}
	}
	
	@Test(expected=Exception.class)
	public void testNullStr() throws Exception{
		isPalindrome(null);
	}

	@Test
	public void testSingleNode() throws Exception{
		assertTrue(isPalindrome(new Node('a', null)));
		assertTrue(isPalindrome(new Node('1', null)));
		assertTrue(isPalindrome(new Node('!', null)));
	}
	
	@Test
	public void testTwoNodes() throws Exception{
		assertFalse(isPalindrome(new Node('a', new Node('b', null))));
		assertTrue(isPalindrome(new Node('a', new Node('a', null))));
	}
	
	@Test
	public void testThreeNodes() throws Exception{
		assertFalse(isPalindrome(new Node('a', new Node('b', new Node('b', null)))));
		assertTrue(isPalindrome(new Node('a', new Node('b', new Node('a', null)))));
		assertTrue(isPalindrome(new Node('a', new Node(' ', new Node('a', null)))));
	}
	
}
