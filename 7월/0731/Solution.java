
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] postfix;
		int N;
		String formula;
		Stack<Character> fourOp = new Stack<Character>();
		Stack<Integer> stack = new Stack<Integer>();
		char e;
		int cnt, num1, num2, element;
		
		for(int Ti = 1; Ti <= 10; Ti++) {
			N = Integer.parseInt(br.readLine());
			postfix = new char[N];
			formula = br.readLine();
			cnt = 0;
			for(int i = 0; i < N; i++) {
				e = formula.charAt(i);
				if(e == '+' || e == '-') {
					if(fourOp.isEmpty()) 
						fourOp.push(e);
					else if(fourOp.peek() == '+' || fourOp.peek() == '-') { 
						postfix[cnt++] = fourOp.pop();
						fourOp.push(e);
					}
					else {
						postfix[cnt++] = fourOp.pop();
						i--;
					}
					
				} else if (e == '*' || e == '/') {
					if(fourOp.isEmpty()) 
						fourOp.push(e);
					else if(fourOp.peek() == '+' || fourOp.peek() == '-') { 
						fourOp.push(e);
					}
					else {
						postfix[cnt++] = fourOp.pop();
						fourOp.push(e);
					}
				} else {
					postfix[cnt++] = e;
				}
			}
			
			while(!fourOp.isEmpty()) {
				postfix[cnt++] = fourOp.pop();
			}
			for(int i = 0; i < N; i++) {
				element = postfix[i];
				if(element == '+' || element == '-' || element == '*' || element == '/') {
					num2 = stack.pop();
					num1 = stack.pop();
					switch(element) {
					case '+':
						stack.push(num1 + num2);
						break;
					case '-':
						stack.push(num1 - num2);
						break;
					case '*':
						stack.push(num1 * num2);
						break;
					case '/':
						stack.push(num1 / num2);
						break;
					}
				} else {
					stack.push(postfix[i] - '0');
				}
			}
			System.out.println("#"+Ti+" "+stack.pop());
		}
	}
}