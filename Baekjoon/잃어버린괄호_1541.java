import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int sum = Integer.MAX_VALUE;
		String[] numbers = br.readLine().split("-");
		
 
		for(int i = 0; i < numbers.length; i++) {
			int temp = 0;
 
			//뺄샘으로 나눠진 값들을 하나하나 배열에 저장
			String[] addition = numbers[i].split("\\+");
			
			//하나하나 배열에 저장된 값들을 더해주기
			for(int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			//첫번째 값
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}

}
