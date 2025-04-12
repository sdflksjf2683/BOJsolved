import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			pq.add(Long.parseLong(br.readLine()));
		} //end input
		
		long sum = 0;
		while(pq.size()>1) {
			long tmp1 = pq.poll();
			long tmp2 = pq.poll();
			
			sum += (tmp1+tmp2);
			pq.add(tmp1+tmp2);
		}
		System.out.println(sum);
	}
}
