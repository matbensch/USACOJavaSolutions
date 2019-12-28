import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mootube {

	public static class Edge {

		int q;
		int r;

		public Edge(int q, int r) {
			this.q = q;
			this.r = r;
		}

	}

	public static int bfs(ArrayList<Edge>[] graph, int v, int k) {
		int n = graph.length;
		int sum = 0;
		int[] distance = new int[n];

		Arrays.fill(distance, -1);
		distance[v] = (int) 1e9;
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);

		while (q.size() > 0) {
			int cur = q.poll();
			for (Edge next : (ArrayList<Edge>) graph[cur]) {
				if (distance[next.q] == -1) {
					distance[next.q] = Math.min(distance[cur], next.r);
					if (distance[next.q] >= k) {
						sum++;
						q.offer(next.q);
					}
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader("mootube.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));

		int n = sc.nextInt();
		int q = sc.nextInt();

		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < n - 1; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int r = sc.nextInt();
			graph[u].add(new Edge(v, r));
			graph[v].add(new Edge(u, r));
		}

		for (int i = 0; i < q; i++) {
			int k = sc.nextInt();
			int v = sc.nextInt() - 1;
			out.println(bfs(graph, v, k));
		}

		out.close();
		sc.close();

	}

}
