//No26549_Holes_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No26549 {
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();
    static int sections, spaces;

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
        spaces += 1;

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
                    queue.add(new Pair(nextX, nextY));
                    spaces += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            isVisited = new boolean[n][m];
            sections = 0;
            spaces = 0;

            for(int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == '.' && !isVisited[i][j]){
                        bfs(i, j, n, m);
                        sections += 1;
                    }
                }
            }

            String stringSection = "sections", stringSpace = "spaces";
            if(sections == 1) stringSection = "section";
            if(spaces == 1) stringSpace = "space";

            System.out.println(sections + " " + stringSection + ", " + spaces + " " + stringSpace);
        }
    }
}