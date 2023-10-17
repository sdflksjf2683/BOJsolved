import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] line = br.readLine().toCharArray();
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			if(line[i]=='P') {
				int e = Math.min(i+K, N-1);
				
				for(int s=Math.max(i-K, 0);s<=e;s++) {
					if(line[s]=='H') {
						line[s] = '.';
						answer++;
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}