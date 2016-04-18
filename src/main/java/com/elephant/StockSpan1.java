package com.elephant;

import static com.elephant.util.Print.print;
import static com.elephant.util.Print.printnb;

/**
 * n^2 time conplexity
 */
public class StockSpan1 {
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();
		Double[] stock = {100.0, 65.0, 60.0, 85.0, 80.0, 185.0};
		Integer[] res = new Integer[stock.length];
		res[0] = 1;
		for (int i = 1; i < stock.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (stock[i] < stock[j]) {
					res[i] = i - j;
					break;
				} else if (j == 0 && stock[i] > stock[j]) {
					res[i] = i - j + 1;
				}

			}
		}

		for (Integer i : res)
			printnb(i + ", ");

		double endTime = System.currentTimeMillis();
		print("程序运行时间： " + (endTime - startTime) / 1000 + "秒");
	}
}
