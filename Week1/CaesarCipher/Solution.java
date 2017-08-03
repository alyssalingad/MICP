/*
 * Alyssa Lingad
 * 
 * MICP: Week 1
 */

import static org.junit.Assert.*;
import org.junit.Test;



public class Solution
{
/* Caesar Cipher
 * 
 * The code you will write is based on the “Caesar Cipher” 
 * where each letter is shifted a certain number of places left or right
 * through the alphabet. The alphabet is treated as being circular
 * so that the first letter follows after the last letter, and the
 * last letter precedes the first letter. 
 * 
 * These ideas will be applied separately 
 * to uppercase letters, lower case letters, and digits. 
 * 
 * For example, with a shift of 1, 
 * ‘A’ becomes ‘B’, 
 * ‘Z’ becomes ‘A’, 
 * ‘a’ becomes ‘b’, 
 * ‘z’ becomes ‘a’, 
 * ‘0’ becomes ‘1’, 
 * ‘9’becomes ‘0’. 
 * 
 * Spaces, punctuation, and any other symbols are unaffected in this scheme. 
 * Your task is to write a function to encrypt a string using this Caesar Cipher.
 * 
 * 
 * 
 * INPUT FORMAT
 * 
 * Your function will take an input string that 
 * begins with a number representing the shift. 
 * The number will be in the range 
 * -1000000000 to 1000000000 (negative 1 billion to 1 billion). 
 * The number is followed by a colon (‘:’). 
 * The rest of the line consists of 
 * a string of 1 to 200 arbitrary characters and 
 * represents a fragment of the text to be encrypted.
 * 
 * 
 * OUTPUT FORMAT
 * Output will be the corresponding encrypted text fragment
 * 
 * 
 * SAMPLE INPUT:
 * 1:some text
 * 
 * 
 * SAMPLE OUTPUT:
 * tpnf ufyu

  	
	
	1. Talk
	- if input is invalid, print out error msg
	
	
	2. Example
	Number > 1 billion || Number < -1 billion 
		-2 billion:Hello --> ERROR
		2 billion:Hello --> ERROR
	String < 1 chars || String > 200 chars
		1: --> ERROR
		1:Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say
			that they were perfectly normal, thank you very much. They were the last
			people you'd expect to be involved in anything strange or mysterious,
			because they just didn't hold with such nonsense. --> ERROR
	Incorrect separator
		1+Hello
	Correct Input w/ spaces, punctuation, and any other symbols
		1:abcd ! efghi -> bcde ! fghij
	Correct Input w/ only letters + numbers
		1:hello1 -> ifmmp2
	Correct Input w/ negative num
		-1:abcd -> zabc
	
	3. Brute Force	
	
	caesarCipher(string s):
		num = s.split(":")[0]
		text = s.split(":")[1]
		baseAlpha = "abcdefghijklmnopqrstuvwx"
		baseNum = "0123456789"
		ciphered = ""
		
		if not correct input:
			output error msg
		else:
			for char in s:
				index;
				
				if char in baseAlpha:
					if char is lowercase:
						index = (baseAlpha.indexOf(char) + num) % baseAlpha.length
						ciphered += baseAlpha.charAt(index)
					else if char is uppercase:
						index = (baseAlpha.indexOf(char.lower) + num) % baseAlpha.length
						ciphered += (baseAlpha.chartAt(index)).upper
				else if in baseNum:
					ciphered += baseNum.indexOf(char) % baseNum.length
				else:
					ciphered += char
				
			return ciphered
		
	4. Optimize
	
	caesarCipher(string s):
		num = s.split(":")[0]
		text = s.split(":")[1]
		ciphered = ""
		
		if not correct input:
			output error msg
		else:
			for char in s:
				newChar = char;
				if isAlpha:
					newChar = (char + num) % ('z' - 'a')
				else if isNum:
					newChar = (char + num) % ('9' - '0')
				ciphered += newChar
			return ciphered
	
	5. Walk Through
	6. Implement

*/
	public static String caesarCipher(String s) throws IncorrectFormatException,
	NumberOutOfBoundsException, TextLengthOutOfBoundsException{
		int num;
		String text;
		String ciphered = "";
		
		// Error checking
		if (s.indexOf(":") < 0){
			throw new IncorrectFormatException();
			//return "Error: incorrect separator";
		}
		
		String[] parts = s.split(":");
		try {
			num = (int) Double.parseDouble(parts[0]);
		}
		catch (Exception e){
			throw new IncorrectFormatException();
		}
		double max = Math.pow(10, 9);
		double min = -max;
		
		if (num < min || num > max){
			throw new NumberOutOfBoundsException();
		}
		else if (parts.length < 2){
			throw new TextLengthOutOfBoundsException();
		}
		
		text = parts[1];
		if (text.length() < 1 || text.length() > 200){
			throw new TextLengthOutOfBoundsException();
		}

		
		for (int i = 0; i < text.length(); i++){
			char c = text.charAt(i);
			int ascii = c;
			if (Character.isLetter(c)){
				ascii = (c + num) % ('z');
			}
			else if (Character.isDigit(c)){
				ascii = (c + num) % ('9');
			}
			ciphered += Character.toString((char) ascii);
		}

		return ciphered;
		
	}
	
	@Test(expected=NumberOutOfBoundsException.class)
	public void testNumberOutOfBoundsMax() throws IncorrectFormatException,
	NumberOutOfBoundsException, TextLengthOutOfBoundsException{
		caesarCipher("10000000000:Hello");
	}
	
	@Test(expected=NumberOutOfBoundsException.class)
	public void testNumberOutOfBoundsMin() throws IncorrectFormatException,
	NumberOutOfBoundsException, TextLengthOutOfBoundsException{
		caesarCipher("-10000000000:Hello");
	}
	
	@Test(expected=TextLengthOutOfBoundsException.class)
	public void testTextOutOfBoundsMin() throws IncorrectFormatException,
	NumberOutOfBoundsException, TextLengthOutOfBoundsException{
		caesarCipher("1:");
	}
	
	@Test(expected=TextLengthOutOfBoundsException.class)
	public void testTextOutOfBoundsMax() throws IncorrectFormatException,
	NumberOutOfBoundsException, TextLengthOutOfBoundsException{
		caesarCipher("1:Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say that they were perfectly normal, thank you very much. They were the last people you'd expect to be involved in anything strange or mysterious, because they just didn't hold with such nonsense.");
	}
	
	@Test(expected=IncorrectFormatException.class)
	public void testIncorrectSeparator() throws IncorrectFormatException,
	NumberOutOfBoundsException, TextLengthOutOfBoundsException{
		caesarCipher("1+Hello");
	}

	@Test 
	public void testCaesarCipher() throws IncorrectFormatException,
	NumberOutOfBoundsException, TextLengthOutOfBoundsException{
		// Correct Input w/ spaces, punctuation, and any other symbols
		assertEquals("bc! de", caesarCipher("1:ab! cd"));
		
		// Correct Input w/ only letters + numbers
		assertEquals("bcde", caesarCipher("1:abcd"));
		assertEquals("cdef", caesarCipher("2:abcd"));
		
		// Correct Input w/ negative num
		assertEquals("abcd", caesarCipher("-1:bcde"));
		assertEquals("abcd", caesarCipher("-2:cdef"));

	}
	
}
