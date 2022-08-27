import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	
	static int n, k, time;
	static int[] go = {2,-1,1};
	static boolean[] visit;
	
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visit[n] = true;
		
		while(!q.isEmpty()) {
			//System.out.println(temp);
			for(int s=0, size = q.size();s<size;s++) {
				int temp = q.poll();
				
				if(temp == k)
					return;
				
				for(int i=0;i<3;i++) {
					int next = temp;
					if(i==0)
						next *= go[i];
					else
						next += go[i];
					
					if(next>=0 && next<=1000000 && !visit[next]) {
						q.offer(next);
						visit[next] = true;
					}
				}
			}
			time++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		time = 0;
		visit = new boolean[1000001];
		
		if(n>=k) 
			time = n-k;
		else {
			bfs();
		}
		
		
		System.out.println(time);
	}
}