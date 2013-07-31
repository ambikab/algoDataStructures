import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Checks if two strings are anagrams. 
 * @author ambika_b
 *
 */

public class AnagramChecker {

	public static int[] populateChar(String name) {
		int[] charCount1 = new int[26];
		for (int i = 0; i < name.length(); i++) {
			charCount1[name.charAt(i) - 'a']++;
		}
		return charCount1;
	}

	public static boolean checkAnagram(String sr1, String sr2) {
		int[] charCount1 = populateChar(sr1);
		int[] charCount2 = populateChar(sr2);
		for (int i = 0; i < 26; i++)
			if (charCount1[i] != charCount2[i]) 
				return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String ip1, ip2;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		ip1 = bReader.readLine();
		ip2 = bReader.readLine();
		System.out.println(checkAnagram(ip1,ip2) ? "true" : "false" );
	}

}
