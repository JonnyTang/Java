package com.jonny.java.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Fib implements Algorithm {

	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(fib3(i));
		}
	}

	// 1、使用备忘录
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

	// 2、暴力递归
	public int fib1(int N) {
		if (N == 0) {
			return 0;
		}
		if (N == 1 || N == 2) {
			return 1;
		}

		return fib1(N - 1) + fib1(N - 2);
	}

	// 3、dp数组的迭代解法
	public int fib2(int N) {
		if (N == 0) {
			return 0;
		}
		if (N == 1 || N == 2) {
			return 1;
		}

		ArrayList<Integer> dp = new ArrayList<Integer>(Collections.nCopies(N + 1, 0));
		dp.set(1, 1);
		dp.set(2, 1);
		for (int i = 3; i <= N; i++) {
			dp.set(i, dp.get(i - 1) + dp.get(i - 1));
		}
		return dp.get(N);
	}
	
	// 4、将空间复杂度降为O(1)的迭代解法优化
	public int fib3(int N) {
		if (N == 0) {
			return 0;
		}
		if (N == 1 || N == 2) {
			return 1;
		}

		int prev = 1, curr = 1;
		for (int i = 3; i <= N; i++) {
			int sum = prev + curr;
			prev = curr;
			curr = sum;
		}
		return curr;
	}
}
