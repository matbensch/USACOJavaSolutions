import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class helpcross {

	static class Chicken implements Comparable<Chicken> {
		int index = 0;
		int time = 0;
		boolean vis = false;

		public Chicken(int index, int time) {
			this.index = index;
			this.time = time;
		}

		@Override
		public int compareTo(Chicken o) {
			if (this.time != o.time) {
				return this.time - o.time;
			}
			return this.index - o.index;
		}

	}

	static class Cow implements Comparable<Cow> {
		int index = 0;
		int start = 0;
		int end = 0;
		boolean vis = false;

		public Cow(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Cow o) {
			if (this.end != o.end) {
				return this.end - o.end;
			}
			return this.index - o.index;
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("helpcross.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));

		int c = sc.nextInt();
		int n = sc.nextInt();

		Chicken[] carr = new Chicken[c];
		Cow[] narr = new Cow[n];

		for (int i = 0; i < c; i++) {
			carr[i] = new Chicken(i, sc.nextInt());
		}

		for (int i = 0; i < n; i++) {
			narr[i] = new Cow(i, sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(carr);
		Arrays.sort(narr);

		int sum = 0;

		for (int j = 0; j < c; j++) {
			for (int i = 0; i < n; i++) {
				if (!narr[i].vis && carr[j].time >= narr[i].start && carr[j].time <= narr[i].end) {
					sum++;
					narr[i].vis = true;
					break;
				}
			}
		}

		out.println(sum);
		out.close();
	}
}