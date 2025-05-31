public class Fibonacci {
	public static void main(String[] args) {
		Integer index = Integer.valueOf(args[0]);
		
		System.out.println("Fibonacci: " + fibonacciInteractive(index));
	}
	
	public static Integer fibonacci(Integer index) {
		if (index <= 1) {
			return index;
		}
		
		return fibonacci(index - 1) + fibonacci(index - 2); 
	}
	
	public static Integer fibonacciInteractive(Integer index) {
		if (index == 1) {
			return 1;
		}
		
		Integer lastNumber = 1;
		Integer lastLastNumber = 0;
		Integer result = lastLastNumber;
		for (int i = 1; i < index; i++) {
			result = lastNumber + lastLastNumber;
			lastLastNumber = lastNumber;
			lastNumber = result;
		}
		
		return result;
	}
}