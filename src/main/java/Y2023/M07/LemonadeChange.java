package Y2023.M07;

import org.junit.jupiter.api.Test;

public class LemonadeChange {
	public boolean lemonadeChange(int[] bills) {
		int count10 = 0;
		int count5 = 0;
		for (int bill : bills) {
			if (bill == 5) {
				count5++;
			} else if (bill == 10) {
				count5--;
				count10++;
			} else {
				count10--;
				count5--;
			}

			if(count10<0) {
				count5-=2;
				count10++;
			}

			if(count5 <0) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		LemonadeChange lemonadeChange = new LemonadeChange();
		System.out.println(
			lemonadeChange.lemonadeChange(new int[]{5,5,5,10,20})
		);
		System.out.println(
				lemonadeChange.lemonadeChange(new int[]{5,5,10,10,20})
		);
	}
}
