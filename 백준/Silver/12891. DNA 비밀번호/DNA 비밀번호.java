import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String[] dna = br.readLine().split("");
		Map<String,Integer> cnt = new HashMap<>();
		String[] sample = {"A","C","G","T"};
		
		for(int i=0;i<4;i++) cnt.put(sample[i], 0);
		
		int[] min = new int[4];
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<=S-P;i++) {
			int isValid = 1;
			if(i==0) {
				for(int j=0;j<P;j++) {
					cnt.put(dna[j], cnt.get(dna[j])+1);
				}
			} else {
				cnt.put(dna[i-1], cnt.get(dna[i-1])-1);
				cnt.put(dna[i+P-1], cnt.get(dna[i+P-1])+1);
			}
			//최솟값 확인
			for(int j=0;j<4;j++) {
				if(min[j]>cnt.get(sample[j])) isValid = 0;
			}
			
			if(isValid==1) ans++;

		}
		
		System.out.println(ans);
	}
}
