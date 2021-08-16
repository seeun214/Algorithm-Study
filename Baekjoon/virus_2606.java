package august;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class virus_2606 {
	static int[][] matrix;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int node = scan.nextInt();
		int edge = scan.nextInt();
		
		matrix = new int[node+1][node+1];
		
		for(int i = 0; i < edge; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			matrix[x][y] = matrix[y][x] = 1;
		}
		visited = new boolean[node+1];
		bfs(1);
	}

	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int check = que.peek();
			que.poll();
			for(int i = 1; i < matrix.length; i++) {
				if(matrix[check][i] == 1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
