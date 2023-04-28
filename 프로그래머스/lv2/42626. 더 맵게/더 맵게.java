import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i: scoville) {
            pq.offer(i);
        }
        
        int answer = 0;
        
        while(pq.peek()<K) {
            
            if(pq.size() < 2)
                return -1;
            
            int a = pq.poll();
            int b = pq.poll();
            
            int newSc = a + (b*2);
            pq.offer(newSc);
            answer++;
        }
        
        return answer;
    }
}