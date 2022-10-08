import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] money = new int[K+1][2];
		
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine());
			money[i][0] = Integer.parseInt(st.nextToken());
			money[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] sum = new int[K+1][T+1];
		sum[0][0] = 1;
		for(int i=1;i<=K;i++) {
			int temp = money[i][0];
			for(int j=0;j<=money[i][1];j++) {
				for(int k=0;k<=T;k++) {
					int cost = k+temp*j;
					if(cost>T) break;
					sum[i][cost] += sum[i-1][k];
				}
			}
		}
		
		System.out.println(sum[K][T]);
	}
}