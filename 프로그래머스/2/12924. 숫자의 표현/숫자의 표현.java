class Solution {
    public int solution(int n) {
        
        if(n<=2) return 1;
        
        int ans=0;
        int l=1,r=2,sum=3;
        while(r<=n && l<=r) {
            if(sum==n) {
                ans++;
                sum-=l;
                l++;
            } else if(sum<n) {
                r++;
                sum+=r;
            } else {
                sum-=l;
                l++;
            }
        }
        
        return ans;
    }
}