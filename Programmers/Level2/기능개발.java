import java.util.Stack;

public class 기능개발 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		s.solution(progresses, speeds);
	}
}

class Solution {
    public void solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        Stack<Integer> stack = new Stack<Integer>();
       
        for(int i =0; i < progresses.length; i++) {
        	day[i]=(int) Math.ceil((double)(100-progresses[i])/speeds[i]);
        }
       
        stack.push(0);
        for(int i =1 ; i < day.length; i++) {
	        if(day[i] > day[stack.peek()]) {
	        	stack.push(i);
	        }
        }
        
       int[] answer = new int[stack.size()];
       for (int i = stack.size() - 1; i >= 0 ; i--) {
    	   if(i == stack.size() -1 ) {
    		   answer[i] = day.length - stack.elementAt(i);
    	   }
    	   else {
    		   answer[i] = stack.elementAt(i+1) - stack.elementAt(i);	
    	   }	   
       }
        for(int i = 0; i < answer.length; i++) {
        	System.out.println(answer[i]);
        }
    }
}