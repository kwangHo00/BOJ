//No_A_INU 코드 페스티벌 2023 Open Contest_좌석 배치도_정답
package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] seat = new char[10][20];

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 20; j++) seat[i][j] = '.';
        }

        while(n-- > 0){
            String str = br.readLine();
            seat[str.charAt(0) - 65][Integer.parseInt(str.substring(1)) - 1] = 'o';
        }

        for(char[] c1 : seat){
            for(char c2 : c1) System.out.print(c2);
            System.out.println();
        }
    }
}