import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int temp=0,cnt=0;
		
		for(int i=0,j=0;j<N;j++) {
			temp += nums[j];
			if(temp<M) continue;
			
			if(temp>M) {
				while(temp>M) {
					temp -= nums[i];
					i++;
				}
			}
			
			if(temp==M) {
				cnt++;
				temp -= nums[i];
				i++;
			}
		}
		
		System.out.println(cnt);
	}
}