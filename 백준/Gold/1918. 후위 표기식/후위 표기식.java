import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int check(char c) {
		if(c=='/' || c=='*') return 2;
		else if(c=='+' || c=='-') return 1;
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(char c: str) {
			if(c>='A' && c<='Z') 
				sb.append(c);
			else if(c=='(') 
				stack.push(c);
			else if(c==')') {
				while(!stack.isEmpty()) {
					char temp = stack.pop();
					if(temp=='(') break;
					sb.append(temp);
				}
			}
			else {
				while(!stack.isEmpty() && check(stack.peek())>=check(c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
 		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		System.out.println(sb.toString());
	}
}