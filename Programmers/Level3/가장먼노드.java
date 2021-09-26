import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(s.solution(n, edge));

	}

}

class Solution {
	public int solution(int n, int[][] edge) {
		boolean[] check = new boolean[n];
		boolean[][] map = new boolean[n][n];
		Queue<Integer> q = new LinkedList<>();
		int qSize = 0;
		
		for (int i = 0; i < edge.length; i++) {
			map[edge[i][0] - 1][edge[i][1] - 1] = true;
			map[edge[i][1] - 1][edge[i][0] - 1] = true;
		}
		q.add(0);
		check[0] = true;

		while (!q.isEmpty()) {
			qSize = q.size();
			System.out.println(qSize);
			for (int i = 0; i < qSize; i++) {
				int temp = q.poll();
				for (int j = 0; j < n; j++) {
					if (check[j] == false && map[j][temp] == true) {
						check[j] = true;
						q.add(j);
					}
				}
			}
		}
		return qSize;
	}
}
