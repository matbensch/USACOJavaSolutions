import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class moobuzz {

	public static long f(long n) {
		return n - n / 3 - n / 5 + n / 15;
	}

	public static long bs(long low, long high, long x) {

		if (high < low)
			return low;

		if (low == high)
			return low;

		if (high - low == 1) {
			if (f(low) == x)
				return low;
			return high;
		}

		long mid = (low + high) / 2;

		if (f(mid) == x)
			return mid;

		if (f(mid) > x) {
			return bs(low, mid - 1, x);
		}
		return bs(mid, high, x);

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader("moobuzz.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));

		long n = sc.nextLong();
		long x = bs(0, Long.MAX_VALUE, n);

		if (f(x - 1) == n) {
			out.println(x - 1);
		} else {
			out.println(x);
		}
		out.close();

	}

}
