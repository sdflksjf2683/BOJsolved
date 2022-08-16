import java.util.Scanner;

public class Main {
	
	static int cnt, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = (int)Math.pow(2, sc.nextInt());
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		search(N, r, c);
		System.out.println(cnt);

	}
	
	static void search(int n, int i, int j) {
		//좌표 위치 찾음
		if(n==1) return;
		
		int sum = n*n/4;
		
		if(i<n/2 && j<n/2) { //왼쪽 위
			search(n/2,i,j);
		}
		else if(i<n/2 && j>=n/2) { //오른쪽 위
			cnt += sum;
			search(n/2,i,j-n/2);
		}
		else if(i>=n/2&&j<n/2) { //왼쪽 아래
			cnt += sum*2;
			search(n/2, i-n/2, j);
		}
		else {
			cnt += sum*3;
			search(n/2, i-n/2, j-n/2);
		}
	}
}
