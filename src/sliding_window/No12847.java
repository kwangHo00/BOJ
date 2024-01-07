//No12847_꿀 아르바이트_정답
package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pay = new int[n];
        int start = 0, end = m;
        long max = 0, tmp = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
            if(i < m) max += pay[i];
        }

        tmp = max;

        while (end < n) {
            tmp = tmp - pay[start++] + pay[end++];
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}