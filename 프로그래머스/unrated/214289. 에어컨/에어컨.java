class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        int N = onboard.length;
        int[][] dp = new int[51][N+1];
		temperature +=10; t1 +=10; t2+=10;
		
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<51;j++) {
				dp[j][i] = Integer.MAX_VALUE - Math.max(a, b);
				
				if(onboard[i]==1 &&(j<t1 || j>t2)) continue;
				
				if(j==temperature) dp[j][i] = Math.min(dp[j][i], dp[j][i+1]);
				else if(j>0 && j>temperature) dp[j][i] = Math.min(dp[j][i], dp[j-1][i+1]);
				else if(j<50 && j<temperature) dp[j][i] = Math.min(dp[j][i], dp[j+1][i+1]);
				
				if(j<50) dp[j][i] = Math.min(dp[j][i], dp[j+1][i+1]+a);
				if(j>0) dp[j][i] = Math.min(dp[j][i], dp[j-1][i+1]+a);
				dp[j][i] = Math.min(dp[j][i], dp[j][i+1]+b);
				
			}
		}
		
		return dp[temperature][0];
    }
}