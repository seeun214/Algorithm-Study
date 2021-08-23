import java.util.HashMap;

public class 전화번호목록 {
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		String[] phone_book = {"152","1234","1235","567","88"};
		System.out.println(s.solution(phone_book));
	}
}

class Solution3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> phoneBook = new HashMap<>();
        for(String num : phone_book) 
        	phoneBook.put(num, 1);
        for (String num : phoneBook.keySet()) {
        	for (int i = 1; i < num.length(); i++) {
       			if (phoneBook.containsKey(num.substring(0, i))) 
       				answer = false;
        	}
        }
        return answer;
    }
}