import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    T = int(input())
    for _ in range(T):
        K = int(input())
        files = [0]+list(map(int, input().split()))

        #파일 크기의 누적합
        prefix = [0]*(K+1)
        for k in range(1, K+1):
            prefix[k] = prefix[k-1]+files[k]

        dp = list([0]*(K+1) for _ in range(K+1)) #dp[i][j] = i~j까지 합치는 비용(최소)

        for length in range(1, K): 
            for i in range(1, K-length+1):
                j = i+length
                min_sum = 1e9

                for k in range(i, j):
                    min_sum = min(min_sum, dp[i][k]+dp[k+1][j])

                dp[i][j] = min_sum+prefix[j]-prefix[i-1]

        print(dp[1][K])



if __name__=="__main__":
    main()