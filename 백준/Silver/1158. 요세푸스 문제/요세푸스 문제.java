import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i=1;i<=N;i++) q.add(i);
		
		int[] ans = new int[N];
		int idx = 0;
		int cnt = 1;
		while(!q.isEmpty()) {
			while(cnt%K!=0) {
				q.add(q.poll());
				cnt++;
			}
			ans[idx++] = q.poll();
			cnt++;			
		}
		System.out.print("<");
		for(int i=0;i<N;i++) {
			if(i==N-1)
				System.out.println(ans[i]+">");
			else
				System.out.print(ans[i]+", ");
		}
	}
}
