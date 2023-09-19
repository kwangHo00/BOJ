//No11448_Ga_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No11448 {
    static final int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
    static char[][] map;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();
    static int answer;

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int sizeN){
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 8; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeN - 1) continue;
                if(map[nextX][nextY] == '-' && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                    answer += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            map = new char[n][n];
            isVisited = new boolean[n][n];
            answer = 0;

            for(int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == 'w' && !isVisited[i][j]) bfs(i, j, n);
                }
            }
            System.out.println(answer);
        }
    }
}