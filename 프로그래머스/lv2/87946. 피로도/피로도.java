class Solution {
    public int answer = 0;
    public boolean[] visit;
    
    public void dfs(int cnt, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(cnt+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }

        answer = Math.max(answer, cnt);
    }

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }
}