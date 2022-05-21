package com.jonny.java.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Fib implements Algorithm {

	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(fib(i));
		}
	}

	public int fib(int N) {
		if (N == 0) {
			return 0;
		}

		ArrayList<Integer> memo = new ArrayList<Integer>(Collections.nCopies(N + 1, 0));
		return helper(memo, N);
	}

	public int helper(ArrayList<Integer> memo, int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (memo.get(n) != 0) {
			return memo.get(n);
		}

		memo.set(n, helper(memo, n - 1) + helper(memo, n - 2));

		return memo.get(n);
	}
}
