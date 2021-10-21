package month3;

public class 조이스틱 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String name = "JEROEN";
		System.out.println(s.solution(name));

	}
}

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        int minMove = len-1;
        
        for(int i = 0; i < len; i++) {
        	if(name.charAt(i) > 'M') {
        		answer += 'Z' - name.charAt(i) + 1;
        	}else {
        		answer += name.charAt(i) - 'A';
        	}
        	
        	int next = i + 1;
        	while(next < len && name.charAt(next) == 'A')
        		next++;
        	
        	minMove = Math.min(minMove, i + len-next + i);
        }
        
        answer += minMove;        
        return answer;
    }
}