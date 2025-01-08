import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class plus_9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		int[] nums = new int[11]; 
		nums[1] = 1; //1
		nums[2] = 2; //1+1, 2
		nums[3] = 4; //1+1+1, 1+2, 2+1, 3
	
		/*
		 * 5일때
		 * 1+4 - 7
		 * 2+3 - 4
		 * 3+2 - 2
		 */
		
		for (int i = 0; i < testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			for (int j = 4; j <= n; j++) {
				nums[j] = nums[j - 1] + nums[j - 2] + nums[j - 3];
			}
			System.out.println(nums[n]);
		}

	}

}
