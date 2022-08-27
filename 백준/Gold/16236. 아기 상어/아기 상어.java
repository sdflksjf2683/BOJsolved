import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, sharksize, eatcnt, time;
	static int[][] map;
	static boolean[][] visit;

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	static Point shark;

	static boolean findfish() {
		Queue<Point> q = new LinkedList<>();
		visit = new boolean[N][N];
		
		q.add(new Point(shark.i, shark.j));
		visit[shark.i][shark.j] = true;
		
		int dis=0;
		while(!q.isEmpty()) {
			PriorityQueue<Point> fish = new PriorityQueue<>();
			for(int i=0,size=q.size();i<size;i++) {
				Point temp = q.poll();
				for(int d=0;d<4;d++) {
					int ni = temp.i+di[d];
					int nj = temp.j+dj[d];
					
					if(ni>=0 && ni<N && nj>=0 && nj<N) {
						if(map[ni][nj]>0 && map[ni][nj]<sharksize)
							fish.add(new Point(ni,nj));
						if((map[ni][nj]==0||map[ni][nj]==sharksize) && !visit[ni][nj]) {
							q.add(new Point(ni,nj));
							visit[ni][nj] = true;
						}
					}
				}
			}
			if(!fish.isEmpty()) {
				Point f = fish.poll();
				eatcnt++;
				map[f.i][f.j] = 0;
				shark.i = f.i;
				shark.j = f.j;
				if(eatcnt == sharksize) {
					sharksize++;
					eatcnt=0;
				}
				time += dis+1;
				return true;
			}
			dis++;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					shark = new Point(i, j);
					sharksize = 2;
					eatcnt = 0;
					map[i][j] = 0;
				} 
			}
		}
		
		while(true) {
			if(!findfish()) break;
		}
		

		System.out.println(time);
	}

	static class Point implements Comparable<Point> {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Point o) {
			if(this.i==o.i)
				return this.j-o.j;
			return this.i-o.i;
		}
	}
}