import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class UncleJohny {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int testCase = Integer.parseInt(bReader.readLine());
		while (testCase-- > 0) {
			int size = Integer.parseInt(bReader.readLine());
			StringTokenizer tokens = new StringTokenizer( bReader.readLine());
			int[] playList = new int[size];
			for(int i = 0; i < size; i++)
				playList[i] = Integer.parseInt(tokens.nextToken());
			int position = Integer.parseInt(bReader.readLine());
			int song = playList[position - 1];
			Arrays.sort(playList);
			result.append((Arrays.binarySearch(playList, song) + 1) + "\n");
		}
		System.out.println(result.toString());
	}

}
