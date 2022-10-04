import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, max, safecnt;
	static int[][] map, copy;
	
	static ArrayList<Point> virus;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int bfs(int cnt) {
		Queue<Point> q = new LinkedList<>();
		
		for(Point p: virus)
			q.offer(p);
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni<0 || nj<0 || ni>=N || nj>=M) continue;
				if(copy[ni][nj]!=0) continue;
				
				copy[ni][nj] = 2;
				cnt--;
				q.offer(new Point(ni,nj));
			}
		}
		
		return cnt;
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==3) {
			copy = deepcopy(map);
			int safezone = bfs(safecnt);
			max = max<safezone?safezone:max;
			return;
		}
		
		for (int c=idx;c<N*M;c++) {
            int i = c/M;
            int j = c%M;

            if (map[i][j]==0) {
                map[i][j] = 1;
                comb(idx+1,cnt+1);
                map[i][j] = 0;
            }
        }
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new ArrayList<>();
        safecnt=0;
        
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==2)
                    virus.add(new Point(i, j));
                if(map[i][j]==0)
                	safecnt++;
            }
        }
        safecnt-=3; //벽 세개 세울거라서
        comb(0,0);
        System.out.println(max);
	}
	
	static int[][] deepcopy(int[][] map) {
		int[][] copy = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}