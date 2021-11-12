import java.util.Arrays;

public class hIndex {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] citations = {2, 2, 6, 1, 5};
		System.out.println(s.solution(citations));
 
	}

}

class Solution2 {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);

        for(int i = 0; i < len; i++) {
        	if(citations[i] >= len - i) {
                answer = len - i;
                break;
        	}
        }

        return answer;
    }
}
// 1 2 2 5 6
// 1 5
// 2 4
// 2 3
// 5 2
// 6 1

