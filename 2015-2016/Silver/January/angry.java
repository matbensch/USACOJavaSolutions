import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class angry {

	static int n;
	static int[] arr;
	static int k;

	public static boolean pos(int r) {

		int start = arr[0];
		int end = arr[0];
		int cows = 1;

		for (int j = 1; j < n; j++) {
			end = arr[j];
			if (end - start > 2 * r) {
				start = arr[j];
				cows++;
			}
		}

		return cows <= k;

	}

	public static int binSearch(int low, int high) {
		if (low == high)
			return low;

		if (low + 1 == high) {
			if (pos(low)) {
				return low;
			}
			return high;
		}

		int mid = (low + high) / 2;

		if (pos(mid)) {
			return binSearch(low, mid);
		} else {
			return binSearch(mid + 1, high);
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new FileReader("angry.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

		n = sc.nextInt();
		k = sc.nextInt();

		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		out.println(binSearch(0, (int) 1e9));

		sc.close();
		out.close();

	}

}
