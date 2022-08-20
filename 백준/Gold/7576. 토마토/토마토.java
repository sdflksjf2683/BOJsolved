import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int M, N, cnt, maxday;
	
	static int[][] map;
	static Queue<int[]> q; //익은 토마토 좌표 저장
	
	static void bfs() {
		while(!q.isEmpty()) {
			for(int i=0;i<q.size();i++) {
				int[] temp = q.poll();
				
				for(int d=0;d<4;d++) {
					int ni = temp[0]+di[d];
					int nj = temp[1]+dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==0) {
						map[ni][nj] = map[temp[0]][temp[1]]+1; //현재 일수+1
						cnt--;
						q.offer(new int[] {ni, nj});
					}
				}
			}
		}
	}
	
	static void findmax() {
		maxday=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				maxday = Math.max(maxday,map[i][j]);
			}
		}
		maxday--;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N][M];
		q = new LinkedList<>();
		cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) q.offer(new int[] {i,j});
				if(map[i][j]==0) cnt++;
			}
		}
		
		if(cnt==0) System.out.println(0);
		else { 
			bfs();
			findmax();
			System.out.println(cnt==0?maxday:-1);
		}
	}
}