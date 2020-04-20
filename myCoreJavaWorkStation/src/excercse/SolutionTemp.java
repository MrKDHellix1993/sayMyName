package excercse;

import java.util.ArrayList;
import java.util.Iterator;

public class SolutionTemp {
	public static ArrayList<Integer> solve(int[] A, int[] B) {
		ArrayList<Integer> sol = null;
		if (null != B) {
			int k = 0;
			sol = new ArrayList<Integer>();
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
							A[i] = A[i] - 1;
						} else if (A[i] == 0) {
							++i;
						}

					}
					int count = 0;
					for (int j = 0; j < A.length; j++) {
						if (A[j] == 0)
							++count;
					}
					sol.add(count);
				}

			}
		}
		if (sol != null) {
			A = new int[sol.size()];
			Iterator<Integer> itr = sol.iterator();
			for (int j = 0; j < A.length; j++) {
				A[j] = itr.next().intValue();
			}
		}
		return sol;
	}
	
	public static void main(String[] a) {
		/*
		 * int A[] = { 10, 10, 5, 5 }; int B[] = { 2, 2, 2, 4, 2, 4, 4, 3, 4, 1, 4, 1 };
		 */
		int A[] = { 8, 8, 5, 11, 6 , 4 ,10 , 3 };
		int B[] = { 8, 4, 3, 6, 2, 1, 6, 8, 6, 5, 4, 1 };
		System.out.println(solve(A, B));
	}
}