//No29634_Hotel_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No29634 {
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static char[][] map;
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
        int tmp = 1;
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
                if(map[nextX][nextY] == '.' && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    tmp += 1;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }

        answer = Math.max(answer, tmp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '.' && !isVisited[i][j]) bfs(i, j, n, m);
            }
        }

        System.out.println(answer == 0 ? -1 : answer);
    }
}