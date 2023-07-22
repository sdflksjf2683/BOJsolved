import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	static int[] parent;
	
	static List<Node> nlist;
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x!=y)
			parent[x] = y;
	}
	
	static int find(int x) {
		if(x==parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nlist = new LinkedList<>();
		parent = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nlist.add(new Node(s,e,w));
		}
		
		for(int i=0;i<=N;i++)
			parent[i] = i;
		
		nlist.sort(null);
		
		int ans = 0;
		int last = Integer.MIN_VALUE;
		for(Node n: nlist) {
			if(find(n.s) != find(n.e)) {
				ans += n.w;
				union(n.s, n.e);
				
				last = n.w;
			}
		}
		System.out.println(ans-last);
		
	}
	
	static class Node implements Comparable<Node>{
		int s, e, w;
		
		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.w-n.w;
		}
	}
}