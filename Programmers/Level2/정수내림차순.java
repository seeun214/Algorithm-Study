import java.util.Arrays;

public class 정수내림차순 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		long n = 118372;
		System.out.println(s.solution(n));
	}

}

class Solution1 {
	public long solution(long n) {
		String num = String.valueOf(n);
		String ansnum = "";
		char[] arr = new char[num.length()];
		for (int i = 0; i < num.length(); i++) {
			arr[i] += num.charAt(i);
		}

		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			ansnum += arr[i];
		}

		long answer = Long.parseLong(ansnum);
		return answer;
	}
}
