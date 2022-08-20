import sys

N, M = map(int, sys.stdin.readline().split())
ans = []

def backtracking():
    if len(ans) == M:
        print(" ".join(map(str, ans)))
        return
    for i in range(1, N+1):
        if i not in ans:
            ans.append(i)
            backtracking()
            ans.pop() # return으로 돌아오면 이게 실행됨.

backtracking()