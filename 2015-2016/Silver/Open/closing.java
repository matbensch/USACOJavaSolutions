import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class closing {

	static ArrayList<Integer>[] graph;
	static boolean vis[];
	static boolean avail[];

	public static void dfs(int v) {

		if (!avail[v])
			return;

		vis[v] = true;

		for (int next : graph[v]) {
			if (!vis[next] && avail[next]) {
				dfs(next);
			}
		}

	}

	public static int countSeg() {

		Arrays.fill(vis, false);

		int sum = 0;

		for (int i = 0; i < graph.length; i++) {

			if (!vis[i] && avail[i]) {
				dfs(i);
				sum++;
			}

		}

		return sum;

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("closing.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));

		int n = sc.nextInt();
		int m = sc.nextInt();

		graph = new ArrayList[n];
		vis = new boolean[n];
		avail = new boolean[n];
		Arrays.fill(avail, true);

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			graph[u].add(v);
			graph[v].add(u);
		}

		int c0 = countSeg();

		if (c0 == 1)
			out.println("YES");
		else
			out.println("NO");

		for (int i = 0; i < n - 1; i++) {
			int temp = sc.nextInt() - 1;
			avail[temp] = false;

			int c = countSeg();

			if (c == 1)
				out.println("YES");
			else
				out.println("NO");

		}

		int fin = sc.nextInt();

		sc.close();
		out.close();

	}

}
