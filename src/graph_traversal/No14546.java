//No14546_Prison Break_4번만에 정답_오랜만에 하니까 감 잃어버림
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14546 {
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static void bfs(int l, int w, int a, int b){
        char hut = map[w - b][a - 1];

        isVisited[w - b][a - 1] = true;
        queue.add(new Pair(w - b, a - 1));

        while(!queue.isEmpty()){
            int nowRow = queue.peek().row;
            int nowCol = queue.peek().col;
            queue.poll();

            for(int i = 0; i < 4; i++){
                int nextRow = nowRow + upDown[i];
                int nextCol = nowCol + leftRight[i];
                if(nextRow < 0 || nextRow > w - 1 || nextCol < 0 || nextCol > l - 1) continue;
                if(map[nextRow][nextCol] == hut && !isVisited[nextRow][nextCol]){
                    isVisited[nextRow][nextCol] = true;
                    queue.add(new Pair(nextRow, nextCol));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int L, W, A, B, C, D;

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            map = new char[W][L];
            isVisited = new boolean[W][L];
            for(int j = 0; j < W; j++) map[j] = br.readLine().toCharArray();
            bfs(L, W, A, B);
            System.out.println(isVisited[W - D][C - 1] ? "YES" : "NO");
        }
    }
}