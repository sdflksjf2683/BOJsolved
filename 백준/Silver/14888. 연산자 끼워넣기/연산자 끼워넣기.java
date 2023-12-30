import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,max,min;
	static int[] nums, operator;
	
	static void calc(int res, int idx) {
		
		if(idx==N) {
			if(res>max) max = res;
			if(res<min) min = res;
			return;
		}
		
		
		for(int o=0;o<4;o++) {
			if(operator[o]==0) continue;
			
			operator[o]--;
			
			if(o==0) calc(res+nums[idx], idx+1);
			else if(o==1) calc(res-nums[idx], idx+1);
			else if(o==2) calc(res*nums[idx], idx+1);
			else calc(res/nums[idx], idx+1);
			
			operator[o]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			operator[i] = Integer.parseInt(st.nextToken());
		//end input
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		calc(nums[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
}