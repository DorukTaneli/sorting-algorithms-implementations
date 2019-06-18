package code;

import java.util.Random;

import given.AbstractArraySort;

/*
 * Implement the quick-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {  
	//Add any fields here

	public QuickSort()
	{
		name = "Quicksort";

		//Initialize anything else here
	}

	//useful if we want to return a pair of indices from the partition function.
	//You do not need to use this if you are just returning and integer from the partition
	public class indexPair {
		public int p1, p2;

		indexPair(int pos1, int pos2)
		{
			p1 = pos1;
			p2 = pos2;
		}

		public String toString()
		{
			return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
		}
	}


	@Override
	public void sort(K[] inputArray){
		//TODO:: Implement the quicksort algorithm here
		sortHelper(inputArray, 0, inputArray.length - 1);
	}
	
	protected void sortHelper(K[] inputArray, int lo, int hi){
		if (lo< hi) {
			int p = pickPivot(inputArray, lo, hi);
			indexPair pair = partition(inputArray, lo, hi, p);
			int k1 = pair.p1;
			int k2 = pair.p2;
			sortHelper(inputArray, lo, k1);
			sortHelper(inputArray, k2, hi);
		}
	}

	//Public since we are going to check its output!
	public indexPair partition(K[] A, int lo, int hi, int p) {
		//TODO:: Implement a partitioning function here
		int e = lo;
		int u = lo;
		int g = hi + 1;
		K pivotElement = A[p];
		while (u < g) {
			if (compare(A[u], pivotElement) < 0) {
				swap(A, u, e);
				u++;
				e++;
			} else if (compare(A[u], pivotElement) == 0){
				u++;
			} else {
				g--;
				swap(A, u, g);
			}
		}
		return new indexPair(e, g);
		
//		swap(A, p, hi);
//		int u = lo;
//		int g = hi - 1;
//		while (u <= g) {
//			while (u <= g && compare(A[u], A[hi]) <= 0)
//				u++;
//			while (u <= g && compare(A[g], A[hi]) > 0)
//				g--;
//			if (u <= g){
//				swap(A, u , g);
//				u++;
//				g--;
//			}
//		}
//		swap(A, u, hi);
//		return new indexPair(u-1, u+1);
	}

	// Alternative, if you are just returning an integer
//	public int partition(K[] A, int lo, int hi, int p)
//	{
//		//TODO:: Implement a partitioning function here
//		swap(A, p, hi);
//		int u = lo;
//		int g = hi - 1;
//		while (u <= g) {
//			while (u <= g && compare(A[u], A[hi]) <= 0)
//				u++;
//			while (u <= g && compare(A[g], A[hi]) > 0)
//				g--;
//			if (u <= g){
//				swap(A, u , g);
//				u++;
//				g--;
//			}
//		}
//		swap(A, u, hi);
//		return null;
//	}

	//The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods  
	protected int pickPivot(K[] inputArray, int lo, int hi)
	{
		//TODO: Pick a pivot selection method and implement it
		Random random = new Random();
        return random.nextInt((hi - lo) + 1) + lo;
	}
}
