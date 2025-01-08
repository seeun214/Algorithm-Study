import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
	
public class 사냥꾼_8983 {

	static int M, N, L; // 사대의수, 동물의수, 사정거리
	static int gunLocation[];
	static int animalLocation[][];
	static int animalCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		gunLocation = new int[M];
		animalLocation = new int[N][2];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			gunLocation[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(gunLocation);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			animalLocation[i][0] = Integer.parseInt(st.nextToken()); //x좌표값
			animalLocation[i][1] = Integer.parseInt(st.nextToken()); //y좌표값
		}
		
		//동물 - x축이 작은 순으로 정렬
		Arrays.sort(animalLocation, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		int gunIndex = 0;

		for (int i = 0; i < animalLocation.length; i++) {
			if (animalLocation[i][1] > L)
				continue;
			//맨 끝 사대의 위치 + 사정거리
			if (animalLocation[i][0] > gunLocation[M - 1] + L)
				break;
			
			//한 사대에서 사정거리가 초과하는 동물이 나오면 gunIndex를 수정해줌(다음 사대로 넘어감)
			for (int j = gunIndex; j < M; j++) {
				int distance = Math.abs(gunLocation[j] - animalLocation[i][0]) + animalLocation[i][1];

				if (distance <= L) {
					gunIndex = j;
					animalCount++;
					break;
				}
				if (animalLocation[i][0] < gunLocation[j])
					break;
			}

		}

		System.out.println(animalCount);

	}
}
