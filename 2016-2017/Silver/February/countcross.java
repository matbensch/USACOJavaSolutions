import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class countcross {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader("countcross.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));

		int n = sc.nextInt();
		int k = sc.nextInt();
		int r = sc.nextInt();

		HashSet<Point>[][] arr = new HashSet[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = new HashSet<Point>();
			}
		}

		for (int i = 0; i < r; i++) {
			int r0 = sc.nextInt() - 1;
			int c0 = sc.nextInt() - 1;
			int r1 = sc.nextInt() - 1;
			int c1 = sc.nextInt() - 1;

			arr[r0][c0].add(new Point(r1, c1));
			arr[r1][c1].add(new Point(r0, c0));
		}

		int[] x = new int[k];
		int[] y = new int[k];

		for (int i = 0; i < k; i++) {
			x[i] = sc.nextInt() - 1;
			y[i] = sc.nextInt() - 1;
		}

		int sum = 0;

		for (int i = 0; i < k; i++) {
			boolean[][] vis = new boolean[n][n];
			dfs(arr, vis, x[i], y[i]);

			for (int j = i + 1; j < k; j++) {
				if (!vis[x[j]][y[j]]) {
					sum++;
				}
			}

		}
		out.println(sum);
		out.close();

	}

	public static void dfs(HashSet<Point>[][] arr, boolean[][] vis, int x, int y) {
		vis[x][y] = true;

		if (x > 0 && !vis[x - 1][y] && !arr[x][y].contains(new Point(x - 1, y))) {
			dfs(arr, vis, x - 1, y);
		}
		if (x + 1 < arr.length && !vis[x + 1][y] && !arr[x][y].contains(new Point(x + 1, y))) {
			dfs(arr, vis, x + 1, y);
		}
		if (y > 0 && !vis[x][y - 1] && !arr[x][y].contains(new Point(x, y - 1))) {
			dfs(arr, vis, x, y - 1);
		}
		if (y + 1 < arr.length && !vis[x][y + 1] && !arr[x][y].contains(new Point(x, y + 1))) {
			dfs(arr, vis, x, y + 1);
		}

	}

}