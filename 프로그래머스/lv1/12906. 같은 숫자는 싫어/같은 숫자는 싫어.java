import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
            if(i!=0&&st.peek() == arr[i-1]){
                st.pop();
            }
        }
        int[] answer = new int[st.size()];
        int n=0;
        for(int e : st){
            answer[n++] = e;
        }
        
        return answer;
    }
}