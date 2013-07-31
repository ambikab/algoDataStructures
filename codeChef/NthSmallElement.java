/**
 * Finds the `n`th smallest element.
 * @author ambika_b
 *
 */
public class NthSmallElement {

	/**
	 * Moves array[lo] to its final position in the sorted array
	 * Returns the final index
	 * @param array
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int partition(Comparable[] items, int hi, int lo) {
		int k = lo++;
		int high = hi;
		while(lo <= hi) {
			while(less(items[lo],items[k]) && (++lo <= high)); 
			while(less(items[k],items[hi]) && (--hi > k)); 
			if(lo < hi) 
				exchange(items, lo, hi);
		}
		exchange(items, k, hi);
		return hi;		
	}

	/**
	 * exchanges the value between the given positions 
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void exchange(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Finds the `n` the smallest element in the given array
	 * @param array
	 * @param hi
	 * @param lo
	 */
	public static void find(Comparable[] array, int hi, int lo, int position) {
		int k = partition(array, hi, lo);
		if (k > position) 
			find(array, k-1, lo, position);
		else if (k < position) 
			find(array, hi, k+1, position);
		else if (k == position)
			System.out.println("`"+(position+1)+"` smallest number is : " + array[k]);
	}

	/**
	 * returns the `n`th smallest element in the given array
	 * @param array
	 * @param position
	 * @return
	 */
	public static void findN(Comparable[] array, int position) {
		find(array, array.length-1, 0, position-1);
	}

	/**
	 * returns true if lesser < greater
	 * @param greater
	 * @param lesser
	 * @return
	 */
	public static boolean less(Comparable lesser , Comparable greater) {
		return greater.compareTo(lesser) > 0;
	}

	public static void main(String[] args) {
		Integer[] inputArray = {new Integer("10"),new Integer("1"),new Integer("200"),new Integer("50"),new Integer("60")};
		int position = 5;
		findN(inputArray, position);
	}
}
