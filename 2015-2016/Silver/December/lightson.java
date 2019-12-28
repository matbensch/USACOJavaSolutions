import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class lightson {

	static boolean[][] vis;
	static boolean[][] lit;
	static ArrayList<Point>[][] adj;

	public static boolean isAvail(int x, int y) {

		if (x > 0 && vis[x - 1][y]) {
			return true;
		}
		if (x < vis.length - 1 && vis[x + 1][y]) {
			return true;
		}
		if (y > 0 && vis[x][y - 1]) {
			return true;
		}
		if (y < vis[0].length - 1 && vis[x][y + 1]) {
			return true;
		}
		return false;

	}

	public static void dfs(int x, int y) {

		if (vis[x][y])
			return;

		vis[x][y] = true;

		for (Point p : adj[x][y]) {
			if (!lit[p.x][p.y]) {
				lit[p.x][p.y] = true;
				if (isAvail(p.x, p.y)) {
					dfs(p.x, p.y);
				}
			}

		}

		if (x > 0 && !vis[x - 1][y] && lit[x - 1][y]) {

			dfs(x - 1, y);
		}
		if (x < vis.length - 1 && !vis[x + 1][y] && lit[x + 1][y]) {

			dfs(x + 1, y);
		}
		if (y > 0 && !vis[x][y - 1] && lit[x][y - 1]) {

			dfs(x, y - 1);
		}
		if (y < vis[0].length - 1 && !vis[x][y + 1] && lit[x][y + 1]) {

			dfs(x, y + 1);
		}

		for (Point p : adj[x][y]) {
			if (isAvail(p.x, p.y)) {
				dfs(p.x, p.y);
			}
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("lightson.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));

		int n = sc.nextInt();
		int m = sc.nextInt();

		vis = new boolean[n][n];
		lit = new boolean[n][n];
		adj = new ArrayList[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adj[i][j] = new ArrayList<Point>();
			}
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			adj[x][y].add(new Point(a, b));

		}

		lit[0][0] = true;

		dfs(0, 0);
		int sum = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (lit[i][j]) {
					sum++;
				}

			}

		}

		out.println(sum);

		sc.close();
		out.close();

	}

}
