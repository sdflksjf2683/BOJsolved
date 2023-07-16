import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N, result;
	
	static char[] after;
	
	static char[][] before;
	
	static void bulb(int tmp, int idx, int cnt) {
		if(idx==N) {
			if(before[tmp][idx-1]==after[idx-1])
				result = Math.min(result, cnt);
		} else {
			if(before[tmp][idx-1]!=after[idx-1]) {
				turnSwitch(tmp, idx);
				bulb(tmp, idx+1, cnt+1);
			} else {
				bulb(tmp, idx+1, cnt);
			}
		}
	}
	
	static void turnSwitch(int cur, int idx) {
		for(int i=idx-1;i<idx+2;i++) {
			if(-1<i && i<N)
				before[cur][i] = before[cur][i]=='1'?'0':'1';
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		before = new char[2][N];
		before[0] = br.readLine().toCharArray();
		after = br.readLine().toCharArray();
		
		for(int i=0;i<N;i++)
			before[1][i] = before[0][i];
		
		result = Integer.MAX_VALUE;
		
		bulb(0,1,0);
		
		turnSwitch(1,0);
		
		bulb(1,1,1);
		
		result = result==Integer.MAX_VALUE?-1:result;
		System.out.println(result);
	}
}