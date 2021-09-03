import java.util.ArrayList;
import java.util.Stack;

public class Å¸°Ù³Ñ¹ö {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(s.solution(numbers, target));
	}
}

class Solution {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		int stackNum = 0;
		int	nextNum = 0;
		
		ArrayList<Integer> sumList;
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(numbers[0]);
		stack.push(numbers[0]*-1);
		
		for (int i = 1; i < numbers.length; i++) {
			nextNum = numbers[i];
			sumList = new ArrayList<Integer>();
				
			while(!stack.isEmpty()) {
				stackNum = stack.pop();
					
				sumList.add(stackNum+nextNum);
				sumList.add(stackNum+(nextNum*-1));
			}
				
			for (int j = 0; j < sumList.size(); j++) {
				stack.push(sumList.get(j));
			}
		} 
	    	
	    for (Integer sum : stack) {
	    	if(sum == target)
	    		answer++;
		}
	    return answer;
	}
}