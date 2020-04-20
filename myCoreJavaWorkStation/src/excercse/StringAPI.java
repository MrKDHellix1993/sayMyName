package excercse;
import java.io.*;

class StrProg1 {
	public static void main(String args[]) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str1, str2, str3;
		int len1, len2;
		System.out.println("Enter First String: ");
		str1 = br.readLine();
		System.out.println("Enter Second String: ");
		str2 = br.readLine();
		str1 = null;
		len1 = str1.length();
		System.out.println("First String: " + str1 + " length is " + len1);
		len2 = str2.length();
		System.out.println("Second String: " + str2 + " length is " + len2);

	}

}
