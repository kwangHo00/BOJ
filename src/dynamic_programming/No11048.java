//No11048_이동하기_정답
package dynamic_programming;

import java.io.*;
import java.util.*;
public class No11048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];

        for(int i = 1; i < m; i++) { //맨 위 dp
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        for(int i = 1; i < n; i++) { //맨 왼쪽 dp
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + map[i][j], Math.max(dp[i - 1][j] + map[i][j], dp[i][j - 1] + map[i][j]));
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}