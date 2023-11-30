import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int [] sushi = new int[N];
        for(int i=0;i<N;i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        
        int [] check = new int[d+1];
        check[c] = 3001;
        int count=1;
        
        for(int i=0;i<k;i++) {
            if(check[sushi[i]]==0) count++;
            check[sushi[i]]++;
        }
        
        int max = count;
        int start=-1, end=-1;
        for(int i=0;i<N-1;i++) {
        	start = sushi[i];
        	if(i+k<N)
        		end = sushi[i+k];
        	else
        		end = sushi[(i+k)%N];
        	
        	if(--check[start]==0)
        		count--;
        	if(++check[end]==1)
        		count++;
        	
        	max = Math.max(max, count);
        }
        
        System.out.println(max);
	}
}