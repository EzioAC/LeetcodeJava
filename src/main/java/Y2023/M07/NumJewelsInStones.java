package Y2023.M07;

import org.junit.jupiter.api.Test;

public class NumJewelsInStones {

	public int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		byte[] jewelTable = new byte[128];
		for (int i = 0; i < jewels.length(); i++) {
			jewelTable[jewels.charAt(i)-'A']=1;
		}
		for (int i=0;i<stones.length();i++) {
			if(jewelTable[stones.charAt(i)-'A'] == 1) {
				count++;
			}
		}
		return count;
	}

	@Test
	public void test() {
		NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
		System.out.println(	numJewelsInStones.numJewelsInStones("zZ","ZZ"));
	}

	
}
