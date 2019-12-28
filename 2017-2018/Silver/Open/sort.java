import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class sort {

	public static class Entry implements Comparable<Entry> {
		int ind;
		int val;

		public Entry(int ind, int val) {
			this.ind = ind;
			this.val = val;
		}

		@Override
		public int compareTo(Entry o) {
			if (this.val != o.val)
				return this.val - o.val;
			return this.ind - o.ind;
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("sort.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));

		int n = sc.nextInt();

		Entry[] arr = new Entry[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new Entry(i, sc.nextInt());
		}

		Arrays.sort(arr);

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i].ind - i);
		}

		out.println(max + 1);

		sc.close();
		out.close();

	}

}
