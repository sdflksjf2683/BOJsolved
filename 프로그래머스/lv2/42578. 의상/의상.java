import java.util.HashMap;

class Solution {
    static int ans = 1;
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
	    
	        
	    //옷 저장 
	    for(String[] cloth: clothes) {
	        map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
	    }
	        
	    // 경우의 수 계산
	    map.forEach((key, val) -> {
	        ans *= (val+1);
	    });
	        
	    return ans-1;
    }
}