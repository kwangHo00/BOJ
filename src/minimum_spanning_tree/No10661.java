//No10661_Median Tree_정답
package minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No10661 {
    static class NodeInfo implements Comparable<NodeInfo>{
        int a, b, c;
        NodeInfo(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(NodeInfo n){
            return this.c - n.c;
        }
    }

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
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            List<NodeInfo> list = new ArrayList<>();
            List<Integer> answer = new ArrayList<>();
            int cnt = 0;
            int[] parentNode = new int[n + 1];

            for(int i = 0; i <= n; i++) parentNode[i] = i;

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new NodeInfo(a, b, c));
            }

            Collections.sort(list);

            for(NodeInfo node : list){
                if(!find(parentNode, node.a, node.b)){
                    union(parentNode, node.a, node.b);
                    answer.add(node.c);
                    cnt += 1;
                }
            }

            System.out.println(answer.get(cnt / 2));
        }
    }
}