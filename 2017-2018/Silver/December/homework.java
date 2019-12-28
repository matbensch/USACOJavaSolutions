import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class homework {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new BufferedReader(new FileReader(("homework.in"))));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] suffixSum = new int[n];
		suffixSum[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			suffixSum[i] = suffixSum[i + 1] + arr[i];

		int[] suffixMin = new int[n];
		suffixMin[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);

		ArrayList<Integer> maxi = new ArrayList<Integer>();
		double max = 0;

		for (int i = 1; i <= n - 2; i++) {
			double temp = (double) (suffixSum[i] - suffixMin[i]) / (double) (n - i - 1);
			if (temp > max) {
				maxi.clear();
				maxi.add(i);
				max = temp;
			} else if (temp == max) {
				maxi.add(i);
			}
		}
		for (Integer i : maxi)
			out.println(i);

		out.close();
		sc.close();

	}

}
