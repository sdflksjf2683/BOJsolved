# [Silver I] 회의실 배정 - 1931 

[문제 링크](https://www.acmicpc.net/problem/1931) 

### 성능 요약

메모리: 174152 KB, 시간: 1284 ms

### 분류

그리디 알고리즘(greedy), 정렬(sorting)

### 문제 설명

<p>한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.</p>

### 입력 

 <p>첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 2<sup>31</sup>-1보다 작거나 같은 자연수 또는 0이다.</p>

### 출력 

 <p>첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.</p>

### 풀이
- 각 회의의 시간이 짧을수록 많은 회의를 편성할 수 있다. 그러나 회의의 시작시간으로는 해당 회의가 언제 끝날지 알 수 없고, 때문에 다른 회의를 언제 편성할지도 알 수 없다. 
- 따라서 회의의 종료시간을 기준으로 정렬을 해준 뒤, 다음 시작 시간이 이전 종료시간 "이상"일 경우 카운팅하는 방식 사용(종료시간이 동일한 경우에는 시작시간이 빠른 기준으로 정렬해준다).
