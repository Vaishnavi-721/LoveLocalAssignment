package Assignment;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * Example 1:
	Input: numRows = 5
	Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
   Example 2:
	Input: numRows = 1
	Output: [[1]]
	 
   Constraints:
	1 <= numRows <= 30
*/

public class PascalTriangle {
	public static void main(String[] args) {

//		Take the input
		int n = 5;

		List<List<Integer>> ans = generate(n);

		for (List<Integer> list : ans) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> ans = new ArrayList<>();

		if (numRows < 1)
			return ans;

		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
				}
			}

			ans.add(list);
		}

		return ans;

	}

}