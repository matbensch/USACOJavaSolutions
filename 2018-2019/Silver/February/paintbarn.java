import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class paintbarn {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(("paintbarn.in"))));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[][] ps = new int[1001][1001];

		for (int i = 0; i < n; i++) {
			int a, b, c, d;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();

			ps[a][b]++;
			ps[a][d]--;
			ps[c][b]--;
			ps[c][d]++;
		}

		int res = 0;

		for (int i = 0; i <= 1000; i++) {
			for (int j = 0; j <= 1000; j++) {
				if (i > 0)
					ps[i][j] += ps[i - 1][j];
				if (j > 0)
					ps[i][j] += ps[i][j - 1];
				if (i > 0 && j > 0)
					ps[i][j] -= ps[i - 1][j - 1];

				if (ps[i][j] == k)
					res++;

			}
		}

		pw.println(res);
		pw.close();
		sc.close();

	}

}
