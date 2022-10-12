import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min;
	
	static int[] nums;
	static boolean[] visit;
	
	static void findSet(int idx, int sum) {
		if(idx==N) 
			visit[sum] = true;

		else {
			findSet(idx+1, sum+nums[idx]);
			findSet(idx+1, sum);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		visit = new boolean[20*100000+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		findSet(0,0);
		
		min = 1;
		while(visit[min]) {
			min++;
		}
		System.out.println(min);
	}
}