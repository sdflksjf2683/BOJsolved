class Solution {
    public long solution(int price, int money, int count) {
        long sum=0;
        while(count>=1){
            sum += price*count;
            count--;
        }
        return sum>=money?sum-money:0;
    }
}