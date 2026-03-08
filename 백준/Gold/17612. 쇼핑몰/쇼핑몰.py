import sys, heapq

input = lambda:sys.stdin.readline().rstrip()

def main():
    N,K = map(int, input().split())
    ans = 0
    cashier = []
    finished = []

    for i in range(N):
        customer, stock = map(int, input().split())
        if len(cashier)<K: #계산대 자리 남은 경우
            heapq.heappush(cashier, [stock, (i+1), customer])
        else:
            time, tmpch, outcustm = heapq.heappop(cashier)
            heapq.heappush(cashier, [stock+time, tmpch, customer])
            heapq.heappush(finished, [time, -tmpch, outcustm])
    
    while cashier:
        time, tmpch, outcustm = heapq.heappop(cashier)
        heapq.heappush(finished, [time, -tmpch, outcustm])
    
    for j in range(N):
        tmp = heapq.heappop(finished)
        ans += tmp[2]*(j+1)
    
    print(ans)


if __name__=="__main__":
    main()