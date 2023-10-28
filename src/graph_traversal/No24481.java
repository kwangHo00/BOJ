//No24481_알고리즘 수업 - 깊이 우선 탐색 3_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No24481 {
	static int[] depth;
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	static void dfs(int r) {
		isVisited[r] = true;
		int listSize = list.get(r).size();
		for(int i = 0; i < listSize; i++) {
			int nextR = list.get(r).get(i);
			if(!isVisited[nextR]) {
				depth[nextR] = depth[r] + 1;
				dfs(nextR);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		depth = new int[n + 1];
		isVisited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			depth[i] = -1;
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}
		
		depth[r] = 0;
		dfs(r);
		
		for(int i = 1; i <=n; i++) {
			System.out.println(depth[i]);
		}
	}
}