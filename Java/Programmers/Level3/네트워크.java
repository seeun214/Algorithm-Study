import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(s.solution(n, computers));

	}

}

class Solution3 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n]; 

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfs(computers, i, visited);
				answer++;
			}
		}

		return answer;
	}

	void dfs(int[][] computers, int i, boolean[] visited) {
		visited[i] = true;

		for (int j = 0; j < computers.length; j++) {
			if (computers[i][j] == 1 && visited[j] == false) {
				dfs(computers, j, visited);
			}
		}
	}
	
	void bfs(int[][] computers, int i, boolean[] visited) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(i);
		visited[i] = true;

		while(!que.isEmpty()) {
			int check = que.poll();
			for(int j = 1; j < computers.length; j++) {
				if(computers[check][j] == 1 && visited[j] == false) {
					que.add(j);
					visited[j] = true;
				}
			}
		}
	}
}
