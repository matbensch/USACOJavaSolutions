import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class maxcross {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("maxcross.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));

		int n = sc.nextInt();
		int k = sc.nextInt();
		int b = sc.nextInt();

		int[] broken = new int[n];

		for (int i = 0; i < b; i++) {
			broken[sc.nextInt() - 1] = 1;
		}

		long[] cum = new long[n + 1];
		cum[0] = 0;

		for (int i = 1; i <= n; i++) {
			cum[i] = cum[i - 1] + broken[i - 1];
		}

		long min = Integer.MAX_VALUE;

		for (int i = k; i <= n; i++) {
			long temp = cum[i] - cum[i - k];
			min = Math.min(min, temp);
		}

		out.println(min);

		sc.close();
		out.close();

	}

}
