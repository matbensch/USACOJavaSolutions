import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class convention2 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("convention2.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));

		int n = sc.nextInt();

		Comparator<Cow> senior = new Comparator<Cow>() {
			public int compare(Cow o1, Cow o2) {
				return o1.s - o2.s;
			}
		};
		Comparator<Cow> arrival = new Comparator<Cow>() {
			public int compare(Cow o1, Cow o2) {
				if (o1.a != o2.a)
					return o1.a - o2.a;
				return o1.s - o2.s;
			}
		};

		PriorityQueue<Cow> store = new PriorityQueue<Cow>(arrival);
		for (int i = 0; i < n; i++) {
			Cow temp = new Cow();
			temp.s = i;
			temp.a = sc.nextInt();
			temp.t = sc.nextInt();
			store.add(temp);
		}

		PriorityQueue<Cow> cur = new PriorityQueue<Cow>(senior);

		int max = 0;
		int time = store.peek().a;
		cur.add(store.poll());

		while (store.size() > 0) {
			while (store.size() > 0 && store.peek().a <= time)
				cur.add(store.poll());

			Cow myCow = cur.poll();

			max = Math.max(max, Math.abs(time - myCow.a));
			int add = myCow.t;

			if (cur.size() > 0)
				add = Math.max(cur.peek().a - time, add);
			else if (store.size() > 0)
				add = Math.max(store.peek().a - time, add);

			time += add;

		}

		out.println(max);

		sc.close();
		out.close();

	}

	static class Cow implements Comparable<Cow> {
		int s = 0;
		int a = 0;
		int t = 0;

		@Override
		public int compareTo(Cow o) {
			if (this.t != o.t)
				return this.t - o.t;
			return this.s - o.s;
		}

		public String toString() {
			return String.valueOf(a);
		}

	}

}
