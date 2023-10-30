//No26533_Tractor Path_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No26533 {
    static int[] moveDown = {0, 1};
    static int[] moveRight = {1, 0};
    static char[][] map;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean getPath(int x, int y, int sizeN){
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 2; i++){
                int nextX = currX + moveDown[i];
                int nextY = currY + moveRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeN - 1) continue;
                if(map[nextX][nextY] == '.' && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
        return isVisited[sizeN - 1][sizeN - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        isVisited = new boolean[n][n];

        for(int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        if(getPath(0, 0, n)) System.out.println("Yes");
        else System.out.println("No");
    }
}