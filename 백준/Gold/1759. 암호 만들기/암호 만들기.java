import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int L, C;
	static char[] s;
	static boolean[] select;
	
	static void comb(int cnt, int idx) {
		if(cnt==L) {
			int v = 0;
			int c = 0;
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<C;i++) {
				if(select[i]) {
					sb.append(s[i]);
					
					if(s[i]=='a' || s[i]=='e' || s[i]=='i' || s[i]=='o' || s[i]=='u')
						v++;
					else
						c++;
				}
			}
			if(v>=1 && c>=2)
				System.out.println(sb);
			return;
		}
		
		for(int i=idx;i<C;i++) {
			select[i] = true;
			comb(cnt+1, i+1);
			select[i] = false;

		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		s = new char[C];
		select = new boolean[C];
		
		for(int i=0;i<C;i++) {
			s[i] = sc.next().charAt(0);
		}
		Arrays.sort(s);
		comb(0,0);
	}
}