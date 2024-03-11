import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String num = sc.next();
		
		char[] nums = num.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		
		for(int i=0;i<N;i++) {
			while(K>0 && !deque.isEmpty()) {
				if(deque.getLast()>=nums[i]) {
					break;
				}
				
				deque.removeLast();
				K--;
			}
			deque.addLast(nums[i]);
		}
		
		while(K>0) {
			deque.removeLast();
			K--;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!deque.isEmpty()) {
			sb.append(deque.removeFirst());
		}
		
		System.out.println(sb.toString());
	}
}