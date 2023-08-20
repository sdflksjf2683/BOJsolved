import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int e : priorities) queue.offer(e);
        
        while(!queue.isEmpty()) {
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==queue.peek()){
                    if(location==i) return answer;
                    answer++;
                    queue.poll();
                }
            }
        }
        return answer;
    }
}