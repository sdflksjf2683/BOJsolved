import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, teamW, teamB;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static char[][] map;
	static boolean[][] visit;
	
	static int bfs(Point p, char c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(p);

		int cnt=1; //뭉친 병사의 수
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni<0 || ni>=M || nj<0 || nj>=N) continue; //범위를 벗어난 경우 
				
				if(visit[ni][nj] || map[ni][nj]!=c) continue; //이미 방문했거나 같은 편이 아닌 경우 
				
				visit[ni][nj] = true;
				cnt++;
				q.offer(new Point(ni,nj));
			}
		}
		
		return cnt*cnt;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visit = new boolean[M][N];
		
		
		for(int m=0;m<M;m++) {
			map[m] = br.readLine().toCharArray();
		}
		
		teamW = 0;
		teamB = 0;
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]) continue; //이미 센 병사일 경우
				
				visit[i][j] = true; //방문체크 해주고 
				int temp = bfs(new Point(i,j), map[i][j]); //bfs 탐색 
				
				if(map[i][j]=='W') teamW += temp;
				else teamB += temp;
			}
		}
		
		System.out.println(teamW+" "+teamB);
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}