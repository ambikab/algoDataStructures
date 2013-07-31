/**
 * 
 * @author ambika_b
 * Sorts the array of items using Quick Sort
 */

public class QuickSort {

	/**
	 * Given array is partitioned by placing items[lo] at the right position in the array
	 * @param items
	 * @param lo
	 * @param hi
	 */
	public static int partition(Comparable[] items, int lo , int hi) {
		int k = lo++;
		int high = hi;
		while(lo <= hi) {
			while(low(items[lo],items[k])) //move the low pointer to a swap-able position
				if(++lo > high) break;
			while(low(items[k],items[hi])) // move the high pointer to a swap-able position.
				if(--hi < k) break;				
			if(lo < hi) 
				exchange(items, lo, hi);
		}
		exchange(items, k, hi);
		return hi;
	}

	/**
	 * sort the items
	 * @param items
	 */
	public static void sort(Comparable[] items) {
		sort(items, 0, items.length-1);
	}

	/**
	 * 
	 * @param items
	 * @param lo
	 * @param hi
	 */
	public static void sort(Comparable[] items, int lo, int hi) {
		if(hi <= lo ) return ;
		int k = partition(items,lo, hi);
		if(k > lo)
			sort(items, lo, k-1);
		if(k < hi)
			sort(items, k+1, hi);
	}

	/**
	 *  if j is GREATER THAN i return true
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public static boolean low(Comparable j , Comparable i) {
		return (i.compareTo(j) < 0);
	}

	/**
	 * checks if the array is sorted
	 * @param items
	 * @return boolean
	 */
	public static boolean isSorted(Comparable[] items) {
		for(int i = 0; i < items.length-1; i++)
			if(low(items[i+1], items[i])) return false;
		return true;
	}

	/**
	 * prints the element in the items. 
	 * @param items
	 */
	public static void show(Comparable[] items) {
		for(int i = 0; i < items.length; i++) 
			System.out.println(items[i].toString());
	}

	/**
	 * interchanges array's element between the given indices.
	 * @param items
	 * @param i
	 * @param j
	 */
	public static void exchange(Comparable[] items, int i, int j) {
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

}
