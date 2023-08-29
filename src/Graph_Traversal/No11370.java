//No11370_Spawn Of Ungoliant_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11370 {
    static final int[] upDown = {-1, 1, 0 ,0};
    static final int[] leftRight = {0, 0, -1, 1};
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

    static void bfs(int x, int y, int sizeN, int sizeM){
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX  = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if(map[nextX][nextY] == 'T' && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    map[nextX][nextY] = 'S';
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            map = new char[n][m];
            isVisited = new boolean[n][m];
            int[] loc = new int[2];

            for(int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 'S'){
                        loc[0] = i;
                        loc[1] = j;
                    }
                }
            }

            bfs(loc[0], loc[1], n, m);
            for(char[] i : map){
                for(char j : i) System.out.print(j);
                System.out.println();
            }
        }
    }
}
