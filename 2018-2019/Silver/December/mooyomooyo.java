import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mooyomooyo {

	static char[][] grid;
	static ArrayList<Point> loc = new ArrayList<Point>();
	static ArrayList<Point> del = new ArrayList<Point>();
	static boolean[][] vis;

	public static void gravity() {
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 1; j < grid.length; j++) {
				if (grid[j][i] == '0' && grid[j - 1][i] != '0') {
					grid[j][i] = grid[j - 1][i];
					grid[j - 1][i] = '0';
					j = 0;
				}
			}
		}
	}

	public static void floodZero() {

		for (Point p : del) {
			grid[p.x][p.y] = '0';
		}

	}

	public static int floodFill(int x, int y, char goal) {
		if (grid[x][y] != goal) {
			return 0;
		}

		loc.add(new Point(x, y));
		vis[x][y] = true;
		int area = 1;

		if (x > 0 && !vis[x - 1][y] && grid[x - 1][y] == goal) {
			area += floodFill(x - 1, y, goal);
		}
		if (x < grid.length - 1 && !vis[x + 1][y] && grid[x + 1][y] == goal) {
			area += floodFill(x + 1, y, goal);
		}

		if (y > 0 && !vis[x][y - 1] && grid[x][y - 1] == goal) {
			area += floodFill(x, y - 1, goal);
		}
		if (y < grid[0].length - 1 && !vis[x][y + 1] && grid[x][y + 1] == goal) {
			area += floodFill(x, y + 1, goal);
		}

		return area;

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("mooyomooyo.in"))));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));

		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		grid = new char[n][10];
		vis = new boolean[n][10];

		for (int i = 0; i < n; i++) {
			grid[i] = sc.nextLine().toCharArray();
		}

		gravity();
		boolean found = true;
		while (found) {
			found = false;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (!vis[i][j] && grid[i][j] != '0') {
						int temp = floodFill(i, j, grid[i][j]);
						if (temp >= k) {
							del.addAll(loc);
							found = true;

						}
						loc.clear();
						for (boolean[] v : vis) {
							Arrays.fill(v, false);
						}

					}

				}
			}

			floodZero();
			del.clear();
			gravity();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				pw.print(grid[i][j]);
			}
			pw.println();
		}
		pw.close();
		sc.close();

	}

}
