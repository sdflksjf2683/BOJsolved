import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		String regx = "^(100+1+|01)+$";
		
		System.out.println(s.matches(regx)?"SUBMARINE":"NOISE");
	}
}