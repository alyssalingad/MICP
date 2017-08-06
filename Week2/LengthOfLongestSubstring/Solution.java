/*
 * Alyssa Lingad
 * 
 * MICP: Week 1
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;



public class Solution
{
/*  
Longest Substring Without Repeating Characters
 
Given a string, find the length of the longest substring without repeating characters.


Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

	1. Talk
	- takes in a string and returns an int
	- assume there are no spaces in the input and only alphanumeric characters are allowed
	- case matters
	
	
	2. Example
	string with repeating characters
		aaaaaa --> 1
	string with no repeating characters
		abcde --> 5
	
	
	3. Brute Force	
	
	lengthOfLongestSubstring(string s):
		longestLength = -1
		ptr1 = 0
		ptr2 = 0
		set = {}
		while ptr1 && ptr2 < len(s):
			if s[ptr1] not in set:
			 	set.append(s[ptr1])
			 	ptr2++
			else:
				set.clear()
				ptr1++
				ptr2 = ptr1
			longestLength = max(longestLength, len(set)+1)
		return longestLength
		
	4. Optimize
	

	
	5. Walk Through
	6. Implement

*/
	public static int lengthOfLongestSubstring(String s){
		int longestLength = -1;
		int index1 = 0;
		int index2 = 0;
		HashSet<Character> seenChars = new HashSet<Character>();
		while (index1 < s.length() && index2 < s.length()){
			char currentChar = s.charAt(index2);
			if (!seenChars.contains(currentChar)){
				seenChars.add(currentChar);
				index2++;
			}
			else {
				seenChars.clear();
				index1++;
				index2 = index1;
			}
			longestLength = Math.max(longestLength, seenChars.size());
		}
		return longestLength;
	}
	
	@Test
	public void testSolution(){
		assertEquals(2, lengthOfLongestSubstring("bBbBbB"));
		assertEquals(1, lengthOfLongestSubstring("bbbbbbb"));
		assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
		assertEquals(3, lengthOfLongestSubstring("pwwkew"));
		assertEquals(9, lengthOfLongestSubstring("werppeerabcfghiiiii"));
		assertEquals(6, lengthOfLongestSubstring("ccccaAbBcCaaaa"));
	}
	
}
