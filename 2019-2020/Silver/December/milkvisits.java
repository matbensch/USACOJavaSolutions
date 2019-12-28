import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class milkvisits {

	public static int[] countSeg(HashSet<Integer>[] adj, char[] p) {
		int curseg = 0;
		boolean[] vis = new boolean[adj.length];
		int[] seg = new int[adj.length];

		for (int i = 0; i < adj.length; i++) {
			if (!vis[i]) {
				dfs(adj, vis, p, i, seg, curseg);
				curseg++;
			}
		}

		return seg;

	}

	public static void dfs(HashSet<Integer>[] adj, boolean[] vis, char[] p, int v, int[] seg, int c) {
		vis[v] = true;
		seg[v] = c;

		for (Integer e : adj[v]) {
			if (!vis[e] && p[e] == p[v])
				dfs(adj, vis, p, e, seg, c);
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader("milkvisits.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));

		int n = sc.nextInt();
		int m = sc.nextInt();

		char[] p = sc.next().toCharArray();
		HashSet<Integer>[] adj = new HashSet[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			adj[u].add(v);
			adj[v].add(u);
		}

		int[] seg = countSeg(adj, p);

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			char c = sc.next().charAt(0);

			if (seg[u] != seg[v] || p[u] == c) {
				out.print(1);
			} else {
				out.print(0);
			}

		}

		out.close();

	}

}
