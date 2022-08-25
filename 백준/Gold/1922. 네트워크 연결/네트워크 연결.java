import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] parent;
	static Edge[] list;
	
	static int find(int n) {
		if(parent[n] == n) return n;
		
		return parent[n] = find(parent[n]);
	}
	
	static boolean union(int x, int y) {
		int X = find(x);
		int Y = find(y);
		
		if(X==Y) return false;
		
		parent[Y] = X;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new Edge[M];
		parent = new int[N+1];
		
		for(int i=0;i<N;i++) {
			parent[i] = i;
		}
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			list[m] = new Edge(Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken()), 
								Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(list);
		
		int ans = 0;
		int cnt = 0;
		for(Edge e: list) {
			if(union(e.from, e.to)) {
				ans += e.weight;
				cnt++;
			}
			if(cnt==N-1)
				break;
		}
		
		System.out.println(ans);
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
	}
}