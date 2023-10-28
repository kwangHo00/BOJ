//No20291_파일 정리_정답
package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, Integer> answer = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String extension = "";

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();

            while(st.hasMoreTokens()) extension = st.nextToken();

            if(answer.containsKey(extension)) {
                int num = answer.get(extension);
                answer.put(extension, num + 1);
            }
            else answer.put(extension, 1);
        }

        ArrayList<String> keyList = new ArrayList<>(answer.keySet());
        keyList.sort(Comparator.naturalOrder());
        for (String key : keyList) {
            System.out.println(key + " " + answer.get(key));
        }
    }
}