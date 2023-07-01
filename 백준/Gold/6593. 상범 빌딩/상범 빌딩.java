import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int L,R,C;
	static char[][][] map;
	static boolean[][][] visit;
	
	static int[] di = {-1,1,0,0,0,0};
	static int[] dj = {0,0,-1,1,0,0};
	static int[] dl = {0,0,0,0,-1,1};
	
	static String bfs(int i, int j, int l) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(l,i,j,0));
		visit[l][i][j] = true;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			if(map[tmp.l][tmp.i][tmp.j]=='E')
				return "Escaped in "+tmp.cnt+" minute(s).";
			
			for(int d=0;d<6;d++) {
				int ti = tmp.i+di[d];
				int tj = tmp.j+dj[d];
				int tl = tmp.l+dl[d];
				
				if(ti<0 || ti>=R || tj<0 || tj>=C || tl<0 || tl>=L || visit[tl][ti][tj]) continue;
				
				if(map[tl][ti][tj]=='#') continue;
				
				q.add(new Node(tl,ti,tj,tmp.cnt+1));
				visit[tl][ti][tj] = true;
			}
		}
		
		return "Trapped!";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L==0 && R==0 && C==0) break;
			
			map = new char[L][R][C];
			visit = new boolean[L][R][C];
			int i=0,j=0,floor=0;
			
			for(int l=0;l<L;l++) {
				for(int r=0;r<R;r++) {
					map[l][r] = br.readLine().toCharArray();
					for(int c=0;c<C;c++) {
						if(map[l][r][c]=='S') {
							i=r;
							j=c;
							floor=l;
						}
					}
				}
				br.readLine();
			}
			//end input
			
			sb.append(bfs(i,j,floor));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static class Node {
		int l,i,j,cnt;

		public Node(int l, int i, int j, int cnt) {
			this.l = l;
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
}