import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left =10;
        int right =12;
        
        for(int tmp: numbers){
            if(tmp==1||tmp==4||tmp==7){
                answer.append("L");
                left = tmp;
            }else if(tmp==3||tmp==6||tmp==9){
                answer.append("R");
                right = tmp;
            }else {
                if(tmp==0) tmp=11;
                int leftdist = Math.abs(tmp-left)/3+Math.abs(tmp-left)%3;
                int rightdist = Math.abs(tmp-right)/3+Math.abs(tmp-right)%3;
                
                if(leftdist<rightdist){
                    answer.append("L");
                    left = tmp;
                }else if(leftdist>rightdist){
                    answer.append("R");
                    right = tmp;
                }else{
                    if(hand.equals("left")){
                        answer.append("L");
                        left = tmp;
                    }else{
                        answer.append("R");
                        right = tmp;
                    }
                }
            }
        }
        return answer.toString();
    }
}