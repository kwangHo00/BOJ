//No1654_랜선 자르기_두번 만에 정답_자료형 long으로 해줘야 함
package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] cable = new long[k];
        long sum = 0, min = 1, max = 0, mid = 0;

        for(int i = 0; i < k; i++){
            cable[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cable[i]);
        }

        while(min <= max){
            mid = (min + max) / 2;
            sum = 0;

            for(long ele : cable){
                sum += (ele / mid);
            }

            if(sum < n) max = mid - 1;
            else min = mid + 1;
        }
        System.out.println(min - 1);
    }
}