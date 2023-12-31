import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		long[][] dp = new long[N][21]; //0~20까지 단계별로 저장
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		} //end input
		
		dp[0][nums[0]] = 1;
		
		for(int i=1;i<N-1;i++) {
			for(int j=0;j<21;j++) {
				if(dp[i-1][j]==0) continue;
				
				int tmp = j+nums[i];
				if(tmp>=0 && tmp<=20) 
					dp[i][tmp] += dp[i-1][j];
				
				tmp = j-nums[i];
				if(tmp>=0 && tmp<=20) 
					dp[i][tmp] += dp[i-1][j];
			}
		}
		
		System.out.println(dp[N-2][nums[N-1]]);
	}
}