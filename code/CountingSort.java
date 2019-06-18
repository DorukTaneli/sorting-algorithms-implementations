package code;

import java.util.Arrays;
import java.util.Collections;

import given.AbstractArraySort;

/*
 * Implement the c algorithm here. You can look at the slides for the pseudo-codes.
 * You do not have to use swap or compare from the AbstractArraySort here
 * 
 * You may need to cast any K to Integer
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	//Add any fields here

	public CountingSort()
	{
		name = "Countingsort";
	}

	@Override
	public void sort(K[] inputArray) {

		if(inputArray == null)
		{
			System.out.println("Null array");
			return;
		}
		if(inputArray.length < 1)
		{
			System.out.println("Empty array");
			return;
		}   

		if(!(inputArray[0] instanceof Integer)) {
			System.out.println("Can only sort integers!");
			return;
		}

		//TODO:: Implement the counting-sort algorithm here
		int minKey = (Integer) Collections.min(Arrays.asList(inputArray));
		int maxKey = (Integer) Collections.max(Arrays.asList(inputArray));
		int k = maxKey - minKey + 1;
		int[] counts = new int[k];
		for (int i = 0; i < inputArray.length; i++) {
			counts[(Integer) inputArray[i] - minKey]++;
		}
		int c = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < counts[i]; j++) {
				Object temp = i + minKey;
				inputArray[c] =  (K) temp;
				c++;
			}
		}
	}
}
