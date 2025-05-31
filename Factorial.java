

public class Factorial {
	public static void main(String[] args) {
		Integer number = Integer.valueOf(args[0]);
		
		System.out.println("Factorial: " + factorialInteractive(number));
	}
	
	public static Integer factorial(Integer number) {
		if (number == 1) {
			return number;
		}
		
		return number * factorial(number - 1);
	}
	
	public static Integer factorialInteractive(Integer number) {
		Integer result = number;
		while(number > 1) {
			number--;
			result = result * number;
		}
	
		return result;
	}
}