import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	static int[][] map, dp;
	
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	
	static int dfs(int ti, int tj) {
		
		if(dp[ti][tj]>0) { //이미 방문한 적이 있다면 그 값을 리턴
			return dp[ti][tj];
		}
		
		dp[ti][tj] = 1;
		
		for(int d=0;d<4;d++) {
			int ni = ti+di[d];
			int nj = tj+dj[d];
			
			if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
			if(map[ni][nj]<=map[ti][tj]) continue;
			
			dp[ti][tj] = Math.max(dp[ti][tj], dfs(ni,nj)+1);
		}
		
		return dp[ti][tj];
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //end input
		
		dp = new int[N][N];
		
		int ans = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ans = Math.max(ans,dfs(i,j));
			}
		}
		
		System.out.println(ans);
		
	}
}