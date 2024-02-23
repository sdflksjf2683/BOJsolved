import java.util.*;

class Solution {
    
    static int[][] map;
    
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    
    static int bfs(int si, int sj, int ei, int ej) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(si, sj, 1));
        
        boolean[][] visit = new boolean[101][101];
        visit[si][sj] = true;
        
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            int ti = tmp.i;
            int tj = tmp.j;
            int tc = tmp.cnt;
            
            if(ti==ei && tj==ej) { //도착
                return tc/2;
            }
            
            for(int d=0;d<4;d++) {
                int ni = ti+di[d];
                int nj = tj+dj[d];
                
                if(ni<1 || ni>100 || nj<1 || nj>100) continue;
                if(visit[ni][nj] || map[ni][nj]!=1) continue;
                
                q.offer(new Point(ni,nj,tc+1));
                visit[ni][nj] = true;
            }
        }
        return -1;
    }
    
    static void init(int[][] rectangle) {
        for(int[] r: rectangle) {
            int si = r[1]*2;
            int sj = r[0]*2;
            int ei = r[3]*2;
            int ej = r[2]*2;
            
            for(int i=si;i<=ei;i++) {
                for(int j=sj;j<=ej;j++) {
                    if(i==si || i==ei || j==sj || j==ej) { //테두리: 1
                        if(map[i][j]<0) continue; //테두리가 다른 사각형 내부에 있는 경우
                        
                        map[i][j] = 1;
                    } else { //테두리 아님: -1
                        map[i][j] = -1;
                    }
                }
            }
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[101][101];
        init(rectangle); //맵에 테두리 표시 + 좌표 확장(겹치는 부분 처리)

        return bfs(characterY*2, characterX*2, itemY*2, itemX*2);
    }
    
    static class Point {
        int i,j,cnt;
        
        public Point(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}