import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] score = new int[301];
		int[] sum = new int[301];
		
		for(int i=1;i<=N;i++) {
			score[i] = sc.nextInt();
		}
		
		sum[1] = score[1];
		sum[2] = score[1]+score[2];
		sum[3] = Math.max(score[1]+score[3], score[2]+score[3]);
		
		for(int n=4;n<=N;n++) {
			sum[n] = Math.max(sum[n-3]+score[n-1]+score[n], sum[n-2]+score[n]);
		}
		System.out.println(sum[N]);
	}
}