import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,K;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static boolean[][] map;
	
	static Queue<int[]> q;
	
	static void bfs(int i, int j) {
		q = new LinkedList<int[]>();
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int ti = q.peek()[0];
			int tj = q.poll()[1];
						
			for(int d=0;d<4;d++) {
				int ni = ti+di[d];
				int nj = tj+dj[d];
				
				if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
				
				if(!map[ni][nj]) continue;
				
				map[ni][nj] = false;
				q.add(new int[] {ni,nj});
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new boolean[N][M];
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(st.nextToken());
				int i = Integer.parseInt(st.nextToken());
				map[i][j] = true;
			}
			
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]) {
						map[i][j] = false;
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}