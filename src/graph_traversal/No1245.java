//No1245_농장 관리_두번만에 정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1245 {
    static int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    static boolean isPeak(int n, int m, int row, int col){
        int startWith = map[row][col];
        boolean isPeak = true;

        isVisited[row][col] = true;
        queue.add(new Pair(row, col));

        while(!queue.isEmpty()){
            int nowRow = queue.peek().row;
            int nowCol = queue.peek().col;
            queue.poll();

            for(int i = 0; i < 8; i++){
                int nextRow = nowRow + upDown[i];
                int nextCol = nowCol + leftRight[i];
                if(nextRow < 0 || nextRow > n - 1 || nextCol < 0 || nextCol > m - 1) continue;
                if(map[nowRow][nowCol] < map[nextRow][nextCol]) isPeak =  false;
                if(map[nextRow][nextCol] == startWith && !isVisited[nextRow][nextCol]){
                    isVisited[nextRow][nextCol] = true;
                    queue.add(new Pair(nextRow, nextCol));
                }
            }
        }
        return isPeak;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0 || isVisited[i][j]) continue;
                if(isPeak(n, m, i, j)) answer += 1;
            }
        }

        System.out.println(answer);
    }
}