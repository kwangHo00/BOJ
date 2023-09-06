//No11607_Grid_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11607 {
    static char[][] map;
    static int[][] dist;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int sizeN, int sizeM){
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            int[] upDown = new int[] {-(map[currX][currY] - 48), map[currX][currY] - 48, 0, 0};
            int[] leftRight = new int[] {0, 0, -(map[currX][currY] - 48), map[currX][currY] - 48};

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if(!isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    dist[nextX][nextY] = dist[currX][currY] + 1;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        bfs(0, 0, n, m);
        System.out.println(dist[n - 1][m - 1] == 0 ? "IMPOSSIBLE" : dist[n - 1][m - 1]);
    }
}