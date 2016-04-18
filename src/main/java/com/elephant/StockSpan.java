package com.elephant;

import static com.elephant.util.Print.*;

import com.elephant.data_structure.stack.*;

/**
 * Stock span
 * <p>
 * stack method,maintain a decreasing stack
 * <p>
 * Linear Time complexity
 */

public class StockSpan {
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();
		Double[] stock = {100.0, 65.0, 65.0, 85.0, 80.0, 185.0};
		Integer[] res = new Integer[stock.length];
		Stack stack = new ArrayStack();

		// push first day into stack
		stack.push(0);
		res[0] = 1;

		// traverse from the second element
		for (int i = 1; i < stock.length; i++) {
			while (!stack.isEmpty() && stock[i] > stock[(int) stack.top()]) {
				stack.pop();
			}
			if (stack.isEmpty())
				res[i] = i + 1;
			else {
				res[i] = i - (int) stack.top();
			}
			stack.push(i);
		}


		for (Integer i : res) {
			printnb(i + ", ");
		}


		double endTime = System.currentTimeMillis();
		print("程序运行时间： " + (endTime - startTime) / 1000 + "秒");
	}
}
