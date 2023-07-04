import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> gem = new HashSet<>();
        
        for(String g: gems)
            gem.add(g);
        
        int len = gems.length;
        int dist = Integer.MAX_VALUE;
        
        int l=0, r=0;
        HashMap<String, Integer> map = new HashMap<>();
        
        while(true) {
            if(gem.size()==map.size()) {
                map.put(gems[l], map.get(gems[l])-1);
                
                if(map.get(gems[l])==0)
                    map.remove(gems[l]);
                l++;
            } else if(r==len) {
                break;
            } else {
                map.put(gems[r], map.getOrDefault(gems[r],0)+1);
                r++;
            }
            
            if(map.size()==gem.size()) {
                if(r-l<dist) {
                    dist = r-l;
                    answer[0] = l+1;
                    answer[1] = r;
                }
            }
        }
        
        
        return answer;
    }
}