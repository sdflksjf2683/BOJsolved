import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,L,K;
	
	static List<int[]> star;
	
	static int countStar(int i, int j) {
		int cnt = 0;
		for(int[] s: star)
			if(i<=s[0] && i+L>=s[0] && j<=s[1] && j+L>=s[1])
				cnt++;
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		star = new ArrayList<int[]>();
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			star.add(new int[] {i,j});
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<K;i++) {
			for(int j=0;j<K;j++) {
				int si = star.get(i)[0]; //별똥별 하나에서 i 가져오고 
				int sj = star.get(j)[1]; //다른 하나에서 j 가져옴 
				
				ans = Math.max(ans, countStar(si, sj));
			}
		}
		System.out.println(K-ans);
		
		
	}
}