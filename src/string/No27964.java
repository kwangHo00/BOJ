//No27964_콰트로 치즈 피자_2번만에 정답 _ 조건을 잘못 봄
package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No27964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> topping = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = st.nextToken();
            String tmp = str.endsWith("Cheese") ? "ThisIsCheese" : "ThisIsNotCheese";

            if (tmp.equals("ThisIsCheese")) topping.add(str);
        }

        System.out.println(topping.size() >= 4 ? "yummy" : "sad");
    }
}