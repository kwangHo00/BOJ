//No1302_베스트셀러_정답
package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> title = new HashMap<>();
        List<String> rank = new ArrayList<>();
        int max = 0;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String book = br.readLine();
            if(title.containsKey(book)) title.put(book, title.get(book) + 1);
            if(!title.containsKey(book)) title.put(book, 1);

            int cnt = title.get(book);
            max = Math.max(max, cnt);
        }

        for (String tmp : title.keySet()) {
            if (title.get(tmp) == max) rank.add(tmp);
        }

        Collections.sort(rank);
        System.out.println(rank.get(0));
    }
}