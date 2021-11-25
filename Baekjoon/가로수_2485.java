import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가로수_2485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //심어져 있는 가로수의 수

		int[] trees = new int[N]; //가로수들의 위치
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(br.readLine());
		}

		int gcd = 0;
		for (int i = 0; i < N - 1; i++) {
			int gap = trees[i + 1] - trees[i]; //나무들 간격
			gcd = gcd(gap, gcd);
		}
		//(가로수 끝 위치 - 가로수 첫위치) / 최대공약수  - 심어져있는 가로수의 수 + 1
		System.out.println((trees[N - 1] - trees[0]) / gcd - N + 1);
	}

	/*유클리드 호제법(최대공약수 구하기)
	 * 2개의 자연수(또는 정식) a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면(단, a>b), 
	 * a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
	 * 이 성질에 따라, b를 r로 나눈 나머지 r'를 구하고, 
	 * 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.
	 */
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
