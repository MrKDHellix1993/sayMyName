package testDemo;

public class Solution {
	public static String solve(String A) {
		StringBuffer sb = null;
		if (null != A) {
			sb = new StringBuffer();
			for (int a = 0; a < A.length(); a++) {
				if (Character.isLetter(A.charAt(a))) {
					if (!Character.isUpperCase(A.charAt(a))) {
						if ((A.charAt(a) == 'a' || A.charAt(a) == 'e' || A.charAt(a) == 'i' || A.charAt(a) == 'o'
								|| A.charAt(a) == 'u')) {
							sb.append("#");
						} else {
							sb.append(A.charAt(a));
						}
					}
				}
			}
			sb.append(sb);

		}
		return sb.toString();
	}
	
	public static void main( String [] a) {
		System.out.println( solve("AbcaZeoB"));
	}
}
