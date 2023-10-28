//No10866_덱_정답
package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No10866 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int num;
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order){
                case "push_back" : {
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                }
                case "push_front" : {
                    num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                }
                case "pop_front" : {
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.poll());
                    break;
                }
                case "pop_back" : {
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollLast());
                    break;
                }
                case "size" : {
                    System.out.println(deque.size());
                    break;
                }
                case "empty" : {
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                }
                case "front" : {
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekFirst());
                    break;
                }
                case "back" : {
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekLast());
                    break;
                }
            }
        }
    }
}