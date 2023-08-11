function solution(numbers, target) {
    var answer = 0;
    dfs(0,0);
    return answer;
    
    function dfs(count, sum) {
        if (count === numbers.length) {
            if (sum === target) {
                answer++;
            }
            return;
        }
        
        dfs(count+1, sum+numbers[count]);
        dfs(count+1, sum-numbers[count]);
    }
    
}