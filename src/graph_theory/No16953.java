//No16953_ A -> B_정답
package graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16953 {
    static Queue<long[]> queue = new LinkedList<>();

    static long bfs(long n, long m){
        queue.add(new long[] {n, 1});

        while(!queue.isEmpty()){
            long num = queue.peek()[0];
            long sequence = queue.peek()[1];
            queue.poll();

            if(num == m) return sequence;
            if(num < m){
                queue.add(new long[] {num * 2, sequence + 1});
                queue.add(new long[] {num * 10 + 1, sequence + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n, m));
    }
}