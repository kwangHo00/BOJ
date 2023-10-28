//No10820_문자열 분석_정답
package implementation;

import java.util.Scanner;

public class No10820 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String string = sc.nextLine();
            int length = string.length();

            int upper = 0, lower = 0, num = 0, blank = 0;

            for(int i = 0; i < length; i++){
                char c = string.charAt(i);
                if(c >= 'a' && c <= 'z') lower += 1;
                if(c >= 'A' && c <= 'Z') upper += 1;
                if(c >= '0' && c <= '9') num += 1;
                if(c == ' ') blank += 1;
            }
            System.out.println(lower + " " + upper + " " + num + " " + blank);
        }
    }
}