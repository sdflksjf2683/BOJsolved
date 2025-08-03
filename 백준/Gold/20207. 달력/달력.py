import sys

input = lambda: sys.stdin.readline().rstrip()

def main():
    N = int(input())
    calendar = [0]*367

    for _ in range(N):
        start, end = map(int, input().split())
        calendar[start]+=1
        calendar[end+1]-=1
    #end input

    max_height, length, ans = 0,0,0
    for idx in range(1, 367):
        calendar[idx] += calendar[idx-1]
        if calendar[idx]==0:
            ans += length*max_height
            max_height = 0
            length = 0
        else:
            max_height = calendar[idx] if max_height<calendar[idx] else max_height
            length+=1
    
    print(ans)

if __name__=="__main__":
    main()