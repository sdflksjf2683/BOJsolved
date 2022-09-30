import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] rgb = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + r;
            rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + g;
            rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + b;
        }
        
        int min = Math.min(rgb[n][1], rgb[n][2]);
        min = Math.min(rgb[n][0], min);
        
        System.out.println(min);

    }
}