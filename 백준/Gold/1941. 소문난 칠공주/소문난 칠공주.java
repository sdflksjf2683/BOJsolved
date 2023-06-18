import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static char[][] map;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static int[] select;
	static int ans;
	static boolean[] visit;
	
	static boolean check() {
		int cnt = 1;
		boolean[] visited = new boolean[25];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(select[0]);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			visited[temp] = true;
			
			for(int d=0;d<4;d++) {
				int ti = (temp/5) + di[d];
				int tj = (temp%5) + dj[d];
				
				if(ti<0 || ti>=5 || tj<0 || tj>=5) continue;
				
				if(visited[ti*5+tj]) continue;
				
				if(!visit[ti*5+tj]) continue;
				
				cnt++;
				visited[ti*5+tj] = true;
				q.add(ti*5+tj);
			}
		}
		
		if(cnt==7) return true;
		
		return false;
	}
	
	static void comb(int idx, int cnt, int scnt) {
		if(cnt==7) {
			if(scnt>=4) {
				if(check())
					ans++;
				return;
			}
			return;
		}
		
		for(int i=idx;i<25;i++) {
			visit[i] = true;
			select[cnt] = i;
			
			if(map[i/5][i%5]=='S')
				comb(i+1, cnt+1, scnt+1);
			else
				comb(i+1, cnt+1, scnt);
			
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visit = new boolean[25];
		select = new int[7];
		ans = 0;
		
		comb(0,0,0);
		
		System.out.println(ans);
	}
}