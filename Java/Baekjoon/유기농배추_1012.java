import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

	static int M, N, K;
	static int[][] cabbage;
	static boolean[][] visit;
	static int count;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스의 개수 T
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {  
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//배추밭 가로길이
			M = Integer.parseInt(st.nextToken());
			//배추밭 세로길이
			N = Integer.parseInt(st.nextToken());
			cabbage = new int[M][N];
			visit = new boolean[M][N];
			
			//배추가 심어져 있는 위치의 개수
			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int k1 = Integer.parseInt(st.nextToken());
				int k2 = Integer.parseInt(st.nextToken());
				cabbage[k1][k2] = 1;
			}

			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (cabbage[x][y] == 1 && !visit[x][y]) {
						dfs(x, y);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		//상하좌우 배추 제거?
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
					dfs(cx, cy);
				}
			}
		}
	}
}
