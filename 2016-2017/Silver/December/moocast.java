import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class moocast {

	static class Cow {

		int x;
		int y;
		int r;

		public Cow(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

	}

	public static double dist(Cow c, Cow o) {
		double res = (c.x - o.x) * (c.x - o.x) + (c.y - o.y) * (c.y - o.y);
		res = Math.sqrt(res);
		return res;
	}

	public static int dfs(Cow[] arr, boolean[] vis, int v) {
		vis[v] = true;
		int sum = 1;

		for (int i = 0; i < arr.length; i++) {
			if (!vis[i] && i != v && dist(arr[v], arr[i]) <= arr[v].r) {
				sum += dfs(arr, vis, i);
			}
		}

		return sum;

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("moocast.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

		int n = sc.nextInt();

		Cow[] arr = new Cow[n];

		for (int i = 0; i < n; i++) {
			Cow c = new Cow(sc.nextInt(), sc.nextInt(), sc.nextInt());
			arr[i] = c;
		}

		int max = 0;

		boolean[] vis = new boolean[n];

		for (int i = 0; i < n; i++) {
			int temp = dfs(arr, vis, i);
			if (temp > max) {
				max = temp;
			}
			Arrays.fill(vis, false);
		}

		out.println(max);

		out.close();
		sc.close();

	}

}
