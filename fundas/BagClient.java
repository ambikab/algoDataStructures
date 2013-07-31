import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BagClient {
	public static void main(String[] args) throws Exception{

		// read in numbers
		BagNodeImpl<Integer> numbers = new BagNodeImpl<Integer>();
		System.out.println("Items to be added to the bag!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sz = new StringTokenizer(br.readLine()," ");
		while (sz.hasMoreTokens()) {
			numbers.add( Integer.parseInt(sz.nextToken()));
		}

		int N = numbers.size();
		System.out.println("Size of the bag : "+N);
		
		//iterate through the bag
		for(int x : numbers)
			System.out.println("Iterating items in the bag: "+x);
		
		// compute sample mean
		int sum = 0;
		for (int x : numbers)
			sum += x;
		double mean = sum/N;

		// compute sample standard deviation
		sum = 0;
		for (int x : numbers) {
			sum += (x - mean) * (x - mean);
		}
		double std = Math.sqrt(sum/(N-1));

		StdOut.printf("Mean:    %.2f\n", mean);
		StdOut.printf("Std dev: %.2f\n", std);
	}
}