import java.util.*;

class Solution {
    
    static int N,M;
    
    static char[][] map;
    static boolean[][] visit;
    
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    
    static int bfs(int i, int j, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        visit[i][j] = true;
        q.offer(new int[] {i,j});
        
        while(!q.isEmpty()) {
            int ti = q.peek()[0];
            int tj = q.poll()[1];
            
            for(int d=0;d<4;d++) {
                int ni = ti+di[d];
                int nj = tj+dj[d];
                
                if(ni<0 || nj<0 || ni>=N || nj>=M) continue;
                
                if(map[ni][nj]=='X' || visit[ni][nj]) continue;
                
                visit[ni][nj] = true;
                q.offer(new int[] {ni,nj});
                cnt += map[ni][nj]-'0';
            }
        }
        
        return cnt;
    }
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        N = maps.length;
        M = maps[0].length();
        
        visit = new boolean[N][M];
        map = new char[N][M];
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j]!='X' && !visit[i][j]) {
                    int tmp = bfs(i,j,map[i][j]-'0');
                    answer.add(tmp);
                }
            }
        }
        
        Collections.sort(answer);
        
        if(answer.size()==0)
            answer.add(-1);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}