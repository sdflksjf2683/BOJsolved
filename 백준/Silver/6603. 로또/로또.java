import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] s, lnum;
	static int k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();
			if(k==0) break;
			
			s = new int[k];
			lnum = new int[k];
			
			for(int i=0;i<k;i++) {
				s[i] = sc.nextInt();
			}
			
			lotto(0,0);
			System.out.println();
		}
	}
	
	static void lotto(int start, int cnt) {
		
		if(cnt==6) {
			for(int i=0;i<k;i++) {
				if(lnum[i]==1)
					System.out.print(s[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<k;i++) {
			lnum[i] = 1;
			lotto(i+1, cnt+1);
			lnum[i] = 0;
		}
		
		
	}
}