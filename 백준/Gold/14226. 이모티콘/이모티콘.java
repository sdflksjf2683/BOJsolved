import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		int[] dp = new int[2001];
		
		dp[1] = 0; //초기 상태: 1개
		
		//초기 세팅: 처음 복사한 1개를 계속 붙여넣기
		for(int i=2;i<=2000;i++)
			dp[i] = i;
		
		for(int i=2;i<=2000;i++) {
			for(int j=2;j*i<=2000;j++) { //복붙한 게 너무 커지면X
				dp[i*j] = Math.min(dp[i*j], dp[i]+j);
			}
			
			for(int j=1999;j>i;j--) {
				dp[j] = Math.min(dp[j], dp[j+1]+1);
			}
		}
		
		System.out.println(dp[S]);
	}
}