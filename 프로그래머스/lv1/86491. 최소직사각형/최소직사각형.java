class Solution {
    public int solution(int[][] sizes) {
        
        int mwidth=0, mheight=0;
        for(int i=0,size=sizes.length;i<size;i++) {
            if(sizes[i][0]>=sizes[i][1]) {
                if(mwidth<sizes[i][0])
                    mwidth = sizes[i][0];
                if(mheight<sizes[i][1])
                    mheight = sizes[i][1];
            } else {
                if(mheight<sizes[i][0])
                    mheight = sizes[i][0];
                if(mwidth<sizes[i][1])
                    mwidth = sizes[i][1];
            }
        }
        
        int answer = mwidth*mheight;
        
        return answer;
    }
}