package com.reflect;

public class ArithmeticalOperation {
	public ArithmeticalOperation() {
		System.out.println("no arg constructor");
	}

	public ArithmeticalOperation(String id) {
		System.out.println("string arg constructor");
	}

	public int plus(int a, int b) {
		return a + b;
	}

	public int minues(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}
}
