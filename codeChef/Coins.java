import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PROBLEM : http://www.codechef.com/problems/COINS/
 * @author ambika_b
 *
 */
public class Coins {

	int coinValue;

	int[] memoizedValue = new int[10000000];

	public void setCoinValue(int coinValue) {
		this.coinValue = coinValue;
	}

	/**
	 * recursively computes maximum exchange rate for given coin values
	 * @param value
	 * @return
	 */
	public int maximumExchangeValue(int value) {
		if (value == 0) 
			return 0;
		if (value == 1)
			return 1;
		if(value < memoizedValue.length && memoizedValue[value] != 0)
			return memoizedValue[value];
		int half = maximumExchangeValue(value / 2);
		int oneThird = maximumExchangeValue(value / 3);
		int quarter = maximumExchangeValue(value / 4);
		int result;
		if( half + oneThird + quarter  >= value ) 
			result =  half + oneThird + quarter;
		else  
			result = value; 
		if (value < memoizedValue.length)
			memoizedValue[value] = result;
		return result;
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Coins deposit = new Coins();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		while (true) {
			try {
				String coinValue = bReader.readLine();
				deposit.setCoinValue(Integer.parseInt(coinValue));
				resultString.append(deposit.maximumExchangeValue(deposit.coinValue)+"\n");
			} catch(NumberFormatException nfe) {
				System.out.println(resultString);
				System.exit(0);
			}
		}

	}

}
