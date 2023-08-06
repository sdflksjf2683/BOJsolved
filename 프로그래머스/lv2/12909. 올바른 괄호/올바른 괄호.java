import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack stack = new Stack<>();
        if(s.charAt(0)==')') return false;
        
        for(int i=0,size=s.length();i<size;i++) {
            char tmp = s.charAt(i);
            
            if(tmp=='(') {
                stack.push(tmp);
                continue;
            } else {
                if(!stack.isEmpty()) stack.pop();
                else return false;
            }
        }
        
        if(!stack.isEmpty())
            return false;
        
        

        return true;
    }
}