package testDemo;

import java.util.ArrayList;
import java.util.Iterator;

public class SolutionScaler {
	public static int[] solve(int[] A, int[] B) {
		ArrayList<Integer> sol = new ArrayList<Integer>();
		if (null != B) {
			int k = 0;
			ArrayList<Integer> div = new ArrayList<Integer>();

			for (int p = 0; p < B.length; p++) {
				k = B[p];
				div.clear();
				if (k != 0) {
					for (int a = 1; a <= k; a++) {
						if (k % a == 0) {
							div.add(a);
						}
					}
					for (int i = 0; i < div.size(); i++) {
						if (A[i] != 0) {
							if (A[i] > div.get(0)) {
								A[i] = A[i] - div.get(0);
							} else {
								A[i] = div.get(0) - A[i];
							}
						} else if(A[i] == 0) {
							i++;
						}
					}
					int count = 0;
					for (int ak = 0; ak < A.length; ak++) {
						if (A[ak] == 0) {
							++count;
						}
					}
					sol.add(count);
				}

			}
		}
		int[] ret = new int[sol.size()];
	    Iterator<Integer> iterator = sol.iterator();
	    for (int i = 0; i < ret.length; i++)
	    {
	        ret[i] = iterator.next().intValue();
	    }
		return ret;
	}

	public static void main(String[] a) {
		int A[] = { 10, 10, 5, 5 };
		int B[] = { 2, 2, 2, 4, 2, 4, 4, 3, 4, 1, 4, 1 };
		System.out.println(solve(A, B));
	}
}
