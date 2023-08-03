package Y2023.M08;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	public List<String> removeComments(String[] source) {
		boolean inBlockComment = false;
		StringBuilder stringBuilder = new StringBuilder();
		List<String> res = new ArrayList<>();
		for (String str : source) {
			char lastChar = 0;
			for (int i = 0; i < str.length(); i++) {
				if (inBlockComment) {
					if (lastChar == '*' && str.charAt(i) == '/') {
						inBlockComment = false;
						lastChar = 0;
					} else {
						lastChar = str.charAt(i);
					}
				} else if (lastChar == '/' && str.charAt(i) == '/') {
					stringBuilder.deleteCharAt(stringBuilder.length() - 1);
					break;
				} else if (lastChar == '/' && str.charAt(i) == '*') {
					stringBuilder.deleteCharAt(stringBuilder.length() - 1);
					inBlockComment = true;
				} else {
					lastChar = str.charAt(i);
					stringBuilder.append(str.charAt(i));
				}
			}
			if(!stringBuilder.isEmpty() && !inBlockComment) {
				res.add(stringBuilder.toString());
				stringBuilder.delete(0, stringBuilder.length());
			}
		}
		return res;
	}

	@Test
	public void test() {
		RemoveComments removeComments = new RemoveComments();
		System.out.println(
				JSON.toJSONString(
						removeComments.removeComments(new String[]{
										"/*Test program */",
										"int main()",
										"{ ",
										"  // variable declaration ",
										"int a, b, c;",
										"/* This is a test",
										"   multiline  ",
										"   comment for ",
										"   testing */",
										"a = b + c;", "}"
								}
						)
				)
		);
		System.out.println(
				JSON.toJSONString(
						removeComments.removeComments(new String[]{
								"a/*comment", "line", "more_comment*/b"
								}
						)
				)
		);

		System.out.println(
				JSON.toJSONString(
						removeComments.removeComments(new String[]{
									"a//*b//*c","blank","d/*/e*//f"
								}
						)
				)
		);

	}
}
