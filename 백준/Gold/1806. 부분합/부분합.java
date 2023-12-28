import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		//end input
		
		int ans = Integer.MAX_VALUE;
		int l=0,r=0;
		int sum=0;
		while(l<=N && r<=N) {
			if(sum>=S) {
				ans = Math.min(ans, r-l);
			}
			
			if(sum<S)
				sum += arr[r++];
			else
				sum -= arr[l++];
		}
		
		if(ans==Integer.MAX_VALUE)
			ans = 0;
		
		System.out.println(ans);
	}
}