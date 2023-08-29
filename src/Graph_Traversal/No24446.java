//No24446_알고리즘수업 - 너비우선탐색3_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No24446 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();
	static boolean[] isVisited;
	static int[] depth;
	
	static void bfs(int n) {
		depth[n] = 0;
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			int listSize = list.get(currN).size();
			
			for(int i = 0; i < listSize; i++) {
				int nextN = list.get(currN).get(i);
				if(!isVisited[nextN]) {
					isVisited[nextN] = true;
					depth[nextN] = depth[currN] + 1;
					queue.add(nextN);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n + 1];
		depth = new int[n + 1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			depth[i] = -1;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		bfs(r);
		
		for(int i = 1; i <= n; i++) {
			System.out.println(depth[i]);
		}
	}
}