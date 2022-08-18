import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s1 = br.readLine().split("-");
		int ans = 0;
		
		for(int i=0;i<s1.length;i++) {
			String[] s2 = s1[i].split("\\+");
			int sum = 0;
			for(int j=0;j<s2.length;j++) {
				sum+=Integer.parseInt(s2[j]);
			}
			if(i==0)
				ans += sum;
			else
				ans -= sum;
		}
		
		System.out.println(ans);

	}
}