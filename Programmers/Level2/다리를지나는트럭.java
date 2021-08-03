package week01;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int bl = 100;
		int we = 100;
		int[] tr_we = {10};
		System.out.println(s.solution3(bl,we,tr_we));

	}

}

class Solution {
    public int solution3(int bridge_length, int weight, int[] truck_weights) {
    		Queue<Integer> bridge = new LinkedList<>();
    		Queue<Integer> readyTruck = new LinkedList<>();
    		
            //초기 다리 
            for(int i = 0 ; i < bridge_length ; i++)
            {
                bridge.offer(0);
            }
           
            //대기 트럭
            for(int i = 0; i < truck_weights.length; i++) {
            	readyTruck.offer(truck_weights[i]);
            }
            
            int time = 0;
            int totalWeight = 0;
            while(!bridge.isEmpty()) {
            	totalWeight -= bridge.peek();
            	bridge.poll();
            	if(!readyTruck.isEmpty()) {
            		if((totalWeight + readyTruck.peek()) <= weight) {
            			bridge.offer(readyTruck.peek());
            			totalWeight += readyTruck.peek();
                		readyTruck.poll();
                		
            		}
            		else
            			bridge.offer(0);
            		
            	}
            	else {
            		time += bridge_length;
            		break;
            
            	}
            	time++;
            }
            return time;
    }
}
