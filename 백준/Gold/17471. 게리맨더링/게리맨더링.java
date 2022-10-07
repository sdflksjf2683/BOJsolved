import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,min;
	
	static int[] pp;
	static int[] connect;
	static boolean[] select;
	
	static int[][] adjList;
	
	static boolean isConnect(boolean flag, int n, int start) {
		int cnt=1;
		boolean[] visit = new boolean[N+1]; //방문체크 배열
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=0;i<connect[temp];i++) { 
				int next = adjList[temp][i];
				
				if(select[next]==flag && !visit[next]) { //같은 팀이고 아직 방문 안했으면
					q.offer(next);
					visit[next] = true;
					cnt++;
				}
			}
		}
//		System.out.println(flag+"팀 연결횟수(cnt/n): "+cnt+"/"+n);
		if(cnt==n)
			return true;
		
		return false;
	}
	
	static int getPopulation(boolean[] arr ) { //인구 차이 리턴
		int tsum=0, fsum=0;
		for(int i=1;i<=N;i++) {
			if(arr[i]) tsum+=pp[i];
			else fsum+=pp[i];
		}
		return Math.abs(tsum-fsum);
	}
	
	static void selectTeam(int idx, int cnt, int n) {
		if(cnt==n) {
//			System.out.println("------------팀뽑음-----------");
//			for(int i=1;i<=N;i++) {
//				if(select[i])
//					System.out.print(i+" ");
//			}
//			System.out.println();
			int sum = getPopulation(select); //인구수 차이 구하기
			if(min>sum) { //이전의 최솟값보다 작으면
				int tstart=0, fstart=0;
				for(int i=1;i<=N;i++) {
					if(tstart==0 && select[i])
						tstart = i;
					if(fstart==0 && !select[i])
						fstart = i;
					if(tstart>0 && fstart>0) break;
				}
//				System.out.println("------------팀대표-----------");
//				System.out.println("true: "+tstart+" false: "+fstart);
//				System.out.println("지금까지 최솟값: "+min);
//				System.out.println("지금 인구 차이: "+sum);
				if(isConnect(true, n,tstart) && isConnect(false, N-n, fstart)) { //두 구역 모두 연결?
					min = sum; //유효한 선거구이면 갱신
				}
			}
			return;
		}
		
		if(idx>N) return;
		
		select[idx] = true;
		selectTeam(idx+1,cnt+1,n);
		select[idx] = false;
		selectTeam(idx+1,cnt,n);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjList = new int[N+1][];
		pp = new int[N+1];
		connect = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			pp[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			connect[i] = n;
			adjList[i] = new int[n];
			for(int j=0;j<n;j++) {
				adjList[i][j] = Integer.parseInt(st.nextToken());
			}
		} //end input
		
		min = Integer.MAX_VALUE;
		for(int i=1;i<=N/2;i++) {
			select = new boolean[N+1]; //선택한 구역
			selectTeam(1,0,i);
		}
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
}