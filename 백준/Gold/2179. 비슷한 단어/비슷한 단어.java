import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int check(String s1, String s2) {
		int cnt = 0, size = Math.min(s1.length(), s2.length());
		for(int i=0;i<size;i++) {
			if(s1.charAt(i)==s2.charAt(i)) cnt++;
			else break;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			if(!list.contains(tmp)) 
				list.add(tmp);
		}
		
		int ans1=-1,ans2=-1;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<N-1;i++) {
			String s1 = list.get(i);
			
			for(int j=i+1;j<N;j++) {
				int cnt=0;
				String s2 = list.get(j);

				cnt = check(s1,s2);
				
				if(cnt>max) {
					ans1 = i;
					ans2 = j;
					max = cnt;
				}
			}
		}
		
		System.out.println(list.get(ans1));
		System.out.println(list.get(ans2));
	}
}