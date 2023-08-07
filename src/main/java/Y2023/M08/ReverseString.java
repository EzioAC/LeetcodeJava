package Y2023.M08;

public class ReverseString {
	public void reverseString(char[] s) {
		int length = s.length;
		int head = 0;
		int tail = length-1;
		char temp;
		while (head < tail) {
			temp =s[head];
			s[head] = s[tail];
			s[tail] = temp;
			head++;
			tail--;
		}
	}
}
