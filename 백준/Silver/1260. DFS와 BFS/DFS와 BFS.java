import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M, V;
	static int[][] map;
	static boolean[] visit;
	
	static void dfs(int cur) {
		visit[cur] = true;
		System.out.print(cur+" ");
		
		for(int i=1;i<=N;i++) {
			if(!visit[i] && map[cur][i]==1) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int cur) {
		visit = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		
		visit[cur] = true;
		q.offer(cur);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp+" ");
			
			for(int i=1;i<=N;i++) {
				if(!visit[i] && map[temp][i]==1) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<M;i++) { 
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			map[end][start] = map[start][end] = 1; 
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
	}
}
