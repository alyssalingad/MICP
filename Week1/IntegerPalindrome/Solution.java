/*
 * Alyssa Lingad
 * 
 * MICP: Week 1
 */
import static org.junit.Assert.*;
import org.junit.Test;



public class Solution
{
/*	Integer Palindrome with a twist

  	A Palindrome is a number that reads the same
	forward as it does in reverse. For example, 12321
	is a palindrome because it reads the same going
	from left to right as it does going right to left.
	Most numbers can be made into palindromes by
	taking the original number, reversing the digits,
	then adding the original number to the reversed
	digits. If that number isn’t a palindrome, then
	repeat the same process until you reach a
	palindrome. Most numbers can be made into
	palindromes by repeating this process, but some
	numbers don’t converge. During this process, if
	the number becomes larger than 1,000,000 and
	still doesn’t form a palindrome, then return false.
	
	1. Talk
	We are checking if a number can be a palindrome.
	Make a number into a palindrome by adding the the 
	reverse of the original number to the original number.
	Input is an int.
	
	2. Example
	Single Digit
		1 -> True
	Multi-digit, Larger than 1 million, not a palindrome
		123456789 -> False
	Multi-digit, Larger than 1 million, already palindrome
		123,455,4321
	Multi-digit, Less than 1 million, not already palindrome
		45 + 54 = 99 -> True
		159 + 951 = 1,110 -> 1110 + 0111 = 1221 -> True
	Multi-digit, Less than 1 million, already palindrome
		545
	
	3. Brute Force	
	convergesToPalindrome(n):
		if is palindrome
			return true
		else if n > 1 million
			return false
		else 
			make into a palindrome
			sum = n + reversedN
			return convergesToPalindrome(sum)
	
	4. Optimize
	convergesToPalindrome(n):
		sum = n
		while sum < 1 million:
			if is palindrome
				return true
			else
				sum = sum + reversed sum
		return false
	
	5. Walk Through
	6. Implement

*/
	public static boolean convergesToPalindrome(int n){
		int sum = n;
		while (sum < 1000000){
			if (isPalindrome(sum)){
				return true;
			}
			else {
				sum = sum + getReversed(sum);
			}
		}
		return isPalindrome(sum);
	}
	
	public static boolean isPalindrome(int n){
		return n == getReversed(n);
	}
	
	public static int getReversed(int n){
		int rev = 0;
		while (n > 0){
			rev *= 10;
			rev += (n % 10);
			n = (int) n / 10;
		}
		return rev;
	}
	
	@Test 
	public void testConvergesToPalindrome() {
		// Single Digit
		assertEquals(true,convergesToPalindrome(1)); 
		assertEquals(true,convergesToPalindrome(0)); 
		
		// Multi-digit, Larger than 1 million, not a palindrome
		assertEquals(false,convergesToPalindrome(123456789)); 
		assertEquals(false,convergesToPalindrome(100000002)); 
		
		// Multi-digit, Larger than 1 million, already palindrome
		assertEquals(true,convergesToPalindrome(1234554321));
		assertEquals(true,convergesToPalindrome(1222222221));
		
		// Multi-digit, <= 1 million, not already palindrome, converges to palindrome
		assertEquals(true,convergesToPalindrome(123)); 
		assertEquals(true,convergesToPalindrome(54)); 
		
		// Multi-digit, <= 1 million, not already palindrome, does not converge to palindrome
		assertEquals(false,convergesToPalindrome(999998)); 
		assertEquals(false,convergesToPalindrome(1000000)); 

		// Multi-digit, <= 1 million, already palindrome
		assertEquals(true,convergesToPalindrome(101)); 
		assertEquals(true,convergesToPalindrome(123321)); 
	}
}
