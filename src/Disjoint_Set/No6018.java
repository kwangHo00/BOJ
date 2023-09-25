//No6018_Tea Time_정답
package Disjoint_Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6018 {
    static int getParent(int[] parent, int n){
        if(parent[n] == n) return parent[n];
        else return parent[n] = getParent(parent, parent[n]);
    }

    static void union(int[] parent, int a, int b){
        int aParent = getParent(parent, a);
        int bParent = getParent(parent, b);
        if(aParent < bParent) parent[bParent] = aParent;
        else parent[aParent] = bParent;
    }

    static boolean find(int[] parent, int a, int b){
        int aParent = getParent(parent, a);
        int bParent = getParent(parent, b);
        return aParent == bParent;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] parentNode = new int[n + 1];
        for(int i = 0; i <= n; i++) parentNode[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!find(parentNode, a, b)) union(parentNode, a, b);
        }

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(parentNode, a, b)) sb.append("Y").append("\n");
            if(!find(parentNode, a, b)) sb.append("N").append("\n");
        }

        System.out.println(sb);
    }
}