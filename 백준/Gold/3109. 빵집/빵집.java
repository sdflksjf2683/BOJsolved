import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, ans;
	static char[][] map;
	
	//12시 방향부터 시계방향으로
	static int[] di = {-1,0,1};
	static int[] dj = {1,1,1};
	
	static boolean pipe(int i, int j) {
		map[i][j] = '#';
		
		if(j==C-1)
			return true;
		
		for(int d=0;d<3;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj]=='.') {
				if(pipe(ni, nj))
					return true;
			}
		}
			
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ans = 0;
		
		for(int i=0;i<R;i++) {
			if(pipe(i, 0))
				ans++;
		}
		
		System.out.println(ans);
	}
}
