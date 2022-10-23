import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] senior = new int[N+1]; //상사 번호 저장할 배열
		int[] praise = new int[N+1]; //받은 칭찬의 양 저장할 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) { //i가 직원번호, 입력받은 값이 상사번호
			senior[i] = Integer.parseInt(st.nextToken());
			if(senior[i]==-1)  //인덱스 처리를 위해 0으로 맞추기
				senior[i] = 0;
		}
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			praise[i] += w; 
		}

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			praise[i] += praise[senior[i]];
			sb.append(praise[i]+" ");
		}
		System.out.println(sb);
	}
}