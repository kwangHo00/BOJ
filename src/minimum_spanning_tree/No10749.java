//No10749_Superbull_정답
package minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No10749 {
    static class NodeInfo{
        int a, b;
        long c;
        NodeInfo(int a, int b, long c){
            this.a = a;
            this.b = b;
            this.c = c;
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

        int n = Integer.parseInt(br.readLine());

        List<NodeInfo> list = new ArrayList<>();
        int[] node = new int[n];
        int[] parentNode = new int[n];
        long answer = 0;

        for(int i = 0; i < n; i++) {
            node[i] = Integer.parseInt(br.readLine());
            parentNode[i] = i;
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                list.add(new NodeInfo(i, j, node[i] ^ node[j]));
            }
        }

        list.sort((a, b) -> (int) (b.c - a.c));
        for(NodeInfo i : list){
            if(!find(parentNode, i.a, i.b)){
                union(parentNode, i.a, i.b);
                answer += i.c;
            }
        }
        System.out.println(answer);
    }
}