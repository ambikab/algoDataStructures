import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem code http://www.codechef.com/OCT13/problems/HELPLIRA
 * @author ambika_b
 *
 */
public class HelpLira {

	static Point point1, point2, point3;

	static {
		point1 = new HelpLira.Point();
		point2 = new HelpLira.Point();
		point3 = new HelpLira.Point();
	}
	
	static class Point {
		public int x; 
		public int y;
	}

	public static int calculateArea(Point point1,Point point2,Point point3 ) {
		int term1 = point1.x * ( point2.y - point3.y);
		int term2 = point2.x * ( point3.y - point1.y);
		int term3 = point3.x * ( point1.y - point2.y);
		return Math.abs((term1 + term2 + term3 ) / 2);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bReader.readLine());
		int areas[] = new int[testCase];
		int min = 0, max = 0;
		for (int i = 0; i < testCase; i++) {
			StringTokenizer inputString = new StringTokenizer(bReader.readLine());
			point1.x = Integer.parseInt(inputString.nextToken());
			point1.y = Integer.parseInt(inputString.nextToken());
			point2.x = Integer.parseInt(inputString.nextToken());
			point2.y = Integer.parseInt(inputString.nextToken());
			point3.x = Integer.parseInt(inputString.nextToken());
			point3.y = Integer.parseInt(inputString.nextToken());
		    areas[i] = calculateArea(point1, point2, point3);
		    // calculate min
		    min = areas[min] < areas[i] ? min : i;
		    //calculate max
		    max = areas[i] < areas[max] ? max : i;
		}
		min++;
		max++;
		System.out.println(min + " " + max);
	}

}
