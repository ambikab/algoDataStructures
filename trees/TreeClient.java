import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Client to test Binary Search Tree
 * @author ambika_b
 *
 */

public class TreeClient {

	public static void main(String[] args) throws Exception {
		BinarySearchTree<Integer, String> searchTree = new BinarySearchTree<Integer, String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer getKeyTokens = new StringTokenizer(br.readLine());
		StringTokenizer getValueTokens = new StringTokenizer(br.readLine());
		while (getKeyTokens.hasMoreTokens()) {
			Integer key = Integer.parseInt(getKeyTokens.nextToken());
			searchTree.put(key, getValueTokens.nextToken());
		}
		
		for (Integer keys : searchTree ) {
			System.out.print(keys);			
		}

		
	}

}
