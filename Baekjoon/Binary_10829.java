import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Binary_10829 {

//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		long N = scan.nextLong();
//		int mod = 0;
//		Stack<Integer> answer = new Stack<>();
//		
//		for(long i = N; i > 0; i /= 2) {
//			answer.add((int)(i % 2));
//		}
//		
//		while(!answer.isEmpty()) {
//			System.out.print(answer.pop());
//		}
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		long N = Long.parseLong(temp);
		int mod = 0;
		Stack<Integer> answer = new Stack<>();
		
		for(long i = N; i > 0; i /= 2) {
			answer.add((int)(i % 2));
		}
		
		while(!answer.isEmpty()) {
			System.out.print(answer.pop());
		}
	}
}
