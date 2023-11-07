import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		} 
		
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i] && dp[j]+1>dp[i])
					dp[i] = dp[j]+1;
			}
		}
		
		Arrays.sort(dp);
		System.out.println(N-dp[N-1]);
	}
}