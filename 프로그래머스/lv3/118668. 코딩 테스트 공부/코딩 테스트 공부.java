class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int agoal=Integer.MIN_VALUE, cgoal=Integer.MIN_VALUE;
        
        for(int[] p: problems) {
            agoal = Math.max(agoal, p[0]);
            cgoal = Math.max(cgoal, p[1]);
        }

        if(alp>=agoal && cop>=cgoal)
            return 0;
        
        alp = alp>=agoal?agoal:alp;
        cop = cop>=cgoal?cgoal:cop;
        
        int[][] dp = new int[agoal+2][cgoal+2];
        for(int i=alp;i<=agoal;i++) {
            for(int j=cop;j<=cgoal;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp;i<=agoal;i++) {
            for(int j=cop;j<=cgoal;j++) {
                
                //공부를 해서 늘리기
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                //문제 풀어서 늘리기
                for(int[] p: problems) {
                    if(i<p[0] || j<p[1]) continue;
                    
                    int ni = (i+p[2])>agoal?agoal:(i+p[2]);
                    int nj = (j+p[3])>cgoal?cgoal:(j+p[3]);
                    
                    dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j]+p[4]);
                }
            }
        }
        
        return dp[agoal][cgoal];
    }
}