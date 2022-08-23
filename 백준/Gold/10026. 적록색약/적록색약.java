import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] map;
	static int[][] visit;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int nocnt, yescnt;
	
	static void nobfs(int i, int j, char c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		if(c=='B') visit[i][j] = 2;
		else visit[i][j] = 1;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = temp[0]+di[d];
				int nj = temp[1]+dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<N && visit[ni][nj]==0 && map[ni][nj]==c) {
					q.offer(new int[] {ni, nj});
					if(c=='B') visit[ni][nj] = 2;
					else visit[ni][nj] = 1;
				}
			}
		}

	}
	
	static void yesbfs(int i, int j, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		visit[i][j] = 0;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = temp[0]+di[d];
				int nj = temp[1]+dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<N && visit[ni][nj]==c) {
					q.offer(new int[] {ni, nj});
					visit[ni][nj] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new int[N][N];
		
		for(int i=0;i<N;i++)
			map[i] = br.readLine().toCharArray();
		
		//적록색약 아닌 사람이 보는 구역
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]==0) {
					nobfs(i,j,map[i][j]);
					nocnt++;
				}
			}
		}
		//적록색약인 사람이 보는 구
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]!=0) {
					yesbfs(i, j, visit[i][j]);
					yescnt++;
				}
			}
		}
		System.out.println(nocnt+" "+yescnt);
	}
}