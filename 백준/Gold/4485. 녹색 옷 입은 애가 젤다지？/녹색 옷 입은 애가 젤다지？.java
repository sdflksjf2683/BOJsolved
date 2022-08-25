import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map, D;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0,map[0][0]));
		D[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			for(int d=0;d<4;d++) {
				int ni = temp.i+di[d];
				int nj = temp.j+dj[d];
				
				if(ni>=0 && ni<N && nj>=0 && nj<N) {
					if(D[ni][nj] > D[temp.i][temp.j] + map[ni][nj]) {
						D[ni][nj] = D[temp.i][temp.j] + map[ni][nj];
						pq.offer(new Node(ni, nj, D[ni][nj]));
					}
				}
			}
		}
		
		return D[N-1][N-1];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N==0) break;
			
			map = new int[N][N];
			D = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				
				Arrays.fill(D[i], Integer.MAX_VALUE);
			}
			sb.append("Problem "+t+": "+dijkstra()).append("\n");
			t++;
		}
		
		System.out.println(sb.toString());
	}
	
	static class Node implements Comparable<Node>{
		int i, j, rupee;

		public Node(int i, int j, int rupee) {
			this.i = i;
			this.j = j;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Node o) {
			return this.rupee - o.rupee;
		}
		
		
	}
}