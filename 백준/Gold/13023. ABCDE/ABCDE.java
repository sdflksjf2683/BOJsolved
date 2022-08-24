import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer>[] friends;
	static int N, M;
	static boolean[] visit;
	static boolean check;
	
	static void dfs(int cur, int cnt) {
		if(cnt==5) {
			check = true;
			return;
		}
		
		visit[cur] = true;
		for(int f: friends[cur]) {
			if(!visit[f])
				dfs(f, cnt+1);
		}
		visit[cur] = false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		friends = new ArrayList[N];
		
		for(int n=0;n<N;n++) {
			friends[n] = new ArrayList<>();
		}
		
		for(int m=0;m<M;m++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			friends[from].add(to);
			friends[to].add(from);
		}
		
		for(int n=0;n<N;n++) {
			visit = new boolean[N];
			dfs(n, 1);
			if(check) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
}