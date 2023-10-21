import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] nums;
	static boolean[] select;
	
	static void perm(int cnt) {
		if(cnt==M) {
			for(int n: nums)
				System.out.print(n+" ");
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(select[i]) continue;
			
			nums[cnt] = i+1;
			select[i] = true;
			perm(cnt+1);
			select[i] = false;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[M];
		select = new boolean[N];

		perm(0);
	}
}