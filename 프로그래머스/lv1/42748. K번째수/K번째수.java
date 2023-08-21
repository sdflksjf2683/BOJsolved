import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        
        for(int i=0;i<commands.length;i++) {
        	int[] test = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(test);
        	answer[i] = test[commands[i][2]-1];
        }
        return answer;
    }
}