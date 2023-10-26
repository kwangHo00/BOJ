//No5938 _ Daisy Chains in the Field _ 정답
package Disjoint_Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class No5938 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> ans = new LinkedList<>();

        int[] parentNode = new int[n + 1];
        for(int i = 1; i <= n; i++) parentNode[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(parentNode, a, b);
        }

        for(int i = 1; i <= n; i++){
            if(getParent(parentNode, i) != 1) ans.add(i);
        }

        if(ans.isEmpty()) System.out.println(0);
        else for(Integer i : ans) System.out.println(i);
    }
}