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
	public static boolean canBeSegmented(String str, HashSet d) throws Exception{
		int i = 0;
		if (str == null)
			throw new Exception();
		if (str.isEmpty())
			return false;
		if (d.isEmpty())
			return false;
		
		int size = str.length();
		String s = str.toLowerCase();
		boolean check = false;
		int lastFound = 0;
		while (i < size){
			int j = i;
			check = false; 
			while (j < size){
				if (d.contains(s.substring(i, j+1)) || d.contains(s.substring(lastFound, j+1))){
					check = true;
					lastFound = i;
					break;
				}
				j++;
			}
			if (!check)
				return false;
			if (j == size){
				return true;
			}
			i = j + 1;
		}
		return check;
	}
	
	@Test(expected=Exception.class)
	public void testNullStr() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("pear");
		assertEquals(null, canBeSegmented(null, d));
	}
	
	@Test
	public void testStringLengthOne() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("a");
		assertEquals(true, canBeSegmented("a", d));
	}
	
	@Test
	public void testEmptyStr() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("pear");
		assertEquals(false, canBeSegmented("", d));
	}
	
	@Test
	public void testEmptyDict() throws Exception{
		HashSet<String> d = new HashSet<String>();
		assertEquals(false, canBeSegmented("pear", d));
	}
	
	@Test
	public void testBothWordsInDict() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("you");
		d.add("enjoy");
		assertEquals(true, canBeSegmented("youenjoy", d));
	}
	
	@Test
	public void testOneWordInDict() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("you");
		d.add("enjoy");
		assertEquals(true, canBeSegmented("enjoy", d));
	}
	
	@Test
	public void testSameWordMultipleTimes() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("hello");
		assertEquals(true, canBeSegmented("hellohello", d));
	}
	
	@Test
	public void testCapitalLetterInStr() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("hello");
		assertEquals(true, canBeSegmented("hEllo", d));
	}

	@Test
	public void testPluralAndSingularFormInDict() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("pie");
		d.add("pies");
		assertEquals(true, canBeSegmented("piepies", d));
	}
	
	@Test
	public void testWordWithinWord() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("car");
		d.add("carriage");
		assertEquals(false, canBeSegmented("carcarriages", d));
	}
	
	@Test
	public void testSomeWordsInDictionary() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("monday");
		d.add("tuesday");
		assertEquals(false, canBeSegmented("mondaywednesdaytuesday", d));
	}
	
	@Test
	public void testCannotSegment() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("france");
		assertEquals(false, canBeSegmented("paris", d));
	}
	
	@Test
	public void testGivenExamples() throws Exception{
		HashSet<String> d = new HashSet<String>();
		d.add("pear");
		d.add("salmon");
		d.add("foot");
		d.add("prints");
		d.add("footprints");
		d.add("leave");
		d.add("you");
		d.add("sun");
		d.add("girl");
		d.add("enjoy");
		
		assertEquals(true, canBeSegmented("youleavefootprints", d));
		assertEquals(false, canBeSegmented("salmonenjoyapples", d));
	}
}
