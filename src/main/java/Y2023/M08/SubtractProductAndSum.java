package Y2023.M08;

public class SubtractProductAndSum {
	public int subtractProductAndSum(int n) {
		int m = 1, s = 0;
		while (n != 0) {
			int x = n % 10;
			n /= 10;
			m *= x;
			s += x;
		}
		return m - s;
	}
}
