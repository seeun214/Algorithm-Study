import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println(s.solution(scoville, K));

	}

}

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> sco = new PriorityQueue<>();
		
		for(Integer s : scoville) {
			sco.offer(s);
		}
		
		while(sco.peek() <= K) {
			if(sco.size() == 1)
				return -1;
			if(sco.peek() <= K) {
				sco.offer(sco.poll() + (sco.poll() * 2));
				answer++;
			}
		}
		return answer;
	}
}
