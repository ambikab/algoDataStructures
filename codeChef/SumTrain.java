import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PROBLEM :  http://www.codechef.com/problems/SUMTRIAN
 * Uses recursion and memoization
 * @author ambika_b
 */
public class SumTrain {

	int[][] triangle;

	int[][] pathMemoization;

	int triangleSize;

	public void setTriangleSize(int triangleSize) {
		this.triangleSize = triangleSize;
	}
	public void setTriangle(int[][] triangle) {
		this.triangle = triangle;
		//by default initialized to zero.
		this.pathMemoization = new int[triangleSize][triangleSize];
	}

	/**
	 * recursively computes maximum sum from a given node
	 * @param x , y positions of a cell in the matrix
	 */
	public int computeMaxSum(int i , int j) {
		if (i >= triangleSize) 
			return 0;
		else if (pathMemoization[i][j] == 0) {
			int lowerSum = computeMaxSum(i + 1, j);
			int rightSum = computeMaxSum(i + 1, j + 1);
			pathMemoization[i][j] = ( lowerSum > rightSum ?  lowerSum : rightSum )+ triangle[i][j];			
		}
		return pathMemoization[i][j];
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int testCaseCount = Integer.parseInt(bReader.readLine());
		SumTrain train = new SumTrain();
		while (testCaseCount-- > 0) {
			int size = Integer.parseInt(bReader.readLine());
			int[][] newTriangle = new int[size][size];
			train.setTriangleSize(size);
			for (int i = 0; i < train.triangleSize; i++) {
				StringTokenizer inputLine = new StringTokenizer(bReader.readLine());
				for (int j = 0; j <= i; j++ ) 
					newTriangle[i][j] = Integer.parseInt(inputLine.nextToken());
			}
			train.setTriangle(newTriangle);
			resultString.append(train.computeMaxSum(0, 0)+"\n");
		}
		System.out.println(resultString);
	}
}
