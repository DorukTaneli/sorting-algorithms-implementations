package code;

import given.AbstractArraySort;

/*
 * Implement the merge-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 * You may need to create an Array of K (Hint: the auxiliary array). 
 * Look at the previous assignments on how we did this!
 * 
 */

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here
	K[] auxA;
	
	public MergeSort() {
		name = "Mergesort";

		// Initialize anything else here
	}

	@Override
	public void sort(K[] A) {
		// TODO: Implement the merge-sort algorithm
		auxA = (K[]) new Comparable[A.length];
		sortHelper(A, 0, A.length-1);
	}
	
	protected void sortHelper(K[] A, int lo, int hi){
		if(lo < hi){
			int mid = (lo + hi)/2;
			sortHelper(A, lo, mid);
			sortHelper(A, mid+1, hi);
			merge(A, lo, mid, hi);
		}
	}

	// Public since we are going to check its output!
	public void merge(K[] A, int lo, int mid, int hi) {
		// TODO: Implement the merging algorithm
		deepCopy(A, auxA, lo, hi);
		int i = lo;
		int k = lo;
		int j = mid + 1;
		while (k <= hi) {
			if (j > hi || (i <= mid && compare(auxA[i], auxA[j]) <= 0)) {
				A[k] = auxA[i];
				k++;
				i++;
			} else {
				A[k] = auxA[j];
				k++;
				j++;
			}
		}
	}
	
	protected void deepCopy(K[] A, K[] auxA, int lo, int hi){
		for (int i = lo; i <= hi; i++) {
			auxA[i] = A[i];
		}
	}

	// Feel free to add more methods
}
