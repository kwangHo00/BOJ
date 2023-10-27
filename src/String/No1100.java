//No1100_하얀 칸_정답
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1100 {
    static boolean isWhiteSection(int i, int j){
        return ((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 != 0) && (j % 2 != 0));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        char[][] board = new char[8][8];

        for(int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
            for(int j = 0; j < 8; j++) {
                if(isWhiteSection(i, j) && board[i][j] == 'F') answer += 1;
            }
        }

        System.out.println(answer);
    }
}