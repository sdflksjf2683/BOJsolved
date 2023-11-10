import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long target=0, tmp=0;
        for(int i=0,size=queue1.length;i<size;i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            target += queue1[i]+queue2[i];
            tmp+=queue1[i];
        }
        if(target%2==1) return -1; //총합이 홀수인 경우 -> 두 큐의 합을 같게 할 수 없음
        
        target /=2;
        
        int cnt = 0;
        while(true) {
            if(tmp == target) break; //큐 완성
            
            if(cnt > (queue1.length + queue2.length+2)) return -1; //두 큐의 모든 원소를 움직여본 경우
            
            if(tmp > target) { //q1의 원소합이 더 큼
                tmp -= q1.peek();
                q2.offer(q1.poll());
            } else {
                tmp += q2.peek();
                q1.offer(q2.poll());
            }
            cnt++;
        }

        return cnt;
    }
}