import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class shuffle {

	static int[] adj;
	static boolean[] vis;
	static boolean[] thisvis;
	static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

	public static int count() {

		int sum = 0;

		for (int i = 0; i < adj.length; i++) {
			if (!vis[i]) {
				sum += dfs(i);
				stack.clear();
				Arrays.fill(thisvis, false);
			}

		}

		return sum;

	}

	public static int dfs(int v) {

		if (vis[adj[v]] && !thisvis[adj[v]])
			return 0;

		if (thisvis[v]) {

			int sum = 0;
			int temp = -1;

			while (temp != v) {
				temp = stack.pollLast();
				sum++;
			}

			return sum;
		}

		vis[v] = true;
		stack.offer(v);
		thisvis[v] = true;

		return dfs(adj[v]);

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("shuffle.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

		int n = sc.nextInt();

		adj = new int[n];
		vis = new boolean[n];
		thisvis = new boolean[n];

		for (int i = 0; i < n; i++) {
			adj[i] = sc.nextInt() - 1;
		}

		out.println(count());

		sc.close();
		out.close();

	}

}
