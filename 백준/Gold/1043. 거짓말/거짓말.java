import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,ans;
	
	static int[] tpeople;
	static ArrayList<Integer>[] party;
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] checkParty = new boolean[M];
		boolean[] checkPeople = new boolean[N+1];
		
		for(int i=0,size=tpeople.length;i<size;i++) {
			q.add(tpeople[i]);
			checkPeople[tpeople[i]] = true;
		}
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=0;i<M;i++) {
				if(checkParty[i]) continue;
				
				if(!party[i].contains(temp)) continue;
				
				for(int j=0,size=party[i].size();j<size;j++) {
					int next = party[i].get(j);
					
					if(checkPeople[next]) continue;
					
					checkPeople[next] = true;
					q.add(next);
				}
				
				checkParty[i] = true;
				ans--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		party = new ArrayList[M];
		
		st = new StringTokenizer(br.readLine());
		tpeople = new int[Integer.parseInt(st.nextToken())];
		for(int i=0,size=tpeople.length;i<size;i++) {
			tpeople[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();
			
			for(int j=0,size=Integer.parseInt(st.nextToken());j<size;j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		ans = M;
		bfs();
		System.out.println(ans);
	}
}