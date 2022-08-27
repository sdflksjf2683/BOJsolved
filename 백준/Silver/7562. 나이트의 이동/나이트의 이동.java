import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] di = {-2,-1,1,2,2,1,-1,-2};
	static int[] dj = {1,2,2,1,-1,-2,-2,-1};
	
	static int l;
	static int cnt;
	
	static int[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			l = sc.nextInt();
			Point start = new Point(sc.nextInt(), sc.nextInt());
			Point goal = new Point(sc.nextInt(), sc.nextInt());
			
			visit = new int[l][l];
			bfs(start, goal);
			
			System.out.println(cnt);
		}
	}
	
	static void bfs(Point p1, Point p2) {
		Queue<Point> q = new LinkedList<>();
		q.offer(p1);
		visit[p1.i][p1.j] = 1;
		
		cnt = 0;
		while(!q.isEmpty()) {
			
			for(int i=0, size = q.size();i<size;i++) {
				Point temp = q.poll();
				
				if(temp.i==p2.i && temp.j==p2.j) return;
				
				for(int d=0;d<8;d++) {
					int ni = temp.i+di[d];
					int nj = temp.j+dj[d];
					
					if(ni>=0 && nj>=0 && ni<l && nj<l && visit[ni][nj]==0) {
						q.offer(new Point(ni, nj));
						visit[ni][nj]=1;
					}
				}
			}
			cnt++;
		}
		
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
