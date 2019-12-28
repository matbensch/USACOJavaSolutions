import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class lifeguards {

	public static class Event implements Comparable<Event> {
		int id;
		int time;
		boolean start;

		public Event(int id, int time, boolean start) {
			this.id = id;
			this.time = time;
			this.start = start;
		}

		@Override
		public int compareTo(Event o) {
			return this.time - o.time;
		}

		@Override
		public String toString() {
			return "Event [id=" + id + ", time=" + time + ", start=" + start + "]";
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("lifeguards.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

		int n = sc.nextInt();

		Event[] arr = new Event[2 * n];
		for (int i = 0; i < 2 * n; i += 2) {
			arr[i] = new Event(i / 2, sc.nextInt(), true);
			arr[i + 1] = new Event(i / 2, sc.nextInt(), false);
		}

		Arrays.sort(arr);

		int[] spec = new int[n];

		int active = 0;
		int tot = 0;
		int indact = 0;

		for (int i = 0; i < 2 * n; i++) {
			if (active > 0) {
				tot += arr[i].time - arr[i - 1].time;
			}
			if (active == 1) {
				spec[indact] += arr[i].time - arr[i - 1].time;
			}

			if (arr[i].start) {
				active++;
				indact += arr[i].id;
			} else {
				active--;
				indact -= arr[i].id;
			}

		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, spec[i]);

		}

		out.println(tot - min);

		sc.close();
		out.close();

	}

}
