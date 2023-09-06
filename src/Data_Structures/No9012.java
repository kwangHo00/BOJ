//No9012_괄호_정답
package Data_Structures;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class No9012 {
    static boolean checkVPS(String s){
        Stack<Character> stack = new Stack<>();
        int length = s.length();

        for(int i = 0; i < length; i++){
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            if(s.charAt(i) == ')') {
                if(stack.empty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) System.out.println(checkVPS(sc.next()) ? "YES" : "NO");
    }
}