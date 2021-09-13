import java.util.*;

public class 괄호변환 {
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		String p = ")(";
		System.out.println(s.solution(p));

	}
} 

class Solution5 {
	int pos;
	boolean isCorrect(String str) {
		boolean ret = true;
		int left = 0, right = 0;
		Stack<Character> mystack = new Stack<Character>();

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '(') {
				left++;
				mystack.push('(');
			} else {
				right++;
				if (mystack.empty())
					ret = false;
				else
					mystack.pop();
			}
			// u의 길이, v의 시작위치
			if (left == right) {
				pos = i + 1;
				return ret;
			}
		}
		return true;
	}

	public String solution(String p) {
		if (p.isEmpty())
			return p;

		boolean correct = isCorrect(p);
		String u = p.substring(0, pos);
		String v = p.substring(pos, p.length());

		if (correct) {
			return u + solution(v);
		}
		
		String answer = "(" + solution(v) + ")";
		for(int i = 1; i < u.length()-1; ++i) {
			if(u.charAt(i) == '(')
				answer += ")";
			else
				answer += "(";
		}
		return answer;

	}
}