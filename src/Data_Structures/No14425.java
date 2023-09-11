//No14425_문자열 집합_정답 _ contains() 메서드는 list보다 set이 훨씬 빠름
package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> list = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        for(int i = 0; i < n; i++){
            String string = br.readLine();
            list.add(string);
        }

        for(int i = 0; i < m; i++){
            String string = br.readLine();
            if(list.contains(string)) answer += 1;
        }

        System.out.println(answer);
    }
}