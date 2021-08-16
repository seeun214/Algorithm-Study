import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSBFS_1260 {
	static int[][] matrix;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
		int node = scan.nextInt();
		int edge = scan.nextInt();
		int start = scan.nextInt();
		
		matrix = new int[node+1][node+1];
		
		for(int i = 0; i < edge; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			matrix[x][y] = matrix[y][x] = 1;
		}
	
		visited = new boolean[node+1];
		dfs(start); 
		
		System.out.println();
        
		visited = new boolean[node+1];
		bfs(start);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		int count = 1;
		System.out.print(start+ " ");
		
		if(count == matrix.length - 1) 
			return;
		
		for(int a = 1; a < matrix.length; a++) {
			if(matrix[start][a] == 1 && visited[a] == false){
				count++;
				dfs(a);
			
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>(); 
		
		que.add(start);
		visited[start] = true;
 		System.out.print(start+ " ");
		
		while(!que.isEmpty()) {
			int check = que.peek();
			que.poll();
			for(int i = 1; i < matrix.length; i++) {
				if(matrix[check][i] == 1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
					System.out.print(i+ " ");
				}
			}
		}
	}
}