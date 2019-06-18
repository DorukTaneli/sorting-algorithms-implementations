package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import code.QuickSort.indexPair;
import given.AbstractArraySort;

/*
 * Your sorting algorithm for the sorting spree! 
 * You do not need to use the swap and compare methods of AbstractArraySort here
 * Only the speed of the code and the correctness of the output will be checked
 * 
 * We suggest that you use a hybrid algorithm!
 * 
 */

public class ContestEntrySort<K extends Comparable<K>> extends AbstractArraySort<K> {

	public ContestEntrySort() {
		// Change the name with your ID!
		name = "60066";

		//Initialize anything else here
	}

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
	}

	// Alternative, if you are just returning an integer


	//The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods  

	protected int pickPivot(K[] inputArray, int lo, int hi)
	{
		//TODO: Pick a pivot selection method and implement it
		Random random = new Random();
        return random.nextInt((hi - lo) + 1) + lo;
	}

	public void insertionSort(K[] inputArray, int lo, int hi) 
	{   
		//TODO: Implement the insertion sort algorithm
		int j;
		for (int i = lo; i < hi; i++) {
			j = i;
			while(j >lo && compare(inputArray[j - 1], inputArray[j]) > 0){
				swap(inputArray, j, j - 1);
				j--;
			}
		}
	}
}	

//	protected void qsortD(K[] A, int lo, int hi, int depth){
//		if(lo < hi){
//			if(hi - lo < 5){
//				insertionSort(A, lo, hi);
//			}else if (depth > 0){
//				int p = pickPivot(A, lo, hi);
//				indexPair pair = partition(A, lo, hi, p);
//				int k1 = pair.p1;
//				int k2 = pair.p2;
//				qsortD(A, lo, k1, depth);
//				qsortD(A, k2, hi, depth);
//			}else
//				heapSort(A, lo, hi);
//		}
//	}
