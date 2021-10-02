import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] operations = {"I 7","I 5","I -5","D -1"};
		for(int a : s.solution(operations)) {
			System.out.print(a);			
		}
	}
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
        	StringTokenizer st = new StringTokenizer(op);
        	String judge = st.nextToken();
        	int num = Integer.parseInt(st.nextToken());
        	
        	if(pq.size() < 1 && judge.equals("D"))
        		continue;
        	
        	if(judge.equals("I")) {
        		pq.offer(num);
        		maxPq.offer(num);
        		continue;
        	}
        	
        	if(num < 0) {
        		int min = pq.poll();
        		maxPq.remove(min);
        		continue;
        	}
        	
        	int max = maxPq.poll();
        	pq.remove(max);
        }
        if(pq.size()>0) {
        	answer[0] = maxPq.peek();
        	answer[1] = pq.peek();
        }
        return answer;
    }
}