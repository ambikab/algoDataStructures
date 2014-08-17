import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Uses Quick sort
 * @author ambika_b
 *
 */

public class Johny {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		//total number of test cases.
		StringBuilder result = new StringBuilder();
		int testCase = Integer.parseInt(bReader.readLine());
		while (testCase-- > 0) {
			// number of songs in every test case.
			int songs = Integer.parseInt(bReader.readLine());
			// length of each test case.
			StringTokenizer tokens = new StringTokenizer( bReader.readLine());
			int[] playList = new int[songs];
			for(int i = 0; i < tokens.countTokens(); i++) 
				playList[i] = Integer.parseInt(tokens.nextToken());
			int position = Integer.parseInt(bReader.readLine());
			//exchange to the first position.
			exchange(0, position - 1, playList);
			result.append(partition(playList, 0, songs - 1) + "\n");
		}
		System.out.println(result.toString());
	}
	
	public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) { 
            while ((a[++i] > v))
                if (i == hi) break;
            while ((v < a[--j]))
                if (j == lo) break;      
            if (i >= j) break;
            exchange(i, j, a);
        }
        exchange(lo, j, a);
        return j + 1;
    }
	
	public static void exchange(int pos1, int pos2, int[] array) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

}
