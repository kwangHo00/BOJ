//No6832_Maze _ 두번만에 정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No6832 {
    static final int[] upDownAny = {-1, 1, 0, 0};
    static final int[] leftRightAny = {0, 0, -1, 1};

    static final int[] upDownEW = {0 ,0, 0, 0};
    static final int[] leftRightEW = {0, 0, -1, 1};

    static final int[] upDownNS = {-1, 1, 0, 0};
    static final int[] leftRightNS = {0, 0, 0, 0};

    static char[][] map;
    static boolean[][] isVisited;
    static int[][] dist;
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

            if(map[currX][currY] == '+'){
                for(int i = 0; i < 4; i++){
                    int nextX = currX + upDownAny[i];
                    int nextY = currY + leftRightAny[i];
                    if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                    move(currX, currY, nextX, nextY);
                }
            }

            if(map[currX][currY] == '-'){
                for(int i = 0; i < 4; i++){
                    int nextX = currX + upDownEW[i];
                    int nextY = currY + leftRightEW[i];
                    if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                    move(currX, currY, nextX, nextY);
                }
            }

            if(map[currX][currY] == '|'){
                for(int i = 0; i < 4; i++){
                    int nextX = currX + upDownNS[i];
                    int nextY = currY + leftRightNS[i];
                    if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                    move(currX, currY, nextX, nextY);
                }
            }
        }
    }

    static void move(int currX, int currY, int nextX, int nextY){
        if(map[nextX][nextY] != '*' && !isVisited[nextX][nextY]){
            isVisited[nextX][nextY] = true;
            dist[nextX][nextY] = dist[currX][currY] + 1;
            queue.add(new Pair(nextX, nextY));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            map = new char[n][m];
            isVisited = new boolean[n][m];
            dist = new int[n][m];

            for(int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();
            bfs(0, 0, n, m);

            if(map[n - 1][m - 1] == '*') System.out.println(-1);
            else if((n != 1 && m != 1) && dist[n  - 1][m - 1] == 0) System.out.println(-1);
            else System.out.println(dist[n - 1][m - 1] + 1);
        }
    }
}