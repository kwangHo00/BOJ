//No1735_분수합_정답
package number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1735 {
	static int gcd(int a, int b) {
		int tmp, n;
		if(a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] num = new int[2][2];
		
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int numerator = num[0][0] * num[1][1] + num[1][0] * num[0][1];
		int denominator = num[0][1] * num[1][1];
		int gcd = gcd(numerator, denominator);
		
		System.out.println(numerator / gcd + " " + denominator / gcd);
	}
}