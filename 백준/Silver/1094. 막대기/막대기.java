import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) { //메인메서드
		Scanner sc = new Scanner(System.in); //입력을 받기 위한 Scanner
			int X = sc.nextInt(); //만들어야 할 막대의 길이(X) 입력받기
			
			Stack<Integer> st = new Stack<>(); //스택 생성
			st.push(64); //처음 막대길이가 64이므로 64 넣기
			int sum = 64; //처음 막대기의 길이의 합은 64이므로 막대의 길이를 나타내는 변수 선언과 동시에 64로 초기화
			
			while(sum!=X) { //모든 막대기의 길이의 합이 목표 길이인 X와 같아질 때까지 반복
				int temp = st.pop()/2; //막대기를 하나 꺼내서 반으로 자르기
				st.push(temp); //자른 막대기 중 하나는 무조건 스택에 저장
				if(sum-temp<X) { //만약 자른 막대기 하나를 뺀 길이의 총합이 목표 길이보다 작을 경우에는 막대기를 버리지 않는다.
					st.push(temp); //버리지 않기 때문에 자른 막대기를 다시 스택에 저장
					continue; //자른 두 막대기를 모두 버리지 않으므로 막대기 길이의 총합에는 변동 없음.
				}
				sum -= temp; //막대기를 하나만 저장했을 경우, 막대기 길이의 총합을 갱신한다.
			}
			System.out.println(st.size()); //테스트케이스 번호와 함께 현재 막대기의 개수를 출력한다. 
	}
}