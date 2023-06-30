import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] computers = new int[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		
		for(int k=0;k<K;k++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			computers[a][b] = computers[b][a] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visit[1] = true;
		int cnt=0;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int i=1;i<=N;i++) {
				if(computers[tmp][i]==1 && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}