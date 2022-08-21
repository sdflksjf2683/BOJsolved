import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] nums;
	
	static void comb(int idx, int cnt) {
		if(cnt==M) {
			for(int n: nums)
				System.out.print(n+" ");
			System.out.println();
			return;
		}
		
		for(int i=idx;i<=N;i++) {
			nums[cnt] = i;
			comb(i+1, cnt+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[M];

		comb(1,0);
	}
}