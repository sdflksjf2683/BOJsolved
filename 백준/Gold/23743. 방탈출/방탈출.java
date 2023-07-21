import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	
	static int[] parent;
	
	static List<Node> nlist;
	
	static int find(int tmp) {
		if(tmp==parent[tmp])
			return tmp;
		return parent[tmp] = find(parent[tmp]);
	}
	
	static boolean union(int x, int y) {
		int xP = find(x);
		int yP = find(y);
		
		if(xP==yP) //서로 같은 부모면 트리를 합칠 필요가 없음
			return false;
		
		//부모가 다를 경우에는 트리를 합친다. 
		parent[xP] = yP;
		return true;
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
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int w = Integer.parseInt(st.nextToken());
			nlist.add(new Node(0,i,w));
		}
		nlist.sort(null);
		
		for(int i=0;i<=N;i++) 
			parent[i] = i;
		
		int time = 0;
		for(Node n: nlist) {
			if(union(n.s, n.e)) {
				time += n.w;
			}
		}
		System.out.println(time);
	}
	
	static class Node implements Comparable<Node> {
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