import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * PROBLEM: http://www.codechef.com/JULY13/problems/GALACTIK
 * @author ambika_b
 */

public class Galactik {

	static int[] teams;
	static int[] costs;
	static int[] setSize;
	static int setCount;

	public static long minTax() {
		long tax = 0;
		int min_tax = -1;
		Map<Integer,Integer> connectedSets = new HashMap<Integer, Integer>();
		if (setCount == 1) return 0;
		for (int i = 0; i < teams.length; i++) {
			int key = root(teams[i]);
			if (!connectedSets.containsKey(key)) {
				connectedSets.put(key,costs[teams[i]]);
				if (costs[key] < 0 && i != 0) return -1;
				min_tax = minCost(min_tax, costs[key]);
				tax += costs[key];
			}
		}
		return tax - min_tax + (setCount - 1) * min_tax;
	}

	public static int minCost(int root, int oldParent) {
		if (root < 0 || oldParent < 0) 
			return Math.max(root, oldParent);
		else
			return Math.min(root, oldParent);
	}

	public static void union(int parent, int child) {
		if (!isConnected(parent, child)) {
			setCount--;
			int newRoot,discardRoot,parent1 = root(child), parent2 = root(parent);
			if (setSize[parent1] > setSize[parent2]) {
				newRoot = parent1;
				discardRoot = parent2;
			} else { 
				discardRoot = parent1;
				newRoot = parent2;
			}
			setSize[newRoot] += setSize[discardRoot];
			int min = minCost(costs[parent1], costs[parent2]);
			teams[discardRoot] = teams[newRoot];
			costs[discardRoot] = costs[newRoot] = min;
		}
	}

	public static int root(int node) {
		if (node == teams[node])
			return node;
		else
			return root(teams[node]);
	}

	public static boolean isConnected(int node1, int node2) {
		return teams[node1] == teams[node2];
	}

	public static void initialize(int size, Input inputUtils) {
		costs = new int[size];
		teams = new int[size];
		setSize = new int[size];
		setCount = size;
		for(int i = 0; i < size; i++) {
			teams[i] = i;
			costs[i] = inputUtils.nextInt();
			setSize[i] = 0;
		}
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		Input inputUtils = new Input(System.in);
		int nodes = inputUtils.nextInt();
		int connection = inputUtils.nextInt();
		StringBuilder union = new StringBuilder();
		while(connection-- > 0) 
			union.append(inputUtils.nextInt() + " " + inputUtils.nextInt() +" ");			
		initialize(nodes, inputUtils);
		StringTokenizer tokens = new StringTokenizer(union.toString());
		while(tokens.hasMoreTokens())
			union(Integer.parseInt(tokens.nextToken()) - 1, Integer.parseInt(tokens.nextToken()) - 1);
		System.out.println(minTax()+"\n");
	}

}

/**
 * Improve the efficiency of reading an input
 * @author ambika_b
 *
 */
class Input
{
	int position,cnt;
	byte[] buffer = new byte[1<<64];
	InputStream iStream;

	public Input(InputStream in)
	{
		this.iStream = in;
		position = 0;
		cnt = 0;
	}

	public int nextInt()
	{
		int c=read(),sign=1;
		while (c <= ' ')
			c = read();
		if(c=='-')
		{
			sign=-1;
			c=read();
		}
		int n = c - '0';
		while((c=read()-'0') >= 0)
			n = n*10 + c;
		return n*sign;

	}

	public int read()
	{
		if( position == cnt)
			fillBuffer();
		return buffer[position++];		
	}

	private void fillBuffer()
	{
		try {
			cnt = iStream.read(buffer, position=0 , buffer.length);
		}catch(Exception e) {
			System.out.println("Exception Occured");
		}

	}
} 
