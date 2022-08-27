
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char[][] map;
	static ArrayList<Point> waterlist;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static void water() {
		int size = waterlist.size();
		for(int i=0;i<size;i++) {
			Point temp = waterlist.get(i);
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj]=='.') {
					map[ni][nj] = '*';
					waterlist.add(new Point(ni,nj));
				}
			}
		}
	}
	
	static int bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		int cnt = 0;
		
		while(!q.isEmpty()) {
			water(); //물 불어남
			int ok = 0;
			for(int i=0, size=q.size();i<size;i++) {
				Point temp = q.poll();
				
				for(int d=0;d<4;d++) {
					int ni = temp.i+di[d];
					int nj = temp.j+dj[d];
					
					if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj]=='.') {
						q.offer(new Point(ni, nj));
						map[ni][nj] = 'S';
						ok++;
					}
					if(ni == end.i && nj == end.j) {
						cnt++;
						return cnt;
					}
				}
				
			}
			if(ok==0) return -1;
			cnt++;
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int r=0;r<R;r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		Point start = new Point(0,0);
		Point end = new Point(0,0);
		waterlist = new ArrayList<>();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='S')
					start = new Point(i,j);
				if(map[i][j]=='D')
					end = new Point(i,j);
				if(map[i][j]=='*')
					waterlist.add(new Point(i,j));
			}
		}

		int ans = bfs(start, end);
		System.out.println(ans<0?"KAKTUS":ans);
	}
	
	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
