package august;

import java.util.*;

public class DFSBFS_1260 {
	static int[][] matrix;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
		int node = scan.nextInt();
		int edge = scan.nextInt();
		int start = scan.nextInt();
		
		matrix = new int[node+1][node+1];
		
		for(int i=1;i<=edge;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		for(int i=1; i<matrix.length;i++) { //Çà·Äº¸±â
			for(int j=1;j<matrix.length;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
        // ±íÀÌ¿ì¼±Å½»ö
		visited = new boolean[node+1];
		dfs(start); 
		
		System.out.println();
        
        // ³Êºñ¿ì¼±Å½»ö
		visited = new boolean[node+1];
		bfs(start); 

		
	}
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start+ " ");
		
		if(start == matrix.length) {
			return;
		}

		for(int a=1;a<matrix.length;a++) {
			if(matrix[start][a] == 1 && visited[a] == false) {
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
			
			int temp = que.peek();
			que.poll();
			for(int i=1; i<matrix.length;i++) {
				if(matrix[temp][i] ==1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
					System.out.print(i+ " ");
				}
			}
		}
	}
	
	
	
}