import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class mountains {

	public static int[] x;
	public static int[] y;
	public static int n;

	public static boolean visible(int m) {
		for (int i = 0; i < n; i++) {
			if (i != m) {

				if (x[m] < x[i] && y[m] <= x[m] + (y[i] - x[i])) {
					return false;
				}
				if (x[m] > x[i] && y[m] <= -x[m] + (y[i] + x[i])) {
					return false;
				}
				if (x[m] == x[i] && y[m] <= y[i]) {
					return false;
				}

			}
		}

		return true;

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("mountains.in"))));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		n = sc.nextInt();

		x = new int[n];
		y = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (visible(i)) {
				sum++;
			}
		}

		pw.println(sum);
		pw.close();
		sc.close();

	}

}
