import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] nums;
	static StringBuilder sb;
	
	static void comb(int cnt) {
		if(cnt==M) {
			for(int n: nums) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1;i<=N;i++) {
			nums[cnt] = i;
			comb(cnt+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[M];

		comb(0);
		System.out.println(sb);
	}
}