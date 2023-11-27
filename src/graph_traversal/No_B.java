//No_B_현이의 로봇 청소기_정답

/*백준에서 BufferedReader와, Scanner를 같이 사용하면 런타임에러 발생
정확히는 System.in이 들어간 클래스는 하나만 사용해야 됨
일반적인 상황에서는 두 클래스 모두 동시에 사용해도 상관없음*/

package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_B {
    static int[] upDown = {-1, 1, 0, 0};
    static int[] leftRight = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    static void bfs(int x, int y, int k, int sizeN, int sizeM){
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
                if(Math.abs(map[nextX][nextY] - map[currX][currY]) <= k && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
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
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];
        int answer = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!isVisited[i][j]){
                    bfs(i, j, k, n, m);
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}