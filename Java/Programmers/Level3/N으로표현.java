public class N으로표현 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.solution(5, 12));
	}

}

class Solution1 {
    public int answer = -1;
    public void dfs(int n , int num, int cnt, int value){
        if(cnt > 8)
            return;
        if(num == value){
            if(answer > cnt || answer == -1)
                answer = cnt;
            return;
        }
        
        int nn = 0;
        for(int i = 0; i < 8; i++){
            nn = nn * 10 + n;
            dfs(n, num, cnt + 1 + i, value + nn);
            dfs(n, num, cnt + 1 + i, value - nn);
            dfs(n, num, cnt + 1 + i, value * nn);
            dfs(n, num, cnt + 1 + i, value / nn);
        }
    }
    
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
}