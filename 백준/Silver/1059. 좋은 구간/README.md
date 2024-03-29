# [Silver V] 좋은 구간 - 1059 

[문제 링크](https://www.acmicpc.net/problem/1059) 

### 성능 요약

메모리: 17880 KB, 시간: 212 ms

### 분류

브루트포스 알고리즘(bruteforcing), 수학(math), 정렬(sorting)

### 문제 설명

<p>정수 집합 S가 주어졌을때, 다음 조건을 만족하는 구간 [A, B]를 좋은 구간이라고 한다.</p>

<ul>
	<li>A와 B는 양의 정수이고, A < B를 만족한다.</li>
	<li>A ≤ x ≤ B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다.</li>
</ul>

<p>집합 S와 n이 주어졌을 때, n을 포함하는 좋은 구간의 개수를 구해보자.</p>

### 입력 

 <p>첫째 줄에 집합 S의 크기 L이 주어진다. 둘째 줄에는 집합에 포함된 정수가 주어진다. 셋째 줄에는 n이 주어진다.</p>

### 출력 

 <p>첫째 줄에 n을 포함하는 좋은 구간의 개수를 출력한다.</p>

### 풀이

<img src="https://user-images.githubusercontent.com/78345851/182087050-bfa3b888-40c3-4354-9872-b1ffa9e66d4b.jpeg" width="800" height="300">

<p>n이 집합 안에 없을 경우를 고려하지 않아 코드를 여러 번 수정했다. 또한 A와 B를 지정한 후, A와 B 역시 집합 S에 포함되면 안되기 때문에 범위를 한 칸 좁혀줘야 했는데, 이 부분을 캐치하지 못해서 디버깅을 하는데에 시간이 조금 걸렸다. 문제를 꼼꼼히 읽고 조건을 잘 체크하는 연습이 필요함.</p>
