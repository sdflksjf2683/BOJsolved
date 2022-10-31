import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] sum = new long[n+1];
		
		sum[0] = 1;
		sum[2] = 1;
		
		for(int i=4;i<=n;i+=2) {
			for(int j=0;j<=i-2;j+=2) {
				sum[i] += sum[j]*sum[i-j-2];
				sum[i] %= 987654321;
			}
		}
		
		System.out.println(sum[n]);
	}
}