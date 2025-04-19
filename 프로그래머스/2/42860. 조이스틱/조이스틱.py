def solution(name):
    answer = 0
    length = len(name)
    
    #알파벳 바꾸는데 드는 최소 횟수 계산
    for ch in name:
        answer += min(ord(ch)-ord('A'), ord('Z')-ord(ch)+1)
    
    #이동 최솟값 = 한방향 직진
    move = length-1
    
    #돌아가는 경우 계산
    for i in range(length):
        next = i+1
        
        #여러 개 붙어있는 A 찾기
        while next<length and name[next]=='A':
            next += 1
        
        #뒤로 돌아갈 경우 계산
        dist = i + length - next + min(i, length-next)
        move = min(move, dist)
    
    return answer+move