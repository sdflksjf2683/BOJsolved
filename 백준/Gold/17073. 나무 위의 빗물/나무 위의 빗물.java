import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		List<Integer>[] tree = new ArrayList[N+1];
		
		//초기화
		for(int n=1;n<=N;n++) {
			tree[n] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			tree[U].add(V);
			tree[V].add(U);
		}
		
		int cnt = 0; //리프노드 개수
		for(int i=2;i<=N;i++) {
			if(tree[i].size()==1) cnt++;
		}
		System.out.println((double)W/cnt);
	}
}