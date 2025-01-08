import java.util.Scanner;

public class 파도반수열_9461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long p[] = new long[101];

		p[1] = 1;
		p[2] = 1;
		p[3] = 1;


		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			if (N <= 3) {
				System.out.println(p[N]);
			} else {
				for (int j = 4; j <= N; j++) {
					p[j] = p[j - 2] + p[j - 3];
				}
				System.out.println(p[N]);
			}
		}
	}
}
