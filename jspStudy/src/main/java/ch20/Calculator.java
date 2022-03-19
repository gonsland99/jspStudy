package ch20;

public class Calculator {
	public void add(int x, int y) {
		int result=x+y;
		System.out.println("덧셈:"+ result);
	}

	public void subtract(int x, int y) {
		int result=x - y;
		System.out.println("뺄셈:"+ result);
	}

	public void multiply(int x, int y) {
		int result=x * y;
		System.out.println("곱셈:"+ result);
	}

	public void divide(int x, int y) {
		int result=x / y;
		System.out.println("나눗셈:"+ result);
	}
}
