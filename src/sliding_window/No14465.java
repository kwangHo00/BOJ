//No14465_소가 길을 건너간 이유5_정답_본계에 제출하기
package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] trafficLight = new int[n + 1];
        int start = 1, end = k, total = 0, answer = Integer.MAX_VALUE;

        for(int i = 0; i < b; i++) {
            int idx = Integer.parseInt(br.readLine());
            trafficLight[idx] = -1;
        }

        for(int i = 1; i <= k; i++){
            if(trafficLight[i] == -1) total += 1;
        }

        while (end < n) {
            if (trafficLight[start] == -1) total -= 1;
            if (trafficLight[end + 1] == -1) total += 1;
            start += 1;
            end += 1;
            answer = Math.min(total, answer);
        }
        System.out.println(answer);
    }
}