import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[][] table = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=1;j<=N;j++) table[i][j] = Integer.parseInt(s[j-1]);
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sum[i][j] = table[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
			}
		}
		
		while(M>0) {
			st1 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st1.nextToken());
			int y1 = Integer.parseInt(st1.nextToken());
			int x2 = Integer.parseInt(st1.nextToken());
			int y2 = Integer.parseInt(st1.nextToken());
			System.out.println(sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1]);
			M--;
		}
	}
}