import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {
		Solution5 s = new Solution5();
		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
	
		System.out.println(s.solution(n, lost, reserve));
	}

}

class Solution5 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                	answer += 1;
                	lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(reserve[j] - 1 == lost[i] || reserve[j] + 1 == lost[i]) {
        			answer += 1;
        			reserve[j] = -1;
        			break; 
        		}
        	}
        }
        return answer;
    }
}
