package august;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class cardNum2_10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] card = br.readLine().split(" ");
		Map<Integer, Integer> cardCount = new HashMap<>();
		
		for(int i = 0; i < N; i++ ) {
			int num = Integer.parseInt(card[i]);
			if(cardCount.containsKey(num)) {
				cardCount.replace(num, cardCount.get(num) + 1);
			}
			else {
				cardCount.put(num, 1);
			}
		System.out.println(cardCount);
		}
		
		StringBuilder answer = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		String[] card2 = br.readLine().split(" ");
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(card2[i]);
			if(cardCount.containsKey(num) ) {
				answer.append(cardCount.get(num));
			}
			else {
				answer.append(0);
			}
			if(i < M-1) {
				answer.append(" ");
			}
		}
		System.out.println(answer);
	}
}


