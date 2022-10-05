import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;

	static int[][] map;
	static boolean[][] visit;

	static int[] di = { 0, 0, -1, 1 };
	static int[] dj = { -1, 1, 0, 0 };

	static List<Integer> cheese;

	static void removeCheese() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2)
					map[i][j] = 0;
			}
		}
	}

	static int getCount() {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}

	static void bfs() {

		Queue<Point> queue = new LinkedList<>();
		visit = new boolean[n][m];
		queue.add(new Point(0, 0));
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			Point temp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ni = temp.i + di[d];
				int nj = temp.j + dj[d];

				if (ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
				
				if (visit[ni][nj]) continue;
				
				if (map[ni][nj] == 1) { //치즈 테두리 2로 바꾸고 
					map[ni][nj] = 2;
					visit[ni][nj] = true;
				}
				
				if (map[ni][nj] == 0) {
					visit[ni][nj] = true;
					queue.add(new Point(ni, nj));
				}
			}
		}

		removeCheese(); //한번에 녹이기
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		cheese = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = true; //치즈 다 녹으면 false
		int time = 0; // 시간
		int firstCount = getCount(); // 초기상태 치즈의 개수

		while (flag) {
			time++;

			bfs();

			int count = getCount();

			if (count == 0)
				flag = false;
			else
				cheese.add(count);
		}

		System.out.println(time);

		if (cheese.size() > 0)
			System.out.println(cheese.get(cheese.size() - 1));
		// 1시간에 치즈 다 녹음 or 치즈 없음
		else
			System.out.println(firstCount);
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
}