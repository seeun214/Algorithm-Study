import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coin1_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 동전의 종류
		int k = Integer.parseInt(st.nextToken()); // 가치의 합

		int[] coin = new int[n + 1];
		int[] dp = new int[k + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for (int j = coin[i]; j <= k; j++)
				//1원 동전으로 10원까지 만들 수 있는 경우의 수 j = 1
				//2원 동전으로 10원까지 만들 수 있는 경우의 수 j = 2
				//5원 동전으로 10원까지 만들 수 있는 경우의 수 j = 5
	
		}

		System.out.println(dp[k]);
	}

}