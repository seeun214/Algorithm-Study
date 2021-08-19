import java.util.Arrays;

public class 비밀지도 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		System.out.println(Arrays.toString(s.solution(n, arr1, arr2)));
	}
}

class Solution1 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String code = "";
		String mapCode = "";
		
		for(int i = 0; i < n; i++) {
			code = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i])));
			mapCode = code.replaceAll("1", "#");
			mapCode = mapCode.replaceAll("0", " ");
			answer[i] = mapCode;
		}
		return answer;
	}
}



