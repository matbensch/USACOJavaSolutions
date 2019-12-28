import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class haybales {

	static int[] arr;
	static int n;
	static int q;

	public static int binLow(int l, int r, int x) {

		if (l + 1 == r) {
			if (arr[l] < x) {
				return r;
			}
			return l;
		}

		int mid = (l + r) / 2;

		if (arr[mid] == x)
			return mid;

		if (arr[mid] > x) {
			return binLow(l, mid, x);
		}

		return binLow(mid, r, x);
	}

	public static int binHigh(int l, int r, int x) {

		if (l == r)
			return l;

		if (l + 1 == r) {

			if (arr[r] > x) {
				return l;
			}
			return r;

		}

		int mid = (l + r) / 2;

		if (arr[mid] == x)
			return mid;

		if (arr[mid] > x)
			return binHigh(l, mid - 1, x);
		return binHigh(mid, r, x);

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("haybales.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

		int n = sc.nextInt();
		int q = sc.nextInt();

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int u = binLow(0, n - 1, a);
			int v = binHigh(0, n - 1, b);

			if (u == v && (arr[u] > b || arr[u] < a))
				out.println(0);
			else
				out.println(binHigh(0, n - 1, b) - binLow(0, n - 1, a) + 1);

		}

		out.close();

	}

}
