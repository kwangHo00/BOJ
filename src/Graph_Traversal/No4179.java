//No4179_불!_정답
package Graph_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No4179 {
    static final int WALL = -1;
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static boolean isOut;
    static int[] answer = new int[2];
    static char[][] map;
    static int[][] fMove, jMove;
    static Queue<Pair> fLoc, jLoc;

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void fireMove(int sizeN, int sizeM){
        while(!fLoc.isEmpty()){
            int currX = fLoc.peek().x;
            int currY = fLoc.peek().y;
            fLoc.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if(fMove[nextX][nextY] == WALL) continue;
                if(fMove[nextX][nextY] == 0){
                    fMove[nextX][nextY] = fMove[currX][currY] + 1;
                    fLoc.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    static void sangMove(int sizeN, int sizeM){
        while(!jLoc.isEmpty()){
            int currX = jLoc.peek().x;
            int currY = jLoc.peek().y;
            jLoc.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) {
                    answer[0] = currX;
                    answer[1] = currY;
                    isOut = true;
                    break;
                }
                if(jMove[nextX][nextY] > 0 || fMove[nextX][nextY] == WALL) continue;
                if(fMove[nextX][nextY] > jMove[currX][currY] + 1 || fMove[nextX][nextY] == 0){
                    jMove[nextX][nextY] = jMove[currX][currY] + 1;
                    jLoc.add(new Pair(nextX, nextY));
                }
            }

            if(isOut) break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isOut = false;
        map = new char[n][m];
        fMove = new int[n][m];
        jMove = new int[n][m];
        fLoc = new LinkedList<>();
        jLoc = new LinkedList<>();

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'J'){
                    jMove[i][j] = 1;
                    jLoc.add(new Pair(i, j));
                }
                if(map[i][j] == 'F'){
                    fMove[i][j] = 1;
                    fLoc.add(new Pair(i, j));
                }
                if(map[i][j] == '#'){
                    fMove[i][j] = WALL;
                    jMove[i][j] = WALL;
                }
            }
        }

        fireMove(n, m);
        sangMove(n, m);

        System.out.println(isOut ? jMove[answer[0]][answer[1]] : "IMPOSSIBLE");
    }
}