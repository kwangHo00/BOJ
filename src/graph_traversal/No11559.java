//No11559_Puyo Puyo _ 엄청 여러번만에 정답 _ 50번째, 79번째 줄에서 배열 체크하는 범위는 잘 못 입력했는데 한동안 못찾음
//drop() 메서드는 다른 사람 코드 보고 참고함
package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No11559 {
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static char[][] map = new char[12][6];
    static boolean[][] isVisited = new boolean[12][6];
    static Queue<Pair> queue = new LinkedList<>();
    static boolean isExplode = false;
    static int answer = 0;

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void initFalse(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 6; j++){
                isVisited[i][j] = false;
            }
        }
    }

    static void bfs(int x, int y){
        initFalse();

        int cnt = 1;
        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > 11 || nextY < 0 || nextY > 5) continue;
                if(map[nextX][nextY] == map[x][y] && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    cnt += 1;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }

        if(cnt >= 4){
            isExplode = true;
            explosion(x, y);
        }
    }

    static void explosion(int x, int y){
        initFalse();

        isVisited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > 11 || nextY < 0 || nextY > 5) continue;
                if(map[nextX][nextY] == map[x][y] && !isVisited[nextX][nextY]){
                    isVisited[nextX][nextY] = true;
                    map[nextX][nextY] = '.';
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
        map[x][y] = '.';
    }

    static void drop(){
        int j = 0;
        do {
            for (int i = 11; i >= 0; i--) {
                if(map[i][j] != '.') continue;
                for (int k = 0; k <= i; k++) {
                    if (map[k][j] != '.') {
                        char c = map[i][j];
                        map[i][j] = map[k][j];
                        map[k][j] = c;
                    }
                }
            }
            j++;
        } while (j != 6);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 12; i++) map[i] = br.readLine().toCharArray();

        while(true){
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 6; j++){
                    if(map[i][j] != '.') bfs(i, j);
                }
            }

            if(!isExplode) break;
            else{
                answer += 1;
                drop();
            }

            isExplode = false;
        }

        System.out.println(answer);
    }
}