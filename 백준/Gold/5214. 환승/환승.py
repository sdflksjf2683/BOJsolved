import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N,K,M = map(int, input().split())
hyperStation = [[] for _ in range(N+M)]

def bfs():
    q = deque()
    visit = [0 for _ in range(N+M)]

    q.append(0)
    visit[0] = 1
    
    while q:
        tmp = q.popleft()
        if tmp==N-1:
            return visit[tmp]
        
        for next in hyperStation[tmp]:
            if not visit[next]:
                if next >=N:
                    visit[next] = visit[tmp]
                    q.append(next)
                else:
                    visit[next] = visit[tmp]+1
                    q.append(next)
    
    return -1

def main():
    for i in range(M):
        tmp = list(map(int, input().split()))
        for j in range(K):
            hyperStation[tmp[j]-1].append(N+i) 
            hyperStation[N+i].append(tmp[j]-1)
    
    ans = bfs()

    print(ans)


if __name__=="__main__":
    main()