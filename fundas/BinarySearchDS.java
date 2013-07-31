

import java.util.Arrays;

public class BinarySearchDS implements BinarySearch {

	private int[] array;

	public BinarySearchDS() {
		array = null;
	}

	public BinarySearchDS(int N) {
		this.array = new int[N];
	}

	@Override
	public int rank(int lo, int hi, int key) {
		int mid = lo + (hi -lo) / 2;
		if(lo == hi)
			return -1;
		else {
		if(this.array[mid] < key)
			return rank(mid+1, hi, key);
		else if(this.array[mid] > key)
			return rank(lo, mid-1, key);
		else 
			return mid;
		}
	}

	public void sortArray() {
		Arrays.sort(this.array);
	}
	public static void main(String args[]) {
		int arraySize = StdIn.readInt();
		BinarySearchDS binarySearch = new BinarySearchDS(arraySize);
		for(int i=0; i<arraySize; i++)
			binarySearch.array[i] = StdIn.readInt();
		System.out.println("enter a number to be searched :");
		int key = StdIn.readInt();
		System.out.println(binarySearch.rank(0, arraySize - 1, key));
		
	}
}
