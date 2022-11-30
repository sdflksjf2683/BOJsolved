import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static String switchWord(String str) {
		StringBuilder sb = new StringBuilder();
		int size = str.length();
		//앞 복원
		for(int i=0;i<size;i+=2)
			sb.append(str.charAt(i));
		
		if(size%2==1) {
			size = size-1;
		}
		//뒤 복원
		for(int i=size-1;i>0;i-=2)
			sb.append(str.charAt(i));
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		String original = sc.next();
		
		int x = X;
		int cnt = 0;
		String temp = original;
		List<String> record = new ArrayList<>();
		while(x>0) { //반복주기 찾기
//			System.out.println(temp+" "+x);			
			temp = switchWord(temp);
			record.add(temp);
			cnt++;
			if(temp.equals(original)) break; //반복 주기를 찾은 경우 
			
			x--;
		}
//		cnt++;
//		System.out.println("x: "+x+" cnt: "+cnt);
		if(x==0 || x==X)
			System.out.println(temp);
		else {
			x = (X%cnt)-1;
			System.out.println(record.get(x));
		}
	}
}