package Y2023.M08;

import java.util.HashSet;
import java.util.Set;

public class FilpGame {
	public int flipgame(int[] fronts, int[] backs) {
		Set<Integer> same = new HashSet<>();

		for (int i = 0; i < fronts.length; i++) {
			if(fronts[i] == backs[i]) {
				same.add(fronts[i]);
			}
		}

		int res = Integer.MAX_VALUE;

		for (int front : fronts) {
			if(same.contains(front)) {
				continue;
			}
			res = Math.min(res,front);
		}

		for (int back : backs) {
			if(same.contains(back)) {
				continue;
			}
			res = Math.min(res,back);
		}

		return res % Integer.MAX_VALUE;
	}
}
