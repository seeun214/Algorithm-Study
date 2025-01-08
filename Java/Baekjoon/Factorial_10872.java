import java.util.Scanner;

public class Factorial_10872 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Num = scan.nextInt();
		
		System.out.println(factorial(Num));
	}

	private static int factorial(int num) {
		if(num == 0)
			return 1;
		return num * factorial(num-1);
	}
}
