//No21924_도시건설_두번만에 정답_1) totalBudget 타입을 int로 해서 틀림
package minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No21924 {
	static class NodeInfo{
		int a, b, c;
		NodeInfo(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	static int getParent(int[] parent, int n) {
		if(parent[n] == n) return parent[n];
		else return parent[n] = getParent(parent, parent[n]);
	}
	
	static void union(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent < bParent) parent[bParent] = aParent;
		else parent[aParent] = bParent;
	}
	
	static boolean find(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent == bParent) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] parentNode = new int[n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
		}
		
		long totalBudget = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			totalBudget += c;
			list.add(new NodeInfo(a, b, c));
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		for(NodeInfo i : list) {
			if(find(parentNode, i.a, i.b)) continue;
			union(parentNode, i.a, i.b);
			totalBudget -= i.c;
		}
		
		for(int i = 1; i < n; i++) {
			if(!find(parentNode, i, i + 1)) {
				totalBudget = -1;
				break;
			}
		}
		
		System.out.println(totalBudget);
	}
}