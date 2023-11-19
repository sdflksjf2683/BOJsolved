import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {
        Stack<Integer> stack = new Stack<>();
        
        for(String cmd: cmds) {
            char c = cmd.charAt(0);
            if(c=='U') {
                k -= Integer.valueOf(cmd.substring(2));
            } else if(c=='D') {
                k += Integer.valueOf(cmd.substring(2));
            } else if(c=='C') {
                stack.push(k);
                n--;
                if(k==n) 
                    k--;
            } else {
                if(stack.pop()<=k) 
                    k++;
                n++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++) {
            sb.append("O");
        }
        
        while(!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }
        
        return sb.toString();
    }
}