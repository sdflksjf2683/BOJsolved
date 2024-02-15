import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	
	static int[] dist;
	
	static ArrayList<Node>[] list;
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
		
		dist[1] = 0;
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			if(visit[tmp.to]) continue;
			
			visit[tmp.to] = true;
			
			for(Node next:list[tmp.to]) {
				if(dist[next.to]>dist[tmp.to]+next.w) {
					dist[next.to] = dist[tmp.to]+next.w;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		} 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to, w));
			list[to].add(new Node(from, w));
		} //end input
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra();
		System.out.println(dist[N]);
	}
	
	static class Node implements Comparable<Node> {
		int w, to;
		
		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
}