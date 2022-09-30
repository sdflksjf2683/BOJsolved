import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[1000001];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp==1) break;
			
			if(temp%3==0 && nums[temp/3]==0) { //방문하지 않았고 3으로 나누어질 경우
				nums[temp/3] = nums[temp]+1; //거리증가
				q.offer(temp/3);
			}
			
			if(temp%2==0 && nums[temp/2]==0) {
				nums[temp/2] = nums[temp]+1;
				q.offer(temp/2);
			}
			
			if(nums[temp-1]==0) {
				nums[temp-1] = nums[temp]+1;
				q.offer(temp-1);
			}
		}
		
		System.out.println(nums[1]);
	}
}
