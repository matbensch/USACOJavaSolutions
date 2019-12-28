import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class pairup {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("pairup.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));

		int n = sc.nextInt();

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			map.put(y, x);

		}

		int min = 0;

		while (map.size() > 0) {
			int a = map.firstKey();
			int b = map.lastKey();

			min = Math.max(a + b, min);
			int rem = Math.min(map.get(a), map.get(b));

			map.put(a, map.get(a) - rem);
			map.put(b, map.get(b) - rem);

			if (map.get(a) < 1)
				map.remove(a);
			if (b != a && map.get(b) < 1)
				map.remove(b);

		}
		out.println(min);

		sc.close();
		out.close();

	}

}
