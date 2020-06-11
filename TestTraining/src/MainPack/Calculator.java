package MainPack;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {

	private static Calculator instance = new Calculator();

	Stack<Double> variables;
	Stack<Character> operators;
	HashMap<Character, Integer> order;

	public Calculator() {
		variables = new Stack<>();
		operators = new Stack<>();
		order = new HashMap<>();

		order.put('+', 1);
		order.put('-', 1);
		order.put('*', 2);
		order.put('/', 2);
		order.put('^', 3);
		order.put('(', 4);
		order.put(')', 1);
	}

	public double calculate(String eq) {
		eq = eq.trim();

		String var = "";
		for (int i = eq.length() - 1; i >= 0; i--) {
			char x = eq.charAt(i);
			if ('0' <= x && x <= '9' || x == '.')
				var = x + var;
			else {
				if (var.length() > 0)
					variables.add(Double.valueOf(var));
				var = "";
				if (x == '(') {
					while (operators.lastElement() != ')') {
						applyOp();
					}
					operators.pop();
				} else {
					
						
					
					int opOrder = order.get(x);

					while (operators.size() != 0 && opOrder < order.get(operators.lastElement())) {
						applyOp();
					}
					operators.push(x);
				}
			}
		}

		if (var != "")
			variables.add(Double.valueOf(var));

		while (operators.size() != 0) {
			applyOp();
		}
		double res = variables.pop();
		clear();
		return res;
	}

	public void clear() {
		variables.clear();
		operators.clear();
	}

	public void applyOp() {
		double a = variables.pop(), b = variables.pop();
		char op = operators.pop();
		if (op == '+')
			variables.push(a + b);
		if (op == '-')
			variables.push(a - b);
		if (op == '*')
			variables.push(a * b);
		if (op == '/')
			variables.push(a / b);
		if (op == '^')
			variables.push(Math.pow(a, b));
	}

	public static Calculator getInstance() {
		return instance;
	}

}
