//No5993_Invasion of the Milkweed_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5993 {
    static final int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
    static char[][] map;
    static int[][] dist;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();
    static int answer = 0;

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

            for(int i = 0; i < 8; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if(map[nextX][nextY] == '.' && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    dist[nextX][nextY] = dist[currX][currY] + 1;
                    answer = Math.max(answer, dist[nextX][nextY]);
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        bfs(n - s2, s1 - 1, n, m);
        System.out.println(answer);
    }
}