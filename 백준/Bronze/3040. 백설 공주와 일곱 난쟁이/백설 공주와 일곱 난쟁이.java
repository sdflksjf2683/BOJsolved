import java.util.Scanner;

public class Main {
	
	static int[] nine, seven;
	
	static void whoIs (int cnt, int first) {
		if(cnt==7) {
			int sum = 0;
			for(int n: seven)
				sum += n;
			if(sum==100) {
				for(int n: seven)
					System.out.println(n);
				return;
			}
			return;
		}
		
		for(int i=first;i<9;i++) {
			seven[cnt] = nine[i];
			whoIs(cnt+1, i+1);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nine = new int[9];
		seven = new int[7];
		
		for(int i=0;i<9;i++)
			nine[i] = sc.nextInt();
		
		whoIs(0,0);
	}
}
