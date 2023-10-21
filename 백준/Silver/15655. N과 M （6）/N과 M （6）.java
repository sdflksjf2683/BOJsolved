import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[] nums, res;
	static boolean[] visit;
	
	static StringBuilder sb;
	
	static void comb(int cnt, int idx) {
		if(cnt==M) {
			for(int r: res)
				sb.append(r+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=idx;i<N;i++) {
			
			if(visit[i]) continue;
			
			visit[i] = true;
			res[cnt] = nums[i];
			comb(cnt+1, i);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		res = new int[M];
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		sb = new StringBuilder();
		
		comb(0,0);
		
		System.out.println(sb.toString());
	}
}