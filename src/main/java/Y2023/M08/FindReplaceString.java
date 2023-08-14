package Y2023.M08;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FindReplaceString {
	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
		Map<Integer,Integer> sortedIndiceMaps = new HashMap<>();
		for (int i = 0; i < indices.length; i++) {
			sortedIndiceMaps.put(indices[i], i);
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < s.toCharArray().length; i++) {
			if(sortedIndiceMaps.containsKey(i)) {
				int index = sortedIndiceMaps.get(i);
				String source = sources[index];
				String target = targets[index];
				if( s.substring(i,i+source.length()).equals(source)) {
					stringBuilder.append(target);
					i+=source.length()-1;
					continue;
				}
			}
			stringBuilder.append(s.charAt(i));

		}
		return stringBuilder.toString();
	}

	@Test
	public void test() {
		FindReplaceString findReplaceString = new FindReplaceString();
		System.out.println(
				findReplaceString.findReplaceString("abcd",new int[]{0,2},new String[]{"a","cd"},new String[]{"eee","ffff"}))
		;
	}

	@Test
	public void test1() {
		FindReplaceString findReplaceString = new FindReplaceString();
		System.out.println(
				findReplaceString.findReplaceString("abcd",new int[]{0,2},new String[]{"ab","ec"},new String[]{"eee","ffff"}))
		;
	}
}
