import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class revegetate {

	static class Edge {

		int v;
		boolean same;

		public Edge(int v, boolean same) {
			this.v = v;
			this.same = same;
		}

	}

	static boolean[] vis;
	static int[] color;
	static boolean impos = false;

	public static void dfs(ArrayList<Edge>[] graph, int v) {

		if (impos) {
			return;
		}

		vis[v] = true;
		for (Edge e : (ArrayList<Edge>) graph[v]) {

			if (color[e.v] == -1) {
				color[e.v] = e.same ? color[v] : Math.abs(color[v] - 1);
			} else if (color[e.v] == color[v] && !e.same) {
				impos = true;
			} else if (color[e.v] != color[v] && e.same) {
				impos = true;
			}

			if (!vis[e.v]) {
				dfs(graph, e.v);
			}
		}

	}

	public static int countSeg(ArrayList<Edge>[] graph) {
		int sum = 0;
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				color[i] = 0;
				dfs(graph, i);
				sum++;
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("revegetate.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));

		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<Edge>[] graph = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		vis = new boolean[n];
		color = new int[n];
		Arrays.fill(color, -1);

		for (int i = 0; i < m; i++) {
			boolean same = sc.next().equals("S") ? true : false;
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			graph[u].add(new Edge(v, same));
			graph[v].add(new Edge(u, same));

		}

		int k = countSeg(graph);

		if (impos) {
			out.println(0);
		} else {
			out.print(1);
			for (int i = 0; i < k; i++) {
				out.print(0);
			}
			out.println();
		}

		out.close();
		sc.close();

	}

}
