import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author ambika_b
 *
 */
public class CielRcpt {

	public static int menuPrice[] = {1,2,4,8,16,32,64,128,256,512,1024,2048};
	
	public static int getMenuCnt(int price) {
		int largest = 0;
		for(int i = 0; i < menuPrice.length; i++)
			largest = menuPrice[i] > price ? largest : i;
		int remainder = price % menuPrice[largest];
		if ( remainder == 0) return price / menuPrice[largest];
		else return ( (price - remainder) / menuPrice[largest] + getMenuCnt(remainder));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(bReader.readLine());
		StringBuffer result = new StringBuffer();
		while(testCount-- > 0) 
			result.append(getMenuCnt(Integer.parseInt(bReader.readLine())) + "\n");
		System.out.println(result);
	}
}
