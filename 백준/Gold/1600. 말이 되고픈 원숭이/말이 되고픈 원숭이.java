

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	 
	static int K,W,H, min=Integer.MAX_VALUE;
	
	static int[][] map;

	static int[] di = {0,0,-1,1};
	static int[] dj = {1,-1,0,0};
	
	//12시 방향부터 시계방향
	static int[] hdi = {-2,-1,1,2,2,1,-1,-2};
	static int[] hdj = {1,2,2,1,-1,-2,-2,-1};
	
	static void bfs() {
		boolean[][][] visit = new boolean[H][W][K+1];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0,K,0));
		visit[0][0][K] = true;
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			//System.out.println(temp.i+" "+temp.j+" "+temp.k+" "+temp.cnt);
			
			if(temp.i==H-1 && temp.j==W-1) {
				min = min>temp.cnt?temp.cnt:min;
				return;
			}
			
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni<0 || nj<0 || ni>=H || nj>=W) continue;
				if(map[ni][nj]==1) continue;
				if(visit[ni][nj][temp.k]) continue;
				
				visit[ni][nj][temp.k] = true;
				q.offer(new Point(ni,nj,temp.k,temp.cnt+1));
			}
			
			if(temp.k>0) {
				for(int d=0;d<8;d++) {
					int ni = temp.i+hdi[d];
					int nj = temp.j+hdj[d];
					
					if(ni<0 || nj<0 || ni>=H || nj>=W) continue;
					if(map[ni][nj]==1) continue;
					if(visit[ni][nj][temp.k-1]) continue;
					
					visit[ni][nj][temp.k-1] = true;
					q.offer(new Point(ni,nj,temp.k-1,temp.cnt+1));
				}
			}

		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for(int h=0;h<H;h++) {
			st = new StringTokenizer(br.readLine());
			for(int w=0;w<W;w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	static class Point {
		int i,j,k,cnt;

		public Point(int i, int j, int k, int cnt) {
			this.i = i;
			this.j = j;
			this.k = k;
			this.cnt = cnt;
		}
		
	}
}
