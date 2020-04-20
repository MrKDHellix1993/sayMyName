package testDemo;

import java.util.ArrayList;

class StrProg1 {
	public static void main(String args[]) {

		String str1 = "523963";
		str1 = parseDectatorInput(str1);
		System.out.println("o/p: " + str1);
	}

	public static String parseDectatorInput(String ip) {
		ArrayList<Integer> freq = new ArrayList<Integer>();
		ArrayList<Integer> charVal = new ArrayList<Integer>();
		StringBuffer opBuf = null;
		if (null != ip && !ip.isEmpty()) {
			char[] ipchar = ip.toCharArray();
			opBuf = new StringBuffer();
			if (ipchar.length % 2 == 0) {
				for (int i = 0; i < ipchar.length; i++) {
					if (i % 2 == 0)
						freq.add(Integer.parseInt(String.valueOf(ipchar[i])));
					else
						charVal.add(Integer.parseInt(String.valueOf(ipchar[i])));
				}
			} else {

			}

			for (int i = 0; i < freq.size(); i++) {
				for (int j = 0; j < freq.get(i); j++) {
					opBuf.append(charVal.get(i));
				}
			}
		}
		if(null != opBuf) {
			ip = opBuf.toString();
		}
		return ip;
	}

}
