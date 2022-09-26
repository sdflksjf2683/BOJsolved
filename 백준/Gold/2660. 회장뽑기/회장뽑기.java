import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();

		int[][] map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                	map[i][j] = 51;
                }
            }
        }
		
		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x==-1 && y==-1)
				break;
			map[x][y] = map[y][x] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] > map[i][k] + map[k][j]){
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int min = 51;
		int[] result = new int[N+1];
		for(int i=1; i<=N; i++) {
			int temp =0;
			for(int j=1; j<=N; j++) {
				if (map[i][j] != 51) 
					temp = Math.max(temp, map[i][j]);
			}
			result[i] = temp;
			min = Math.min(min, temp);
		}
		
		
		int cnt =0;
		for(int i=1; i<=N; i++) {
			if(result[i] == min) {
				cnt++;
				sb.append(i +" ");
			}
		}
       
		
		System.out.println(min+" "+cnt);
		System.out.println(sb.toString());
		
	}
}