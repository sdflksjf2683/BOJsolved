import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		long y = sc.nextInt();
		int w = sc.nextInt();
		int s = sc.nextInt();
		
		long result = 0;
		
		//가로세로보다 대각선이 빠른 경우
		
		if(2*w < s) {//대각선 한번보다 가로+세로 이동이 더 빠른 경우
			result = (x+y)*w; //가로+세로로만 이동 
		}
		
		else if(w > s) {
			if((x+y)%2==0) result = Math.max(x, y)*s; //대각선으로만 이동 가능
			else result = (Math.max(x, y)-1)*s + w; //대각선 + 마지막에 가로/세로
		}
		
		else if(x==y) { //대각선으로 일직선 이동
			result = y*s;
		}
		
		else { 
			long temp = Math.min(x*s, y*s); //일단 대각선으로 가능한만큼 이동
			result = temp+Math.abs(x-y)*w; //남은만큼 가로+세로로 도착
		}
		
		System.out.println(result);
	}
}