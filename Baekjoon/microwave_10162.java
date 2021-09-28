import java.util.Scanner;

public class microwave_10162 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int[] count = new int[3];
		int temp = time;
		
		
		if(time >= 300) {
			count[0] = time / 300;
			temp = time % 300;
		}
		if(temp >= 60) {
			count[1] = temp / 60;
			temp = temp % 60;
		}
		if(temp >= 10) {
			count[2] = temp / 10;
			temp = temp % 10;
		}
		
		if(temp != 0) {
			System.out.println(-1);
		}
		else {
			for(int c : count) {
				System.out.print(c);
				System.out.print(" ");
			}
		}
	}
}
 