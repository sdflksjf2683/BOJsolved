import sys

input = sys.stdin.readline

N,K = map(int, input().split())

dp = [[[[0 for _ in range(436)] for _ in range(31)] for _ in range(31)] for _ in range(31)]

ans = [0]*31

def isPossible(idx, a, b, cnt):
    if idx==N:
        if cnt==K:
            return True
        return False
    
    if dp[idx][a][b][cnt]:
        return False

    dp[idx][a][b][cnt] = True
    
    ans[idx] = 'A'
    if isPossible(idx+1, a+1, b, cnt):
        return True
    
    ans[idx] = 'B'
    if isPossible(idx+1, a, b+1, cnt+a):
        return True
    
    ans[idx] = 'C'
    if isPossible(idx+1, a, b, cnt+a+b):
        return True
    
    return False


if isPossible(0,0,0,0):
    print(''.join(ans[0:N]))
else:
    print(-1)