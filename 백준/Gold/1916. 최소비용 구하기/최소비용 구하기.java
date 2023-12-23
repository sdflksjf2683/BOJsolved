import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	
	static int[] dist;
	
	static List<Point>[] list;
	
	static void dijkstra(int start) {
		boolean[] visit = new boolean[N+1];
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		q.offer(new Point(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			if(visit[tmp.to]) continue;
			
			visit[tmp.to] = true;
			
			for(Point next: list[tmp.to]) {
				if(dist[next.to] >= dist[tmp.to]+next.w) {
					dist[next.to] = dist[tmp.to]+next.w;
					q.offer(new Point(next.to, dist[next.to]));
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Point(to, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(dist[goal]);
	}
	
	static class Point implements Comparable<Point> {
		int to, w;
		
		public Point(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.w-o.w;
		}
	}
}