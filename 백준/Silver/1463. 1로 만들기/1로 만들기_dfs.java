import java.util.Scanner;

public class Main {
	
	static int n, min;
	
	static void dfs(int N, int cnt) {
		if(N==1) {
			min = min>cnt?cnt:min;
			return;
		}
		
		if(cnt>=min) return;
		
		if(N%3==0) 
			dfs(N/3, cnt+1);
		
		if(N%2==0) 
			dfs(N/2, cnt+1);
		
		dfs(N-1, cnt+1);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		min = Integer.MAX_VALUE;
		dfs(n, 0);
		System.out.println(min);
	}
}
