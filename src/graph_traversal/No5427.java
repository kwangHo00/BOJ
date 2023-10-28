//No5427_불_정답
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No5427 {
    static final int WALL = -1;
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static boolean isOut;
    static int[] answer = new int[2];
    static char[][] map;
    static int[][] fMove, sMove;
    static Queue<Pair> fLoc, sLoc;

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
        while(!sLoc.isEmpty()){
            int currX = sLoc.peek().x;
            int currY = sLoc.peek().y;
            sLoc.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) {
                    answer[0] = currX;
                    answer[1] = currY;
                    isOut = true;
                    break;
                }
                if(sMove[nextX][nextY] > 0 || fMove[nextX][nextY] == WALL) continue;
                if(fMove[nextX][nextY] > sMove[currX][currY] + 1 || fMove[nextX][nextY] == 0){
                    sMove[nextX][nextY] = sMove[currX][currY] + 1;
                    sLoc.add(new Pair(nextX, nextY));
                }
            }

            if(isOut) break;
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

            isOut = false;
            map = new char[m][n];
            fMove = new int[m][n];
            sMove = new int[m][n];
            fLoc = new LinkedList<>();
            sLoc = new LinkedList<>();

            for(int i = 0; i < m; i++){
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < n; j++){
                    if(map[i][j] == '@'){
                        sMove[i][j] = 1;
                        sLoc.add(new Pair(i, j));
                    }
                    if(map[i][j] == '*'){
                        fMove[i][j] = 1;
                        fLoc.add(new Pair(i, j));
                    }
                    if(map[i][j] == '#'){
                        fMove[i][j] = WALL;
                        sMove[i][j] = WALL;
                    }
                }
            }

            fireMove(m, n);
            sangMove(m, n);

            System.out.println(isOut ? sMove[answer[0]][answer[1]] : "IMPOSSIBLE");
        }
    }
}