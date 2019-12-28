import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class bcount {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("bcount.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));

		int n = sc.nextInt();
		int q = sc.nextInt();

		int[] h = new int[n];
		int[] g = new int[n];
		int[] j = new int[n];

		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			if (temp == 1) {
				h[i] = 1;
			} else if (temp == 2) {
				g[i] = 1;
			} else if (temp == 3) {
				j[i] = 1;
			}
		}

		int[] cumh = new int[n + 1];
		int[] cumg = new int[n + 1];
		int[] cumj = new int[n + 1];

		cumh[0] = 0;
		cumg[0] = 0;
		cumj[0] = 0;

		for (int i = 1; i <= n; i++) {
			cumh[i] = h[i - 1] + cumh[i - 1];
			cumg[i] = g[i - 1] + cumg[i - 1];
			cumj[i] = j[i - 1] + cumj[i - 1];
		}

		for (int i = 0; i < q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			out.println((cumh[b] - cumh[a - 1]) + " " + (cumg[b] - cumg[a - 1]) + " " + (cumj[b] - cumj[a - 1]));

		}

		out.close();
		sc.close();

	}

}
