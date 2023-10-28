//No7785_회사에 있는 사람_정답
package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, String> log = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String situation = st.nextToken();

            if(situation.equals("enter")) log.put(name, situation);
            if(situation.equals("leave")) log.remove(name);
        }

        ArrayList<String> answer = new ArrayList<>(log.keySet());
        answer.sort(Comparator.reverseOrder());
        for(String list : answer) System.out.println(list);
    }
}