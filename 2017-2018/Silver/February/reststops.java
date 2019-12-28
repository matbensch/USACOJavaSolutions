import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class reststops {

	static class stop {
		long x;
		long c;
		boolean isMax = false;

		public stop(long x, long c) {
			this.x = x;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("reststops.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));

		long l = sc.nextInt();
		int n = sc.nextInt();
		long rf = sc.nextInt();
		long rb = sc.nextInt();

		stop[] arr = new stop[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new stop(sc.nextInt(), sc.nextInt());
		}

		long max = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i].c > max) {
				arr[i].isMax = true;
				max = arr[i].c;
			}
		}

		long x = 0;

		long sum = 0;
		long df = rf - rb;

		for (int i = 0; i < n; i++) {
			if (arr[i].isMax) {
				long dx = arr[i].x - x;
				sum += arr[i].c * dx * df;
				x = arr[i].x;
			}
		}

		out.println(sum);

		sc.close();
		out.close();

	}

}
