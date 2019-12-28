import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class fenceplan {

	static class Cow {
		int x = 0;
		int y = 0;

		boolean vis = false;

		ArrayList<Cow> adj = new ArrayList<Cow>();

		public Cow(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void dfs(Cow[] arr, Cow v) {

		v.vis = true;

		if (v.x < minx)
			minx = v.x;
		if (v.x > maxx)
			maxx = v.x;
		if (v.y < miny)
			miny = v.y;
		if (v.y > maxy)
			maxy = v.y;

		for (Cow c : v.adj) {
			if (!c.vis) {
				dfs(arr, c);
			}
		}

	}

	static int minx = Integer.MAX_VALUE;
	static int maxx = 0;
	static int miny = Integer.MAX_VALUE;
	static int maxy = 0;

	public static int seg(Cow[] arr) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].vis) {
				dfs(arr, arr[i]);

				int per = 2 * (maxx - minx) + 2 * (maxy - miny);

				if (per < min)
					min = per;

				minx = Integer.MAX_VALUE;
				maxx = 0;
				miny = Integer.MAX_VALUE;
				maxy = 0;

			}

		}

		return min;

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("fenceplan.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));

		int n = sc.nextInt();
		int m = sc.nextInt();

		Cow[] arr = new Cow[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new Cow(sc.nextInt(), sc.nextInt());
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			arr[u].adj.add(arr[v]);
			arr[v].adj.add(arr[u]);

		}

		int ans = seg(arr);

		out.println(ans);

		sc.close();
		out.close();

	}

}
