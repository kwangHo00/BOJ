//No1822_차집합_두번만에 정답 _ 문제 제대로 안보고 정렬 안해서 틀림
package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        List<Integer> tmp;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++) setA.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) setB.add(Integer.parseInt(st.nextToken()));

        setA.removeAll(setB);
        tmp = new ArrayList<>(setA);
        Collections.sort(tmp);

        Iterator<Integer> iter = tmp.iterator();

        if(!tmp.isEmpty()) {
            System.out.println(tmp.size());
            while(iter.hasNext()) System.out.print(iter.next() + " ");
        }
        else System.out.println(0);
    }
}