import java.util.*;

class Solution {
    
    static int answer;
    
    static ArrayList<Integer>[] list;
    
    static void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        
        q.offer(new int[] {1,0});
        visit[1] = true;
        int maxD = 0;
        
        while(!q.isEmpty()) {
            int v = q.peek()[0];
            int d = q.poll()[1];
            
            if(maxD==d) {
                answer++;
            } else if(maxD<d) {
                maxD = d;
                answer = 1;
            }
            
            for(int i: list[v]) {
                if(visit[i]) continue;
                
                q.offer(new int[] {i, d+1});
                visit[i] = true;
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        answer = 0;
        
        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] e: edge) {
            int from = e[0];
            int to = e[1];
            
            list[from].add(to);
            list[to].add(from);
        }
        
        bfs(n);
        
        return answer;
    }
}