//No5931_Cow Beauty Pageant _ 정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5931 {
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static int[][] dist;
    static char[][] map;
    static boolean[][] isVisited;
    static int minDist = 1_000_000_000;

    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int sizeN, int sizeM){
        isVisited = new boolean[sizeN][sizeM];
        dist = new int[sizeN][sizeM];
        queue.clear();

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
                if(map[nextX][nextY] == 'A'){
                    minDist = Math.min(minDist, dist[currX][currY]);
                    return;
                }
                if(map[nextX][nextY] == '.' && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    dist[nextX][nextY] = dist[currX][currY] + 1;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    static void grouping(int x, int y, int sizeN, int sizeM){
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        map[x][y] = 'A';

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if(map[nextX][nextY] == 'X' && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    map[nextX][nextY] = 'A';
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
        isVisited = new boolean[n][m];

        int tempX = -1, tempY = -1;
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'X'){
                    tempX = i;
                    tempY = j;
                }
            }
        }

        grouping(tempX, tempY, n, m);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'X') bfs(i, j, n, m);
            }
        }
        System.out.println(minDist);
    }
}