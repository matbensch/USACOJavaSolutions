import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class highcard {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("highcard.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));

		int n = sc.nextInt();

		TreeSet<Integer> e = new TreeSet<Integer>();
		TreeSet<Integer> b = new TreeSet<Integer>();

		boolean[] elsie = new boolean[2 * n];

		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt() - 1;
			e.add(temp);
			elsie[temp] = true;
		}

		for (int i = 0; i < 2 * n; i++) {

			if (!elsie[i]) {
				b.add(i);
			}

		}

		int sum = 0;

		for (int ec : e) {
			Integer bc = b.ceiling(ec);

			if (bc instanceof Integer) {
				sum++;
				b.remove(bc);
			}

		}

		out.println(sum);

		sc.close();
		out.close();

	}

}
