import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력받기
		int N = sc.nextInt()+1;
		int[] switches = new int[N];
		for(int i=1;i<N;i++) switches[i] = sc.nextInt();
		int stdNum = sc.nextInt();
		
		for(int i=1;i<=stdNum;i++) {
			int std = sc.nextInt();
			int num = sc.nextInt();
			
			//남학생의 경우 배수만큼 스위치를 바꿈
			if(std == 1) {
				for(int j=num;j<N;j+=num) {
					switches[j] = switches[j]==0 ? 1:0;
				}
			}
			
			else if (std == 2){
				//양쪽 대칭 검사
				int l = num-1;
				int r = num+1;
				
				while(true) {
					if(l<1 || r>=N) break;
					if(switches[l]!=switches[r]) break;
					l--; r++;
				}
				l++;
				r--;
				
				//왼쪽부터 범위 내 스위치 변경
				while(l<=r) {
					switches[l] = switches[l]==0 ? 1:0;
					l++;
				}
				
			}
		}
		
		for(int i=1;i<N;i++) {
			System.out.print(switches[i]+" ");
			if(i%20==0) System.out.println();
		}
		
	}
}
