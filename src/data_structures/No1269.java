//No1269_대칭 차집합_정답
package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        HashSet<Integer> tmp = new HashSet<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++){
            int value = Integer.parseInt(st.nextToken());
            setA.add(value);
            tmp.add(value);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++){
            int value = Integer.parseInt(st.nextToken());
            setB.add(value);
        }

        setA.removeAll(setB);
        setB.removeAll(tmp);
        System.out.println(setA.size() + setB.size());
    }
}