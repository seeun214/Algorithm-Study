import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(s.solution(priorities, location));
		
	}

}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities) {
        	pq.offer(p);
        }
       
        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == pq.peek()) {
                    if(i == location){
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}
