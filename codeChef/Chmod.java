import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 
 * @author ambika_b
 *
 */
public class Chmod {
	
	static int[] toy;
	
	public static int updateMod(int left, int right, int qMod) {
		int ansMod = 1;
		for (int i = left - 1; i < right; i++ ) {
			ansMod = ((toy[i] % qMod) * ansMod ) % qMod;
			if ( ansMod == 0) 
				return ansMod;
		}
		return ansMod;
	}

	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int arraySize = Integer.parseInt(bReader.readLine());
		toy = new int[arraySize];
		StringTokenizer input = new StringTokenizer(bReader.readLine());
		for (int i =0; input.hasMoreTokens(); i++) 
			toy[i] = Integer.parseInt(input.nextToken());
		int noOfGames = Integer.parseInt(bReader.readLine());
		while (noOfGames-- > 0) {
			StringTokenizer gameSeq = new StringTokenizer(bReader.readLine());
			int left = Integer.parseInt(gameSeq.nextToken());
			int right = Integer.parseInt(gameSeq.nextToken());
			int qnsMod = Integer.parseInt(gameSeq.nextToken());
			resultString.append(updateMod(left,right,qnsMod) + "\n");
		}
		System.out.println(resultString);
	}
}
