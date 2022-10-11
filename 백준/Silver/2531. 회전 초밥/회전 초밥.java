import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] plate = new int[N];
		int[] select = new int[d+1];
		
		for(int i=0;i<N;i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int p=0;p<k;p++) {
			if(select[plate[p]]==0) {
				cnt++;
			}
			select[plate[p]]++;
		}
		
		int max = cnt;
		for(int i=1;i<N;i++) {
			if(max<=cnt) {
				if(select[c]==0)
					max = cnt+1;
				else
					max = cnt;
			}
			
			int end = (i+k-1)%N;
			if(select[plate[end]]==0)
				cnt++;
			select[plate[end]]++;
			
			//start 이동
			select[plate[i-1]]--;
			if(select[plate[i-1]]==0)
				cnt--;
		}
		
		System.out.println(max);
	}
}