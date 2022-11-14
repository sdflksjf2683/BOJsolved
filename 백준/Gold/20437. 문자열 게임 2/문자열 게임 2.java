import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
				
		for(int t=0;t<T;t++) {
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());
			
			if(k==1) {
				sb.append(1+" "+1+"\n");
				continue;
			}
			
			int[] ch = new int[26];
			//각 문자 개수 세기 
			for(int i=0;i<w.length();i++) {
				ch[w.charAt(i)-'a']++;
			}
			
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for(int i=0;i<w.length();i++) {
				if(ch[w.charAt(i)-'a']<k) continue; //k개보다 작으면 셀 필요 없음
				
				int cnt = 1;
				for(int j=i+1;j<w.length();j++) {
					if(w.charAt(i)==w.charAt(j)) cnt++;
					if(cnt==k) {
						min = Math.min(min, j-i+1);
						max = Math.max(max, j-i+1);
						break;
					}
				}
			}
			if(max==Integer.MIN_VALUE || min==Integer.MAX_VALUE) sb.append(-1+"\n");
			else sb.append(min+" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
}