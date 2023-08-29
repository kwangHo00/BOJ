//No4650_Jungle Roads_ 두번만에 정답 _ n을 bufferedReader로 받으니까 noSuchElement 에러 뜨는데 왜그런건지는 모르겠음
package Minimum_Spanning_Tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class No4650 {
    static class NodeInfo{
        int a, b, c;
        NodeInfo(int a, int b, int c){
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
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            if(n == 0) break;

            ArrayList<NodeInfo> list = new ArrayList<>();
            int[] parentNode = new int[n];

            for(int i = 0; i < n; i++) parentNode[i] = i;

            for(int i = 0; i < n - 1; i++){
                char v = sc.next().charAt(0);
                int num = sc.nextInt();

                for(int j = 0; j < num; j++){
                    char w = sc.next().charAt(0);
                    int d = sc.nextInt();
                    list.add(new NodeInfo(v - 65, w - 65, d));
                }
            }

            list.sort((a, b) -> a.c - b.c);

            int answer = 0;
            for(NodeInfo node : list){
                if(!find(parentNode, node.a, node.b)){
                    union(parentNode, node.a, node.b);
                    answer += node.c;
                }
            }

            System.out.println(answer);
        }
    }
}