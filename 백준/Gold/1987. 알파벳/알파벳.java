import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, maxCnt;
	static char[][] map;
	static boolean[] visit;
	
	//상하좌우
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static void dfs(int i, int j, int cnt) {
		
		if(visit[map[i][j]-'A']) {
			maxCnt = Math.max(cnt, maxCnt);
			return;
		}
		visit[map[i][j]-'A'] = true;
		
		for(int d=0;d<4;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni>=0 && nj>=0 && ni<R && nj<C) 
				dfs(ni, nj, cnt+1);

		}
		
		visit[map[i][j]-'A'] = false;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		maxCnt = 1;
		visit = new boolean[26];
		dfs(0,0,0);
		System.out.println(maxCnt);
	}
}