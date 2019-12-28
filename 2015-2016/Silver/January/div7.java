import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class div7 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("div7.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));

		int n = sc.nextInt();

		long[] arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}

		long[] cum = new long[n + 1];

		cum[0] = 0;

		for (int i = 1; i <= n; i++) {
			cum[i] = cum[i - 1] + arr[i - 1];
		}

		int max = 0;

		for (int i = 1; i < n; i++) {
			for (int j = i + max; j < n; j++) {
				if ((cum[j] - cum[i - 1]) % 7 == 0) {
					max = Math.max(max, j - i);
				}
			}
		}

		out.println(max + 1);
		sc.close();
		out.close();

	}

}
