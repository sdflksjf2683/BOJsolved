import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] wheel;
	
	static void right(int n, int d) {
		if(n>3) return;
		
		if(wheel[n][6]==wheel[n-1][2]) return;
		
		right(n+1, d*(-1));
		rotate(n,d);
	}
	
	static void left(int n, int d) {
		if(n<0) return;
		
		if(wheel[n][2]==wheel[n+1][6]) return; //같은극
		
		left(n-1, d*(-1));
		rotate(n,d);
	}
	
	static void rotate(int n, int d) {
		if(d==1) { //시계방향
			int tmp = wheel[n][7];
			for(int i=7;i>0;i--)
				wheel[n][i] = wheel[n][i-1];
			wheel[n][0] = tmp;
		} else { //반시계
			int tmp = wheel[n][0];
			for(int i=0;i<7;i++) 
				wheel[n][i] = wheel[n][i+1];
			wheel[n][7] = tmp;
		}
	}
	
	static void move(int n, int d) {
		//왼쪽,오른쪽 확인
		left(n-1, d*(-1));
		right(n+1, d*(-1));
		
		//목표 톱니바퀴 돌리기
		rotate(n, d);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		wheel = new int[4][8];
		
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				wheel[i][j] = s.charAt(j)-'0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			
			move(num, dir);
		}
		
		int answer = 0;
		for(int i=0;i<4;i++)
			answer += Math.pow(2,  i)*wheel[i][0];
		System.out.println(answer);
	}
}