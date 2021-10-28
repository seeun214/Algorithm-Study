import java.util.Scanner;

public class TaekwonKing_14562 {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int caseNum = sc.nextInt();
	        int[] S = new int[caseNum];
	        int[] T = new int[caseNum];
	        for (int i = 0; i < caseNum; i++) {
	            S[i] = sc.nextInt();
	            T[i] = sc.nextInt();
	        }

	        for (int i = 0; i < caseNum; i++) {
	            int min = kick(S[i], T[i], 0);
	            System.out.println(min);
	        }
	    }

	    public static int kick(int S, int T, int count) {
	        if (S > T) {
	            return 100;
	        }
	        if (S == T) {
	            return count;
	        } else {
	            int min1 = kick(S * 2, T + 3, count + 1);
	            int min2 = kick(S + 1, T, count + 1);
	            return Math.min(min1, min2);
	        }
	    }
}
