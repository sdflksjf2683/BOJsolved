import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] s = br.readLine().split(" ");
		int[] nums = new int[N+1];
		int[] sums = new int[N+1];
		
		for(int n=1;n<=N;n++) nums[n] = Integer.parseInt(s[n-1]);
		for(int n=1;n<=N;n++) sums[n] = sums[n-1] + nums[n];
		
		while(M>0) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(str.nextToken());
			int j = Integer.parseInt(str.nextToken());
			System.out.println(sums[j]-sums[i-1]);
			M--;
		}
	}
}