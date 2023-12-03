//No6067_Guarding the Farm_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No6067 {
    static int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1}, leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();
    static int minHeight = Integer.MAX_VALUE, cnt = 0;
    static boolean isTop = true;

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int height, int sizeN, int sizeM){
        isTop = true;
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 8; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if(map[nextX][nextY] > height){
                    isTop = false;
                } else if(!isVisited[nextX][nextY] && map[nextX][nextY] == height){
                    isVisited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
        if(isTop && height > minHeight) cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!isVisited[i][j]){
                    bfs(i, j, map[i][j], n, m);
                }
            }
        }
        System.out.println(cnt);
    }
}