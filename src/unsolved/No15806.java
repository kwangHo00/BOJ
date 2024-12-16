//No15806_영우의 기숙사 청소 _ 테스트 케이스는 정답인데 계속 메모리 초과 발생
package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No15806 {
    static final int[] upDown = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] leftRight = {1, 2, 2, 1, -1, -2, -2, -1};
    static char[][] room;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int sizeN){
        int queueSize = queue.size();
        while(queueSize-- > 0){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            for(int i = 0; i < 8; i++){
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 1 || nextX > sizeN || nextY < 1 || nextY > sizeN) continue;
                queue.add(new Pair(nextX, nextY));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        room = new char[n + 1][n + 1];
        for(int i = 0; i <= n; i++) Arrays.fill(room[i], '0');

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Pair(x, y));
        }

        while(t-- > 0) bfs(n);

        while(!queue.isEmpty()){
            int currX = queue.peek().x;
            int currY = queue.peek().y;
            queue.poll();

            room[currX][currY] = '*';
        }

        String answer = "NO";

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(room[a][b] == '*') answer = "YES";
        }

        System.out.println(answer);
    }
}