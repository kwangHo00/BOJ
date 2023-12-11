//No6188_Clear Cold Water_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No6188 {
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dist;
    static boolean[] isVisited;

    static void bfs(int n){
        isVisited[n] = true;
        dist[n] = 1;
        queue.add(n);

        while(!queue.isEmpty()){
            int currN = queue.poll();
            for(int nextN : list.get(currN)){
                if(!isVisited[nextN]){
                    isVisited[nextN] = true;
                    dist[nextN] = dist[currN] + 1;
                    queue.add(nextN);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());



        dist = new int[n + 1];
        isVisited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for(int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.get(p).add(q); list.get(q).add(p);
            list.get(p).add(r); list.get(r).add(p);
        }

        bfs(1);
        for(int i = 1; i <= n; i++) System.out.println(dist[i]);
    }
}