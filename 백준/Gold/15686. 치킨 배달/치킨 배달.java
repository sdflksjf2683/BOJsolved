import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N, M, ans;
	static int[][] map;
	static ArrayList<int[]> ch, house;
	static boolean[] select;
	
	//M개의 치킨집을 선택한 조합에 대한 치킨거리 반환
	static void calculate(int[][] list) {
		int city = 0;
		for(int h=0;h<house.size();h++) {
			//각 집의 치킨거리
			int homelen = Integer.MAX_VALUE;
			for(int[] c: list) {
				homelen = Math.min(homelen, Math.abs(house.get(h)[0]-c[0])+Math.abs(house.get(h)[1]-c[1]));
			}
			city += homelen;
		}
		//최솟값 갱신
		ans = Math.min(ans, city);
	}
	
	static void pick(int idx, int cnt) {
		int[][] chlist = new int[M][2];
		if(cnt==M) {
			int m=0;
			//M개의 치킨집 리스트 만들기
			for(int i=0;i<ch.size();i++) {
				if(select[i]) {
					chlist[m][0] = ch.get(i)[0];
					chlist[m][1] = ch.get(i)[1];
					m++;
				}
			}
			//치킨집 거리 계산
			calculate(chlist);
			return;
		}
		
		if(idx == ch.size()) return;
		
		select[idx] = true;
		pick(idx+1, cnt+1);
		select[idx] = false;
		pick(idx+1, cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		ch = new ArrayList<>();
		house = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2)
					ch.add(new int[] {i,j});
				else if(map[i][j]==1)
					house.add(new int[] {i,j});
			}
		}
		
		select = new boolean[ch.size()];
		ans = Integer.MAX_VALUE;
		pick(0,0);
		System.out.println(ans);
		
	}
}