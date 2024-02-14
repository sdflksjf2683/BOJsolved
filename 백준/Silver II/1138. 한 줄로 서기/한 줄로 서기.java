import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //end input
		
		int[] ans = new int[N+1];
		for(int i=1;i<=N;i++) {
			int tmp=1;
			
			while(true) {
				if(arr[i]==0 && ans[tmp]==0) {
					ans[tmp] = i;
					break;
				}
				
				if(ans[tmp]==0) {
					arr[i]--;
				}
				
				tmp++;
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(ans[i]+" ");
		}
	}
}