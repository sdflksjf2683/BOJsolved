import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] nums = new int[1000001];

        for (int i = 2; i <= n; i++) {
        	nums[i] = nums[i-1] + 1;
            if (i % 2 == 0)
            	nums[i] = Math.min(nums[i], nums[i/2]+1);
            if (i % 3 == 0)
            	nums[i] = Math.min(nums[i], nums[i/3]+1);
        }
    	
        System.out.println(nums[n]);
    }
}
