//No2559_수열_정답_본계에 제출하기
package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = 0, start = 0, end = k, tmp;
        int[] num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if(i < k) max += num[i];
        }
        tmp = max;

        while (end < n) {
            tmp = tmp - num[start++] + num[end++];
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}