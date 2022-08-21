import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] nums;
	static StringBuilder sb;
	
	static void perm(int cnt, int idx) {
		if(cnt==M) {
			for(int n: nums)
				sb.append(n).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i=idx;i<=N;i++) {
			nums[cnt] = i;
			perm(cnt+1, i);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[M];

		perm(0,1);
		System.out.println(sb);
	}
}