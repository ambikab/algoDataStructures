import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

class TimeSlot implements Comparable<TimeSlot>  {
	int startTime;
	int endTime;
	
	TimeSlot(int st, int et) {
		startTime = st;
		endTime = et;
	}

	@Override
	public int compareTo(TimeSlot second) {
		// TODO Auto-generated method stub
		return this.endTime - second.endTime;
	}
	
	@Override
	public String toString() {
		return "Start Time : " + startTime + " End Time : " + endTime;
	}
}

public class BonAppetit {
	
	public static int solve(Vector<TimeSlot> [] compartments) {
		int n = compartments.length;
		int answer = 0;
		for(int i = 0; i < n; i++) {
			Collections.sort(compartments[i]);
			int lastEndTime = -1;
			for(int j = 0; j < compartments[i].size(); j++) {
				// choose the current open set and remember the end time
				
				TimeSlot slot = compartments[i].get(j);
				
				if(slot.startTime >= lastEndTime) {
					answer++;
					lastEndTime = slot.endTime;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		while(n-- > 0) {
			StringTokenizer sz = new StringTokenizer(br.readLine(), " ");
			int numCust = Integer.parseInt(sz.nextToken());
			int numComp = Integer.parseInt(sz.nextToken());
			
			Vector<TimeSlot> compartments [] = (Vector<TimeSlot>[]) new Vector[numComp];
			for(int i = 0; i < numComp; i++) {
				compartments[i] = new Vector<TimeSlot>();
			}
			
			
			while(numCust-- > 0) {
				sz = new StringTokenizer(br.readLine(), " ");
				int st = Integer.parseInt(sz.nextToken());
				int et = Integer.parseInt(sz.nextToken());
				int comp = Integer.parseInt(sz.nextToken());
				
				TimeSlot slot = new TimeSlot(st, et);
				
				compartments[comp - 1].add(slot);
				
			}
			
			result.append(solve(compartments)+"\n");
		}
		System.out.println(result);
	}

}