import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	
	static Title[] tlist;
	
	static String search(int tmp) {
		int l=0,r=N-1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			if(tmp>tlist[mid].power) 
				l = mid+1;
			else
				r = mid-1;
		}
		
		return tlist[r+1].name;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tlist = new Title[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			tlist[i] = new Title(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int m=0;m<M;m++) {
			int tmp = Integer.parseInt(br.readLine());
			sb.append(search(tmp)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static class Title {
		int power;
		String name;
		
		public Title(String name, int power) {
			this.name = name;
			this.power = power;
		}
	}
}