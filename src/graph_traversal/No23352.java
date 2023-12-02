//No23352_방탈출_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No23352 {
    static int[] upDown = {-1, 1, 0, 0}, leftRight = {0, 0, -1, 1};
    static int[][] map, dist;
    static boolean[][] isVisited;
    static Queue<Pair> queue;
    static int maxDist = 0, password = 0;

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

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if(map[nextX][nextY] != 0 && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    dist[nextX][nextY] = dist[currX][currY] + 1;
                    if(dist[nextX][nextY] > maxDist){
                        maxDist = dist[nextX][nextY];
                        password = map[x][y] + map[nextX][nextY];
                    }
                    if(dist[nextX][nextY] == maxDist) {
                        password = Math.max(password, map[x][y] + map[nextX][nextY]);
                    }
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
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) continue;
                dist = new int[n][m];
                isVisited = new boolean[n][m];
                queue = new LinkedList<>();
                bfs(i, j, n, m);
            }
        }

        System.out.println(password);
    }
}