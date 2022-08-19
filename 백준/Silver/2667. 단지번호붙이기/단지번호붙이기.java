import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N, ans, cnt;
	static char[][] map;
	static boolean[][] visit;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static ArrayList<Integer> house;
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = temp[0]+di[d];
				int nj = temp[1]+dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]=='1' && !visit[ni][nj]) {
					cnt++;
					q.offer(new int[] {ni, nj});
					visit[ni][nj] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		ans = 0;
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		house = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='1'&&!visit[i][j]) {
					cnt=1;//단지 내 아파트 수
					bfs(i, j);
					ans++;//단지 수
					house.add(cnt);
				}
			}
		}
		Collections.sort(house);
		
		System.out.println(ans);
		for(int i: house)
			System.out.println(i);
	}
}