import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		int ans = 0;
		while(true) {
			
			if(N==1 || N==2 || N==4 || N<0) {
				ans = -1;
				break;
			}
			
			if(N==0)
				break;
			
			if(N%5 == 0) {
				N -= 5;
				ans++;
			}
			else if(N%3==0) {
				N -= 3;
				ans++;
			}
			else {
				if(N>5) {
					N -= 5;
					ans++;
				}
				else {
					N-= 3;
					ans++;
				}
				
			}
		}
		
		System.out.println(ans);
		
	}
}
