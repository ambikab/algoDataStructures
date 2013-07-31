import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * June contest 
 * Problem : http://www.codechef.com/JUNE13/problems/LAPIN
 * @author ambika_b
 *
 */
public class Lapin {

	/**
	 * fills the frequency counter for every character in the given string
	 * @param string
	 * @param charFreq
	 */
	public static void fillCharFrequency(String string, int[] charFreq) {
		for(int i = 0; i < string.length(); i++) 
			charFreq[string.charAt(i) % 26]++;			
	}

	/**
	 * checks if the same letter occurs with the same frequency
	 * @param leftFreq
	 * @param rightFreq
	 * @return
	 */
	public static String isLapindrome(int[] leftFreq, int[] rightFreq) {
		for(int i = 0; i < 26; i++) {
			if(leftFreq[i] != rightFreq[i])
				return "NO";
		}
		return "YES";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuilder result = new StringBuilder();
		int middle;
		int[] leftFreq, rightFreq;
		int numberOfTests = Integer.parseInt(bReader.readLine());
		while(numberOfTests-- > 0) {
			input = bReader.readLine();
			middle = input.length() % 2 == 0 ? input.length() / 2 : input.length() / 2 + 1 ;
			leftFreq = new int[26];
			rightFreq = new int[26];
			fillCharFrequency(input.substring(0,  input.length() / 2), rightFreq);
			fillCharFrequency(input.substring(middle, input.length()), leftFreq);
			result.append(isLapindrome(leftFreq, rightFreq)+"\n");
		}
		System.out.println(result.toString());
	}

}
