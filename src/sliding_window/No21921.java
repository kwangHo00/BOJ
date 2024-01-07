//No21921_블로그_두번만에 정답_period 초기값 잘못 설정
package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visitant = new int[n];
        int start = 0, end = x, max = 0, tmp = 0, period = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            visitant[i] = Integer.parseInt(st.nextToken());
            if(i < x) max += visitant[i];
        }

        tmp = max;

        while(end < n){
            tmp = tmp - visitant[start++] + visitant[end++];
            if(tmp > max){
                max = tmp;
                period = 1;
            }
            else if(tmp == max) period += 1;
        }

        System.out.println(max != 0 ? max + "\n" + period : "SAD");
    }
}