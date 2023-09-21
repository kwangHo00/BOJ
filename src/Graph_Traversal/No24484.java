//No24484_알고리즘 수업 - 깊이 우선 탐색 6_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No24484 {
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int[] depthArr, sequenceArr;
    static boolean[] isVisited;
    static int sequence = 1;

    static void dfs(int r){
        isVisited[r] = true;
        sequenceArr[r] = sequence++;
        for(Integer next : list.get(r)){
            if(!isVisited[next]){
                depthArr[next] = depthArr[r] + 1;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long answer = 0;

        depthArr = new int[n + 1];
        sequenceArr = new int[n + 1];
        isVisited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
        Arrays.fill(depthArr, -1);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0; i <= n; i++) list.get(i).sort(Collections.reverseOrder());

        depthArr[r] = 0;
        sequenceArr[r] = sequence;
        dfs(r);

        for(int i = 1; i <= n; i++) answer += (long) depthArr[i] * sequenceArr[i];
        System.out.println(answer);
    }
}