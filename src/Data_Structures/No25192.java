//No25192_인사성 밝은 곰곰이_정답
package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 0; i < n; i++){
            String string = br.readLine();
            if(string.equals("ENTER")) {
                set.clear();
                continue;
            }
            if(!set.contains(string)) {
                set.add(string);
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}