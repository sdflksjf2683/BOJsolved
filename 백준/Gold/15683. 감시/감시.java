import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static String[][] map;
	//상하좌우
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	static ArrayList<int[]> cams;
	
	static int result;
	
	
	static String[][] deepcopy(String[][] m) {
		String[][] copy = new String[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j] = m[i][j];
			}
		}
		return copy;
	}
	
	static int answer(String[][] m) {
		int ans = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(m[i][j].equals("0")) ans++;
			}
		}
		return ans;
	}
	
	static void search(int idx, String[][] m) {
		if(idx==cams.size()) {
			result = Math.min(result, answer(m));
			return;
		}
		
		int[] temp = cams.get(idx);
		String camnum = m[temp[0]][temp[1]];
		switch(camnum) {
		case "1":
			cam1(idx, m, temp[0], temp[1]);
			break;
		case "2":
			cam2(idx, m, temp[0], temp[1]);
			break;
		case "3":
			cam3(idx, m, temp[0], temp[1]);
			break;
		case "4":
			cam4(idx, m, temp[0], temp[1]);
			break;
		}
	}
	
	static void cam1(int idx, String[][] m, int i, int j) {
		for(int d=0;d<4;d++) {
			search(idx+1, fill(m, d, i, j));
		}
	}
	
	static void cam2(int idx, String[][] m, int i, int j) {
		String[][] tmp1 = fill(m, 0, i, j);
		tmp1 = fill(tmp1, 1, i, j);
		search(idx+1, tmp1);
		
		String[][] tmp2 = fill(m, 2, i, j);
		tmp2 = fill(tmp2, 3, i, j);
		search(idx+1, tmp2);
	}

	static void cam3(int idx, String[][] m, int i, int j) {
		String[][] tmp1 = fill(m, 0, i, j);
		tmp1 = fill(tmp1, 3, i, j);
		search(idx+1, tmp1);
		
		String[][] tmp2 = fill(m, 1, i, j);
		tmp2 = fill(tmp2, 2, i, j);
		search(idx+1, tmp2);
		
		String[][] tmp3 = fill(m, 2, i, j);
		tmp3 = fill(tmp3, 0, i, j);
		search(idx+1, tmp3);
		
		String[][] tmp4 = fill(m, 3, i, j);
		tmp4 = fill(tmp4, 1, i, j);
		search(idx+1, tmp4);
		
	}
	
	static void cam4(int idx, String[][] m, int i, int j) {
		String[][] tmp1 = fill(m, 0, i, j);
		tmp1 = fill(tmp1, 2, i, j);
		tmp1 = fill(tmp1, 3, i, j);
		search(idx+1, tmp1);
		
		String[][] tmp2 = fill(m, 1, i, j);
		tmp2 = fill(tmp2, 2, i, j);
		tmp2 = fill(tmp2, 3, i, j);
		search(idx+1, tmp2);
		
		String[][] tmp3 = fill(m, 2, i, j);
		tmp3 = fill(tmp3, 0, i, j);
		tmp3 = fill(tmp3, 1, i, j);
		search(idx+1, tmp3);
		
		String[][] tmp4 = fill(m, 3, i, j);
		tmp4 = fill(tmp4, 0, i, j);
		tmp4 = fill(tmp4, 1, i, j);
		search(idx+1, tmp4);
	}
	
	static String[][] fill(String[][] m, int idx, int i, int j) {
		String[][] copy = deepcopy(m);
		
		while(true) {
			int ti = i+di[idx];
			int tj = j+dj[idx];
			
			if(ti<0 || tj<0 || ti>=N || tj>=M || copy[ti][tj].equals("6")) 
				break;
			if(copy[ti][tj].equals("0")) {
				copy[ti][tj] = "#";
			}
			
			i = ti;
			j = tj;
		}
		return copy;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new String[N][M];
		cams = new ArrayList<>();
		ArrayList<int[]> cam5 = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.next();
				if(map[i][j].equals("5"))
					cam5.add(new int[] {i,j});
				else if(!map[i][j].equals("0") && !map[i][j].equals("6"))
					cams.add(new int[] {i, j});
			}
		}
		
		//5번카메라 먼저 체크
		for(int i=0;i<cam5.size();i++) {
			int idx = 0;
			int ni = cam5.get(i)[0];
			int nj = cam5.get(i)[1];
			
			while(idx<4) {
				int ti = ni+di[idx];
				int tj = nj+dj[idx];
				
				if(ti>=0 && tj>=0 && ti<N && tj<M && !map[ti][tj].equals("6")) {
					if(map[ti][tj].equals("0"))
						map[ti][tj] = "#";
					ni = ti;
					nj = tj;
					continue;
				}
				ni = cam5.get(i)[0];
				nj = cam5.get(i)[1];
				idx++;
			}
		}
		
		result = Integer.MAX_VALUE;
		search(0, map);
		System.out.println(result);
	}

}