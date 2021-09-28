import java.util.Arrays;

public class 구명보트 {

	public static void main(String[] args) {
		Solution7 s = new Solution7();
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println(s.solution(people, limit));
	}

}

class Solution7 {
	public int solution(int[] people, int limit) {
		int peopleNum = people.length;
		int answer = 0;
		Arrays.sort(people);
		
		for (int i = 0; i < peopleNum; i++) {
			while (i < peopleNum - 1 && people[i] + people[--peopleNum] > limit) {
				answer++;
			}
			answer++;
		}
		return answer;
	}
}