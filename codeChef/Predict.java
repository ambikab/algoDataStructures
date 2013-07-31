import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * June Contest 
 * Problem : http://www.codechef.com/JUNE13/problems/PREDICT
 * @author ambika_b
 *
 */
public class Predict {

	static double totalBetAmount = 10000;
	
	public static double getWinningProbability(double probabilityA) {
		double probabilityB = 1- probabilityA;
		return probabilityB > probabilityA ? probabilityB : probabilityA;
	}
	
	public static double getOptimalBet(double probability) {
		return totalBetAmount * probability; 
	}
	
	public static double profitValue(double probability, double optimalBet) {
		return (( (1 - probability) * 2 ) * optimalBet ) + optimalBet;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bReader.readLine());
		StringBuilder sb = new StringBuilder();
		while (testCase-- > 0) {
			double teamProbability = getWinningProbability(Double.valueOf(bReader.readLine()));
			double profitGained = profitValue(teamProbability, getOptimalBet(teamProbability));
			sb.append(profitGained+"\n");
		}
		System.out.println(sb);
	}
}