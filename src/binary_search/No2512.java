//No2512_예산_정답
package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, total, sum = 0, min = 1, max = 0, mid = 0;

        n = Integer.parseInt(br.readLine());

        int[] budget = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }

        total = Integer.parseInt(br.readLine());

        while(min <= max){
            mid = (min + max) / 2;
            sum = 0;

            for(int ele : budget){
                sum += Math.min(ele, mid);
            }

            if(sum <= total) min = mid + 1;
            else max = mid - 1;
        }

        System.out.println(min - 1);
    }
}