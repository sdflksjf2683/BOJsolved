import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, ans;
	static boolean flag;

	static int[] parent;
	static int[][] map;
	static ArrayList<Bridge> list;

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };
	
	static int find(int x) {
		if(parent[x]<0) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int i, int j) {
		int iP = find(i);
		int jP = find(j);
		
		if(iP != jP) {
			parent[jP] = iP;
			return true;
		}
		return false;
	}
	
	static int findPath(int cnt) {
		int sum = 0;
		for(Bridge b: list) {
			if(union(b.start, b.end)) {
				ans += b.w;
				sum++;
			}
			if(sum==cnt-1) break;
		}
		return sum;
	}
	
	static void dfs(int i, int j, int landnum, int dir, int dist) {
		if(i<0 || i>=N || j<0 || j>=M) {
			flag = true;
			return;
		}
		
		if(map[i][j]>0) {
			if(map[i][j]!=landnum && dist-1>=2)
				list.add(new Bridge(landnum,map[i][j], dist-1));
			flag = true;
			return;
		}
		
		dfs(i+di[dir],j+dj[dir],landnum,dir,dist+1);
		
		if(flag) return;
	}

	static void makeBridge(int i, int j, int landnum) {
		
		for (int d = 0; d < 4; d++) {
			flag = false;
			
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
			if(map[ni][nj]==0) {
				dfs(ni,nj,landnum,d,1); //바다면 다리 놓아보기
			}
		}
		
	}
	
	static void findLand(Land p, int cnt) {
		Queue<Land> q = new LinkedList<>();
		q.offer(p);
		map[p.i][p.j] = cnt;

		while (!q.isEmpty()) {
			Land temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = temp.i + di[d];
				int nj = temp.j + dj[d];

				if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
				if (map[ni][nj] != -1) continue;

				map[ni][nj] = cnt;
				q.offer(new Land(ni, nj));
			}
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt() * (-1);
			}
		} // end input

		// 섬에 번호 붙여주기
		int landCnt = 1; // 섬 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					findLand(new Land(i, j), landCnt);
					landCnt++;
				}
			}
		}

		list = new ArrayList<Bridge>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) // 땅이면 다리 놓기
					makeBridge(i, j,map[i][j]);
			}
		}
		
		Collections.sort(list);
		parent = new int[landCnt];
		ans = 0;
		for(int i=1;i<landCnt;i++) {
			parent[i] = -1;
		}
		int result = findPath(landCnt-1);
		
		System.out.println(result<landCnt-2?-1:ans);

	}

	static class Land {
		int i, j;

		public Land(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

	static class Bridge implements Comparable<Bridge> { // 다리 클래스
		int start, end, w;

		public Bridge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Bridge b) {
			return this.w-b.w;
		}

	}
}