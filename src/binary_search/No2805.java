//No2805_나무 자르기_정답
package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] trees = new long[n];
        long sum = 0, max = 0, min = 0, mid = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        while(min < max){
            mid = (max + min) / 2;
            sum = 0;

            for(long tree : trees){
                if(tree - mid > 0) sum += (tree - mid);
            }

            if(sum < m) max = mid;
            else min = mid + 1;
        }

        System.out.println(min - 1);
    }
}