import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		long[][] num = new long[65][10];
		
		for(int i=0;i<10;i++) { //한자리 수일 경우
			num[1][i] = i+1;
		}
		
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			
			for(int i=2;i<=n;i++) {
				num[i][0] = 1;
				for(int j=1;j<10;j++) {
					num[i][j] = num[i-1][j]+num[i][j-1];
				}
			}
			
			System.out.println(num[n][9]);
		}
	}
}