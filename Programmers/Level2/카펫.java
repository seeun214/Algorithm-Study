public class 카펫 {

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		int brown = 18;
		int yellow =6;
		for(int a : s.solution(brown, yellow)) {
			System.out.println(a);
		}
	}

}

class Solution4 {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
 
        //전체 격자
        int carpet = brown + yellow;
        
        //row * col = carpet
        for (int i = 1; i <= carpet; i++) {
            int row = i;
            int col = carpet / row; 
 
            if (row > col)
                continue;
            
            //테두리 제외했을 경우
            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                System.out.println(answer[0]);
                System.out.println(answer[1]);
            }
        }
        return answer;
	   }
}
