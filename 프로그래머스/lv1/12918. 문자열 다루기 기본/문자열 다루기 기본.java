class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.matches("^[0-9]*$")&&(s.length()==4 || s.length()==6)) answer = true;
        else answer = false;
        return answer;
    }
}