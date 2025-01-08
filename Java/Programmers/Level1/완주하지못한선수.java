import java.util.HashMap;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(s.solution(participant, completion));
	}
}
	
class Solution { 
	public String solution(String[] participant, String[] completion) { 
		String answer = ""; 
		HashMap<String, Integer> players = new HashMap<>(); 
		for(String player : participant) 
			players.put(player, players.getOrDefault(player, 0) + 1); 
		for(String player : completion) 
			players.put(player, players.get(player) - 1); 
		for(String key : players.keySet()){ 
			if (players.get(key) != 0) {
				answer = key; 
				break; 
			}
		} 
		return answer; 
	} 
}