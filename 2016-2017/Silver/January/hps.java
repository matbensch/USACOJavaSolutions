import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class hps {

	public static boolean sim(char bessie, char fj) {

		if (bessie == fj)
			return false;

		if (bessie == 'H' && fj == 'P')
			return false;
		if (bessie == 'H' && fj == 'S')
			return true;
		if (bessie == 'P' && fj == 'H')
			return true;
		if (bessie == 'P' && fj == 'S')
			return false;
		if (bessie == 'S' && fj == 'P')
			return true;
		if (bessie == 'S' && fj == 'H')
			return false;
		return false;

	}

	public static int max(int... a) {
		int max = 0;
		for (int i : a) {
			max = Math.max(i, max);
		}
		return max;
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("hps.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

		int n = sc.nextInt();
		char[] fj = new char[n];

		for (int i = 0; i < n; i++)
			fj[i] = sc.next().charAt(0);

		int[] cumh = new int[n + 1];
		int[] cump = new int[n + 1];
		int[] cums = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			cumh[i] = cumh[i - 1] + (fj[i - 1] == 'H' ? 1 : 0);
			cump[i] = cump[i - 1] + (fj[i - 1] == 'P' ? 1 : 0);
			cums[i] = cums[i - 1] + (fj[i - 1] == 'S' ? 1 : 0);
		}

		int hp = 0;
		int hs = 0;
		int ph = 0;
		int ps = 0;
		int sh = 0;
		int sp = 0;
		int max = 0;

		for (int i = 0; i <= n; i++) {
			hp = (cums[i]) + (cumh[n] - cumh[i]);
			hs = (cums[i]) + (cump[n] - cump[i]);
			ph = (cumh[i]) + (cums[n] - cums[i]);
			ps = (cumh[i]) + (cump[n] - cump[i]);
			sh = (cump[i]) + (cums[n] - cums[i]);
			sp = (cump[i]) + (cumh[n] - cumh[i]);
			max = max(hp, hs, ph, ps, sh, sp, max);
		}

		out.println(max);
		sc.close();
		out.close();

	}

}
