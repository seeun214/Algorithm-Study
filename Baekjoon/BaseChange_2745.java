import java.util.Scanner;

public class BaseChange_2745 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int answer = 0;
		String N = scan.next();
		int B = scan.nextInt();
		
		for(int i = 0; i < N.length(); i++) {
			if(N.charAt(i) >= '0' && N.charAt(i) <= '9') 
				answer += (N.charAt(i)-'0') * Math.pow(B, (N.length()-i-1));
			else 
				answer += (N.charAt(i)-'A' + 10) * Math.pow(B, (N.length()-i-1));
		}
		System.out.println(answer);
	}
}