import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem: http://www.codechef.com/problems/HOTEL
 * @author ambika_b
 *
 */
public class Hotel {
	
	public static int getMaxCount(Checkin[] slots) {
		//TODO: OVERRIDE THE COMPARATOR.
		Arrays.sort(slots);
		int maxCnt = 0, curMax = 0;
		for ( int i = 0; i < slots.length; i++) {
			if (slots[i].type == 'A') curMax++;
			else
				curMax--;
			maxCnt = maxCnt >= curMax ? maxCnt : curMax;
		}
		return maxCnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bReader.readLine());
		StringBuffer result = new StringBuffer("");
		while(testCase-- > 0) {
			int guestCnt = Integer.parseInt(bReader.readLine());
			Checkin[] slots = new Checkin[guestCnt * 2];
			//Read the arrival and departure times of the guests.
			StringTokenizer arrival = new StringTokenizer(bReader.readLine());
			StringTokenizer departure = new StringTokenizer(bReader.readLine());
			for (int i = 0; arrival.hasMoreTokens(); i++)
				slots[i] = new Checkin(Integer.parseInt(arrival.nextToken()), 'A');
			for (int i = guestCnt; departure.hasMoreTokens(); i++)
				slots[i] = new Checkin(Integer.parseInt(departure.nextToken()), 'D');
			result.append(getMaxCount(slots) + "\n");
		}
		System.out.println(result);
	}
}

class Checkin implements Comparable<Checkin> {
	public int time;
	public char type;

	public Checkin() {	}
	
	public Checkin(int time, char type) { 
		this.time = time;
		this.type = type;
	}

	@Override
	public int compareTo(Checkin slot) {
		if (this.time > slot.time) return new Integer(this.time).compareTo(slot.time);
		else if (this.time < slot.time) return new Integer(this.time).compareTo(slot.time);
		else return (new Character (slot.type).compareTo(this.type));
	}
}