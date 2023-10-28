//No17204_죽음의 게임_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17204 {
    static int[] num, sequenceArr;
    static boolean[] isVisited;
    static int sequence = 0;

    static void dfs(int n, int[] num){
        isVisited[n] = true;
        sequenceArr[n] = sequence++;
        if(!isVisited[num[n]]) dfs(num[n], num);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        num = new int[n];
        sequenceArr = new int[n];
        isVisited = new boolean[n];

        for(int i = 0; i < n; i++) num[i] = Integer.parseInt(br.readLine());
        dfs(0, num);

        System.out.println(sequenceArr[m] == 0 ? -1 : sequenceArr[m]);
    }
}