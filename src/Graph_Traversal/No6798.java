//No6798_ Knight Hop _ 정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No6798 {
    static final int[] upDown = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] leftRight = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] isVisited = new boolean[8][8];
    static int[][] dist = new int[8][8];
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 8; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > 7 || nextY < 0 || nextY > 7) continue;
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

        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;

        bfs(startX, startY);
        System.out.println(dist[endX][endY]);
    }
}