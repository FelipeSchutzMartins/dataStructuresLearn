public BubbleSort {
	
	public static void main(String[] args) {
		int[] intArr = {1,2,6,5,8,7,9};
		
		
		for (int i=0; i < intArr.length; i++) {
			for (int j=0; j < intArr.length - 1 - i; j++) {
				if (intArr[j] > intArr[j +1]) {
					int tempInt = intArr[j + 1];
					intArr[j + 1] = intArr[j];
					intArr[j] = tempInt;
				}
			}
		}
		
		for (int i : intArr) {
			System.out.println(i);
		}
	}
}