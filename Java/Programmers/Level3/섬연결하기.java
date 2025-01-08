import java.util.Arrays;

public class 섬연결하기 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		System.out.println(s.solution(n, costs));
	}

}

class Solution1 {
	public int solution(int n, int[][] costs) {
		int sum = 0;
		int[] island = new int[n];

		for (int i = 0; i < n; i++)
			island[i] = i;

		// x가 y보다 크면 1, 작으면 -1, 동일하면 0
		// 람다식이 -1을 반환하면  a, b 순으로 정렬, 1을 반환하면 b, a 순으로 정렬
		// 1 1 2 5 8
		Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
//		for(int i = 0; i < costs.length; i++) {
//			for(int j = 0; j <3 ; j++) {
//				System.out.print(costs[i][j]);
//			}
//			System.out.println();
//		}
		

		for (int i = 0; i < costs.length; i++) {
			if (find(island, costs[i][0]) != find(island, costs[i][1])) {
				unite(island, costs[i][0], costs[i][1]);
				sum += costs[i][2];
			}
		}

		return sum;
	}

	private int find(int[] island, int x) {
		if (island[x] == x)
			return x;
		return find(island, island[x]);
	}

	private void unite(int[] island, int x, int y) {
		int a = find(island, x);
		int b = find(island, y);
		island[a] = b;
	}
}