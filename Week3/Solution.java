/*
 * Alyssa Lingad
 * 
 * MICP: Week 3
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;



public class Solution
{
	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> S){
		if (S == null || S.size() < 3){
			return null;
		}
		Collections.sort(S);
		if (S.get(0) >= 0){
			return null;
		}
		ArrayList<ArrayList<Integer>> endArr = new ArrayList();
		int i = 0;
		int size = S.size();
		
		while (i < size - 2){
			int curr = S.get(i);
			int j = i + 1;
			while(j < size - 1){
				int next = S.get(j);
				int wanted = -curr - next;
				ArrayList<Integer> tempArr = new ArrayList<Integer>();
				tempArr.add(curr);
				tempArr.add(next);
				tempArr.add(wanted);
				if (S.subList(j+1, size).contains(wanted) && !endArr.contains(tempArr) ){
					endArr.add(tempArr);
				}
				else {
					j++;
				}
			}
			i++;
		}
		if (endArr.size() == 0){
			return null;
		}
		return endArr;
	}
	
	@Test
	public void testNull(){
		assertEquals(null, threeSum(null));
	}
	
	@Test
	public void testOneInput(){
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(0);
		assertEquals(null, threeSum(S));
	}
	
	@Test
	public void testEmpty(){
		ArrayList<Integer> S = new ArrayList<Integer>();
		assertEquals(null, threeSum(S));
	}
	
	@Test
	public void testAllPositive(){
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(1);
		S.add(2);
		S.add(3);
		assertEquals(null, threeSum(S));
	}
	
	@Test
	public void testAllNegative(){
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(-1);
		S.add(-2);
		S.add(-3);
		assertEquals(null, threeSum(S));
	}
	
	@Test
	public void testHasASolution(){
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(-1);
		S.add(1);
		S.add(0);
		
		ArrayList<ArrayList<Integer>> correct = new ArrayList();
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.add(-1);
		abc.add(0);
		abc.add(1);
		correct.add(abc);
		assertEquals(correct, threeSum(S));
	}
	
	@Test
	public void testHasMultipleSolutions(){
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(-1);
		S.add(0);
		S.add(1);
		S.add(2);
		S.add(-1);
		S.add(-4);
		
		ArrayList<ArrayList<Integer>> correct = new ArrayList();
		ArrayList<Integer> abc = new ArrayList<Integer>();
		abc.add(-1);
		abc.add(-1);
		abc.add(2);
		correct.add(abc);
		
		ArrayList<Integer> abc2 = new ArrayList<Integer>();
		abc2.add(-1);
		abc2.add(0);
		abc2.add(1);
		correct.add(abc2);
		
		assertEquals(correct, threeSum(S));
	}
	
	@Test
	public void testHasNoSolution(){
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(2);
		S.add(1);
		S.add(-1);

		assertEquals(null, threeSum(S));
	}
}
